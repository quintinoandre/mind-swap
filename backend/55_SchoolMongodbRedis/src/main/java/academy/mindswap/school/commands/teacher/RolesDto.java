package academy.mindswap.school.commands.teacher;

import academy.mindswap.school.utils.role.RoleTypes;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class RolesDto {
    @NotNull(message = "roles is mandatory")
    private List<RoleTypes> roles;
}
