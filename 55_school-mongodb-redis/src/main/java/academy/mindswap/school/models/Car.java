package academy.mindswap.school.models;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
public class Car implements Serializable {
    private String brand;
    private String model;

    @Indexed(unique = true)
    private String licensePlate;

    private LocalDate manufacturingDate;
}
