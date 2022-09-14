package academy.mindswap.school.exceptions.authentication;

public final class AuthenticationExceptionMessages {
    private AuthenticationExceptionMessages() {
    }

    public static final String AUTHENTICATION_NULL = "object authentication is null";
    public static final String UNAUTHORIZED = "Unauthorized";
    public static final String UNABLE_GET_JWT = "Unable to get JWT Token";
    public static final String JWT_EXPIRED = "JWT Token has expired";
    public static final String JWT_WITHOUT_BEARER = "JWT Token does not begin with Bearer String";
}
