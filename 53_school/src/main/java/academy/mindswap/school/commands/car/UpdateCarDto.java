package academy.mindswap.school.commands.car;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Builder
@Data
public class UpdateCarDto {
    @NotBlank(message = "brand is mandatory")
    private String brand;

    @NotBlank(message = "model is mandatory")
    private String model;

    @NotBlank(message = "license plate is mandatory")
    private String licensePlate;

    @NotNull(message = "manufacturing date is mandatory")
    private LocalDate manufacturingDate;
}
