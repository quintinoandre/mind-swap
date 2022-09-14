package academy.mindswap.school.commands.jwt;

import java.io.Serial;
import java.io.Serializable;

/**
 * this is class is required for creating a response containing the JWT to be returned to the user.
 */
public class JwtResponseDto implements Serializable {
    public JwtResponseDto(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    @Serial
    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwtToken;
    
    public String getToken() {
        return this.jwtToken;
    }
}
