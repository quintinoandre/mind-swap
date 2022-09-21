package academy.mindswap.school.commands.teacher;

import academy.mindswap.school.models.Car;
import academy.mindswap.school.utils.role.RoleTypes;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Builder
@Data
public class TeacherDto {
    private String id;
    private String name;
    private String email;
    private LocalDate dateOfBirth;
    private List<Car> cars;
    private List<RoleTypes> roles;
}
