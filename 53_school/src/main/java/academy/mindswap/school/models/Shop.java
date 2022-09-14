package academy.mindswap.school.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@Table(name = "shops")
@ToString(exclude = "teachers")
public class Shop {
    public Shop() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer rating;

    @ManyToMany
    @JsonIgnore
    private List<Teacher> teachers;
}
