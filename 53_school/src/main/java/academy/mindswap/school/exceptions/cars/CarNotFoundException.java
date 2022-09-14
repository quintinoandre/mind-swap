package academy.mindswap.school.exceptions.cars;

import academy.mindswap.school.exceptions.NotFoundException;

import static academy.mindswap.school.exceptions.cars.CarExceptionMessages.CAR_NOT_FOUND;

public class CarNotFoundException extends NotFoundException {
    public CarNotFoundException() {
        super(CAR_NOT_FOUND);
    }
}
