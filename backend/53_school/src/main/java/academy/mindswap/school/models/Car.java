package academy.mindswap.school.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Data
@Builder
@AllArgsConstructor
@ToString(exclude = "teacher")
@Table(name = "cars")
public class Car {
    public Car() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String model;

    @Column(name = "license_plate", nullable = false)
    private String licensePlate;

    @Column(name = "manufacturing_date", nullable = false)
    private LocalDate manufacturingDate;

    @Transient
    private Integer age;

    public Integer getAge() {
        return Period.between(this.manufacturingDate, LocalDate.now()).getYears();
    }

    //@OneToOne
    @ManyToOne
    @JsonIgnore
    private Teacher teacher;
}
