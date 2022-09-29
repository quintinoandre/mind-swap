package academy.mindswap.school.models;

import academy.mindswap.school.utils.role.RoleTypes;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@Document(value = "teachers")
public class Teacher implements Serializable {
    @Id
    private String id;

    private String name;

    @Indexed(unique = true)
    private String email;

    private String password;
    private LocalDate dateOfBirth;
    private List<Car> cars;
    private List<RoleTypes> roles;
}
