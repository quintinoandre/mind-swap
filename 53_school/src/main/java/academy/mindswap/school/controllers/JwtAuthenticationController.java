package academy.mindswap.school.controllers;

import academy.mindswap.school.commands.jwt.JwtRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

public interface JwtAuthenticationController {
    @PostMapping("/authenticate")
    ResponseEntity<?> createAuthenticationToken(@Valid @RequestBody JwtRequestDto authenticationRequest,
                                                BindingResult bindingResult) throws Exception;

    @GetMapping("/refreshtoken")
    ResponseEntity<?> refreshtoken(HttpServletRequest request);
}
