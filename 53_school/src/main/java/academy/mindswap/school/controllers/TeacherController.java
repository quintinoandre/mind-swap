package academy.mindswap.school.controllers;

//import academy.mindswap.school.aop.LogExecutionTime;

import academy.mindswap.school.commands.car.CarDto;
import academy.mindswap.school.commands.car.SaveCarDto;
import academy.mindswap.school.commands.car.UpdateCarDto;
import academy.mindswap.school.commands.teacher.SaveTeacherDto;
import academy.mindswap.school.commands.teacher.TeacherDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public interface TeacherController {
    @PostMapping("/{id}/cars")
    ResponseEntity<?> saveCar(@Valid @RequestBody SaveCarDto car, BindingResult bindingResult,
                              @PathVariable("id") Long teacherId);

    @PostMapping
    ResponseEntity<?> saveTeacher(@Valid @RequestBody SaveTeacherDto teacher,
                                  BindingResult bindingResult);

    @GetMapping("/cars/{id}/teacher")
    ResponseEntity<TeacherDto> findTeacherByCarId(@PathVariable Long id);

    @GetMapping("/shops/{id}/teachers")
    ResponseEntity<List<TeacherDto>> findTeachersByShopId(@PathVariable Long id);

    @GetMapping("/cars/{id}")
    ResponseEntity<CarDto> findCarById(@PathVariable Long id);

    @GetMapping("/{id}/cars")
    ResponseEntity<List<CarDto>> findCarsByTeacherId(@PathVariable Long id);

    @GetMapping("/{id}")
    ResponseEntity<TeacherDto> findTeacherById(@PathVariable Long id);

    @GetMapping("/cars")
        //@LogExecutionTime
    List<CarDto> findAllCars();

    @GetMapping
        //@LogExecutionTime
    List<TeacherDto> findAllTeachers();

    @PutMapping("/cars/{id}")
    ResponseEntity<?> updateCar(@PathVariable Long id, @Valid @RequestBody UpdateCarDto car,
                                BindingResult bindingResult);

    @PatchMapping("/{id}")
    ResponseEntity<TeacherDto> updateTeacher(
            @PathVariable Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String password,
            @RequestParam(required = false) String dateOfBirth
    );

    @DeleteMapping("/cars/{id}")
    ResponseEntity<CarDto> deleteCarById(@PathVariable Long id);

    @DeleteMapping("/{id}")
    ResponseEntity<TeacherDto> deleteTeacherById(@PathVariable Long id);
}
