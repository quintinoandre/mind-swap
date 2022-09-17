package academy.mindswap.school.exceptions.authentication;

import academy.mindswap.school.exceptions.BadRequestException;

public class JwtAuthenticationBadRequestException extends BadRequestException {
    public JwtAuthenticationBadRequestException(String message) {
        super(message);
    }
}
