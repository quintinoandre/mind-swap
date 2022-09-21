package academy.mindswap.school.commands.shop;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Builder
@Data
public class UpdateShopDto {
    @NotBlank(message = "name is mandatory")
    private String name;

    @NotNull(message = "rating is mandatory")
    private Integer rating;

    private List<String> teachersIds;
}
