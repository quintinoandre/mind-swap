package academy.mindswap.school.services;

import academy.mindswap.school.commands.car.CarDto;
import academy.mindswap.school.commands.car.SaveCarDto;
import academy.mindswap.school.commands.car.UpdateCarDto;
import academy.mindswap.school.models.Teacher;

import java.util.List;

public interface CarService {
    CarDto save(SaveCarDto car, Teacher teacher);

    CarDto findById(Long id);

    List<CarDto> findAll();

    CarDto update(Long id, UpdateCarDto car);

    void deleteById(Long id);

    List<CarDto> findCarsByTeacherId(Long id);
}
