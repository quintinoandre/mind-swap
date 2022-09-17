package academy.mindswap.school.controllers;

import academy.mindswap.school.commands.jwtAuthentication.JwtRequestDto;
import academy.mindswap.school.commands.jwtAuthentication.JwtResponseDto;
import academy.mindswap.school.exceptions.authentication.JwtAuthenticationBadRequestException;
import academy.mindswap.school.services.CustomUserDetailsService;
import academy.mindswap.school.utils.JwtUtil;
import io.jsonwebtoken.impl.DefaultClaims;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

import static academy.mindswap.school.exceptions.authentication.JwtAuthenticationExceptionMessages.*;
import static academy.mindswap.school.utils.PrintValidationErrors.printValidationErrors;

/**
 * the POST API gets username and password in the body
 * using Spring Authentication Manager we authenticate the username and password
 * if the credentials are valid, a JWT token is created using the JWTTokenUtil and provided to the client
 */
@Tag(name = "Authentication", description = "The Authentication API. Contains all the operations to generate a JWT" +
        " token and a refresh JWT token")
@RestController
@RequestMapping("api/v1")
@CrossOrigin
public class JwtAuthenticationControllerImpl implements JwtAuthenticationController {
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final CustomUserDetailsService customUserDetailsService;

    @Autowired
    public JwtAuthenticationControllerImpl(AuthenticationManager authenticationManager, JwtUtil jwtUtil,
                                           CustomUserDetailsService customUserDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.customUserDetailsService = customUserDetailsService;
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException exception) {
            throw new Exception(USER_DISABLED, exception);
        } catch (BadCredentialsException exception) {
            throw new Exception(INVALID_CREDENTIALS, exception);
        }
    }

    @Operation(summary = "Generate JWT token", description = "Generate JWT token")
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = JwtResponseDto.class)))
    @Override
    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@Valid @RequestBody JwtRequestDto authenticationRequest,
                                                       BindingResult bindingResult) throws Exception {
        if (authenticationRequest == null) {
            throw new JwtAuthenticationBadRequestException(AUTHENTICATION_NULL);
        }

        if (bindingResult.hasErrors()) {
            return printValidationErrors(bindingResult);
        }

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = customUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtUtil.generateToken(userDetails);

        return new ResponseEntity<>(new JwtResponseDto(token), HttpStatus.OK);
    }

    @Operation(summary = "Generate refresh JWT token", description = "Generate refresh JWT token")
    @SecurityRequirement(name = "bearerAuth")
    @Override
    @GetMapping("/refreshtoken")
    public ResponseEntity<JwtResponseDto> createRefreshToken(@RequestHeader(value = "isRefreshToken", required = true,
            defaultValue = "true") String headerStr, HttpServletRequest request) {
        if (request == null) {
            throw new JwtAuthenticationBadRequestException(REQUEST_NULL);
        }

        // from the HttpRequest get the claims
        DefaultClaims claims = (DefaultClaims) request.getAttribute("claims");

        Map<String, Object> expectedMap = new HashMap<>(claims);

        String token = jwtUtil.doGenerateRefreshToken(expectedMap, expectedMap.get("sub").toString());

        return new ResponseEntity<>(new JwtResponseDto(token), HttpStatus.OK);
    }
}
