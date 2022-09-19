package academy.mindswap.school.commands.jwtAuthentication;

import java.io.Serial;
import java.io.Serializable;

/**
 * this is class is required for creating a response containing the JWT to be returned to the user.
 */
public class JwtResponseDto implements Serializable {
    @Serial
    private static final long serialVersionUID = -8091879091924046844L;
    private final String token;

    public JwtResponseDto(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }
}
