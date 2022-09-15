package academy.mindswap.school.services;

import academy.mindswap.school.commands.car.CarDto;
import academy.mindswap.school.commands.car.SaveCarDto;
import academy.mindswap.school.commands.car.UpdateCarDto;
import academy.mindswap.school.commands.teacher.SaveTeacherDto;
import academy.mindswap.school.commands.teacher.TeacherDto;
import academy.mindswap.school.models.Teacher;

import javax.transaction.Transactional;
import java.util.List;

public interface TeacherService {
    Teacher findTeacher(Long id);

    Teacher findByEmail(String email);

    TeacherDto saveTeacher(SaveTeacherDto teacher);

    CarDto saveCar(SaveCarDto car, Long teacherId);

    //@LogExecutionTime
    TeacherDto findTeacherById(Long id);

    TeacherDto findTeacherByCarId(Long id);

    List<TeacherDto> findTeachersByShopId(Long id);

    List<CarDto> findCarsByTeacherId(Long id);

    List<TeacherDto> findAllTeachers();

    CarDto findCarById(Long id);

    List<CarDto> findAllCars();

    @Transactional
    TeacherDto updateTeacher(Long id, String name, String email, String password, String dateOfBirth);

    CarDto updateCar(Long id, UpdateCarDto car);

    void deleteTeacherById(Long id);

    void deleteCarById(Long id);
}
