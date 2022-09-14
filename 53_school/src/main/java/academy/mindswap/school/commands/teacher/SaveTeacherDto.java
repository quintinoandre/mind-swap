package academy.mindswap.school.commands.teacher;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Builder
@Data
public class SaveTeacherDto {
    @NotBlank(message = "name is mandatory")
    private String name;

    @Email(message = "email must be valid")
    private String email;

    @Size(min = 6)
    private String password;

    @NotNull(message = "date of birth is mandatory")
    private LocalDate dateOfBirth;
}
