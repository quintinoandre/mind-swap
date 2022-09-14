package academy.mindswap.school.controllers;

import academy.mindswap.school.commands.jwt.JwtRequestDto;
import academy.mindswap.school.commands.jwt.JwtResponseDto;
import academy.mindswap.school.configs.JwtTokenUtil;
import academy.mindswap.school.exceptions.authentication.AuthenticationBadRequestException;
import academy.mindswap.school.services.JwtUserDetailsService;
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

import javax.validation.Valid;

import static academy.mindswap.school.exceptions.authentication.AuthenticationExceptionMessages.AUTHENTICATION_NULL;
import static academy.mindswap.school.utils.PrintValidationErrors.printValidationErrors;

/**
 * the POST API gets username and password in the body
 * using Spring Authentication Manager we authenticate the username and password
 * if the credentials are valid, a JWT token is created using the JWTTokenUtil and provided to the client
 */
@RestController
@RequestMapping("api/v1/authenticate")
@CrossOrigin
public class JwtAuthenticationControllerImpl implements JwtAuthenticationController {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final JwtUserDetailsService jwtUserDetailsService;

    @Autowired
    public JwtAuthenticationControllerImpl(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil,
                                           JwtUserDetailsService jwtUserDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.jwtUserDetailsService = jwtUserDetailsService;
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    @Override
    @PostMapping
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

        final String token = jwtTokenUtil.generateToken(userDetails);

        return new ResponseEntity<>(new JwtResponseDto(token), HttpStatus.OK);
    }
}
