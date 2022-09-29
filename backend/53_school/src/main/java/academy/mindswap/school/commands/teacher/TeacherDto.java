package academy.mindswap.school.commands.teacher;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class TeacherDto {
    private Long id;
    private String name;
    private String email;
    private LocalDate dateOfBirth;
    private Integer age;
    //private List<CarDto> carsDtos;
    //private List<ShopDto> shopsDtos;
    //private List<RoleDto> rolesDtos;
}
