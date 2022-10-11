package academy.mindswap.school.controllers;

import academy.mindswap.school.commands.jwtAuthentication.JwtRequestDto;
import academy.mindswap.school.commands.jwtAuthentication.JwtResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

public interface JwtAuthenticationController {
    @Operation(summary = "Generate JWT token", description = "Generate JWT token")
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = JwtResponseDto.class)))
    @PostMapping("/authenticate")
    ResponseEntity<?> createAuthenticationToken(@Valid @RequestBody JwtRequestDto authenticationRequest,
                                                BindingResult bindingResult) throws Exception;

    @Operation(summary = "Generate refresh JWT token", description = "Generate refresh JWT token")
    @SecurityRequirement(name = "bearerAuth")
    @GetMapping("/refreshtoken")
    ResponseEntity<JwtResponseDto> createRefreshToken(@RequestHeader(value = "isRefreshToken", required = true,
            defaultValue = "true") String headerStr, HttpServletRequest request);
}
