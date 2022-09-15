package academy.mindswap.school.controllers;

import academy.mindswap.school.commands.jwt.JwtRequestDto;
import academy.mindswap.school.commands.jwt.JwtResponseDto;
import academy.mindswap.school.exceptions.authentication.AuthenticationBadRequestException;
import academy.mindswap.school.services.JwtUserDetailsService;
import academy.mindswap.school.utils.JwtUtil;
import io.jsonwebtoken.impl.DefaultClaims;
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

import static academy.mindswap.school.exceptions.authentication.AuthenticationExceptionMessages.*;
import static academy.mindswap.school.utils.PrintValidationErrors.printValidationErrors;

/**
 * the POST API gets username and password in the body
 * using Spring Authentication Manager we authenticate the username and password
 * if the credentials are valid, a JWT token is created using the JWTTokenUtil and provided to the client
 */
@RestController
@RequestMapping("api/v1")
@CrossOrigin
public class JwtAuthenticationControllerImpl implements JwtAuthenticationController {
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final JwtUserDetailsService jwtUserDetailsService;

    @Autowired
    public JwtAuthenticationControllerImpl(AuthenticationManager authenticationManager, JwtUtil jwtUtil,
                                           JwtUserDetailsService jwtUserDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.jwtUserDetailsService = jwtUserDetailsService;
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

    @Override
    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@Valid @RequestBody JwtRequestDto authenticationRequest,
                                                       BindingResult bindingResult) throws Exception {
        if (authenticationRequest == null) {
            throw new AuthenticationBadRequestException(AUTHENTICATION_NULL);
        }

        if (bindingResult.hasErrors()) {
            return printValidationErrors(bindingResult);
        }

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtUtil.generateToken(userDetails);

        return new ResponseEntity<>(new JwtResponseDto(token), HttpStatus.OK);
    }

    @Override
    @GetMapping("/refreshtoken")
    public ResponseEntity<?> refreshtoken(HttpServletRequest request) {
        if (request == null) {
            throw new AuthenticationBadRequestException(REQUEST_NULL);
        }

        // from the HttpRequest get the claims
        DefaultClaims claims = (DefaultClaims) request.getAttribute("claims");

        Map<String, Object> expectedMap = new HashMap<>(claims);

        String token = jwtUtil.doGenerateRefreshToken(expectedMap, expectedMap.get("sub").toString());

        return new ResponseEntity<>(new JwtResponseDto(token), HttpStatus.OK);
    }
}
