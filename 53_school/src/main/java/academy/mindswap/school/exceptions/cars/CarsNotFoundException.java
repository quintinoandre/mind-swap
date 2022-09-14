package academy.mindswap.school.exceptions.cars;

import academy.mindswap.school.exceptions.NotFoundException;

import static academy.mindswap.school.exceptions.cars.CarExceptionMessages.CARS_NOT_FOUND;

public class CarsNotFoundException extends NotFoundException {
    public CarsNotFoundException() {
        super(CARS_NOT_FOUND);
    }
}
