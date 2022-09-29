package academy.mindswap.school.commands.shop;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ShopDto {
    private Long id;
    private String name;
    private Integer rating;
    //private List<TeacherDto> teachersDtos;
}
