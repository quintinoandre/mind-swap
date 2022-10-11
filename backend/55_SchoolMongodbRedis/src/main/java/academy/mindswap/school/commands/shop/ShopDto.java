package academy.mindswap.school.commands.shop;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Builder
@Data
public class ShopDto implements Serializable {
    private String id;
    private String name;
    private Integer rating;
    private List<String> teachersIds;
}
