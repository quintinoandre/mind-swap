package academy.mindswap.school.services.interfaces;

import academy.mindswap.school.commands.teacher.RolesDto;
import academy.mindswap.school.commands.teacher.SaveTeacherDto;
import academy.mindswap.school.commands.teacher.TeacherDto;
import academy.mindswap.school.commands.teacher.UpdateTeacherDto;
import academy.mindswap.school.models.Car;
import academy.mindswap.school.models.Teacher;

import java.util.List;

public interface TeacherService {
    TeacherDto save(SaveTeacherDto teacher);

    List<Car> findCarsById(String id);

    List<Car> findAllCars();

    //@LogExecutionTime
    TeacherDto findById(String id);

    List<TeacherDto> findAll();

    TeacherDto assignRoles(String id, RolesDto rolesDto);

    TeacherDto update(String id, UpdateTeacherDto teacher);

    void delete(String id);

    void verifyTeacherExists(String id);

    Teacher findTeacher(String id);

    Teacher findByEmail(String email);
}
