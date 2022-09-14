package academy.mindswap.school.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Entity
@Data
@Table(name = "teachers")
@ToString
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Transient
    private Integer age;

    public Integer getAge() {
        return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
    }

    //@OneToOne
    @OneToMany(mappedBy = "teacher")
    @JsonIgnore
    @ToString.Exclude
    private List<Car> cars;

    @ManyToMany(mappedBy = "teachers")
    @JsonIgnore
    @ToString.Exclude
    private List<Shop> shops;

    @ManyToMany(mappedBy = "teachers", fetch = FetchType.EAGER)
    private List<Role> roles;
}
