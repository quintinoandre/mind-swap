package academy.mindswap.school.commands.jwt;

import javax.validation.constraints.NotBlank;
import java.io.Serial;
import java.io.Serializable;

/**
 * this class is required for storing the username and password we receive from the client
 */
public class JwtRequestDto implements Serializable {
    // need default constructor for JSON Parsing
    public JwtRequestDto() {
    }

    @Serial
    private static final long serialVersionUID = 5926468583005150707L;

    @NotBlank(message = "username is mandatory")
    private String username;

    @NotBlank(message = "password is mandatory")
    private String password;

    public JwtRequestDto(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
