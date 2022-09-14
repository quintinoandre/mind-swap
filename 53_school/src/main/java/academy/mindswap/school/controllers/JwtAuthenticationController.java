package academy.mindswap.school.controllers;

import academy.mindswap.school.commands.jwt.JwtRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface JwtAuthenticationController {
    @PostMapping
    ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequestDto authenticationRequest,
                                                BindingResult bindingResult) throws Exception;
}
