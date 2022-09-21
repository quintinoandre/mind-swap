package academy.mindswap.school.models;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@Document(value = "shops")
public class Shop {
    @Id
    private String id;

    @Indexed(unique = true)
    private String name;

    private Integer rating;
    private List<String> teachersIds;
}
