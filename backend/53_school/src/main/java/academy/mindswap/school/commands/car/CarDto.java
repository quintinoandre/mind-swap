package academy.mindswap.school.commands.car;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class CarDto {
    private Long id;
    private String brand;
    private String model;
    private String licensePlate;
    private LocalDate manufacturingDate;
    private Integer age;
}
