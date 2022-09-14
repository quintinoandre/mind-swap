package academy.mindswap.school.exceptions.cars;

import academy.mindswap.school.exceptions.BadRequestException;

public class CarBadRequestException extends BadRequestException {
    public CarBadRequestException(String message) {
        super(message);
    }
}
