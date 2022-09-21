package academy.mindswap.school.commands.shop;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class ShopDto {
    private String id;
    private String name;
    private Integer rating;
    private List<String> teachersIds;
}
