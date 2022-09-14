package academy.mindswap.school.exceptions.authentication;

import academy.mindswap.school.exceptions.BadRequestException;

public class AuthenticationBadRequestException extends BadRequestException {
    public AuthenticationBadRequestException(String message) {
        super(message);
    }
}
