package academy.mindswap.school.controllers;

import academy.mindswap.school.commands.car.CarDto;
import academy.mindswap.school.commands.car.SaveCarDto;
import academy.mindswap.school.commands.car.UpdateCarDto;
import academy.mindswap.school.commands.teacher.SaveTeacherDto;
import academy.mindswap.school.commands.teacher.TeacherDto;
import academy.mindswap.school.exceptions.cars.CarBadRequestException;
import academy.mindswap.school.exceptions.shops.ShopBadRequestException;
import academy.mindswap.school.exceptions.teachers.TeacherBadRequestException;
import academy.mindswap.school.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static academy.mindswap.school.exceptions.cars.CarExceptionMessages.CAR_ID_NULL;
import static academy.mindswap.school.exceptions.cars.CarExceptionMessages.CAR_NULL;
import static academy.mindswap.school.exceptions.shops.ShopExceptionMessages.SHOP_ID_NULL;
import static academy.mindswap.school.exceptions.teachers.TeacherExceptionMessages.TEACHER_ID_NULL;
import static academy.mindswap.school.exceptions.teachers.TeacherExceptionMessages.TEACHER_NULL;
import static academy.mindswap.school.utils.HasRoleTypes.ADMIN;
import static academy.mindswap.school.utils.HasRoleTypes.USER;
import static academy.mindswap.school.utils.PrintValidationErrors.printValidationErrors;

@RestController
@RequestMapping("api/v1/teachers")
public class TeacherControllerImpl implements TeacherController {
    private final TeacherService teacherService;

    @Autowired
    public TeacherControllerImpl(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @Override
    @PostMapping("/{id}/cars")
    @PreAuthorize(USER)
    public ResponseEntity<?> saveCar(@Valid @RequestBody SaveCarDto car, BindingResult bindingResult,
                                     @PathVariable("id") Long teacherId) {
        if (car == null) {
            throw new CarBadRequestException(CAR_NULL);
        }

        if (teacherId == null) {
            throw new TeacherBadRequestException(TEACHER_ID_NULL);
        }

        if (bindingResult.hasErrors()) {
            return printValidationErrors(bindingResult);
        }

        return new ResponseEntity<>(teacherService.saveCar(car, teacherId), HttpStatus.CREATED);
    }

    @Override
    @PostMapping
    @PreAuthorize(USER)
    public ResponseEntity<?> saveTeacher(@Valid @RequestBody SaveTeacherDto teacher,
                                         BindingResult bindingResult) {
        if (teacher == null) {
            throw new TeacherBadRequestException(TEACHER_NULL);
        }

        if (bindingResult.hasErrors()) {
            return printValidationErrors(bindingResult);
        }

        return new ResponseEntity<>(teacherService.saveTeacher(teacher), HttpStatus.CREATED);
    }

    @Override
    @GetMapping("/cars/{id}/teacher")
    @PreAuthorize(ADMIN)
    public ResponseEntity<TeacherDto> findTeacherByCarId(@PathVariable Long id) {
        if (id == null) {
            throw new CarBadRequestException(CAR_ID_NULL);
        }

        return new ResponseEntity<>(teacherService.findTeacherByCarId(id), HttpStatus.OK);
    }

    @Override
    @GetMapping("/shops/{id}/teachers")
    @PreAuthorize(ADMIN)
    public ResponseEntity<List<TeacherDto>> findTeachersByShopId(@PathVariable Long id) {
        if (id == null) {
            throw new ShopBadRequestException(SHOP_ID_NULL);
        }

        return new ResponseEntity<>(teacherService.findTeachersByShopId(id), HttpStatus.OK);
    }

    @Override
    @GetMapping("/cars/{id}")
    @PreAuthorize(USER)
    public ResponseEntity<CarDto> findCarById(@PathVariable Long id) {
        if (id == null) {
            throw new CarBadRequestException(CAR_ID_NULL);
        }

        return new ResponseEntity<>(teacherService.findCarById(id), HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}/cars")
    @PreAuthorize(USER)
    public ResponseEntity<List<CarDto>> findCarsByTeacherId(@PathVariable Long id) {
        if (id == null) {
            throw new TeacherBadRequestException(TEACHER_ID_NULL);
        }

        return new ResponseEntity<>(teacherService.findCarsByTeacherId(id), HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    @PreAuthorize(USER)
    public ResponseEntity<TeacherDto> findTeacherById(@PathVariable Long id) {
        if (id == null) {
            throw new TeacherBadRequestException(TEACHER_ID_NULL);
        }

        return new ResponseEntity<>(teacherService.findTeacherById(id), HttpStatus.OK);
    }

    @Override
    @GetMapping("/cars")
    //@LogExecutionTime
    @PreAuthorize(ADMIN)
    public List<CarDto> findAllCars() {
        return teacherService.findAllCars();
    }

    @Override
    @GetMapping
    //@LogExecutionTime
    @PreAuthorize(ADMIN)
    public List<TeacherDto> findAllTeachers() {
        return teacherService.findAllTeachers();
    }

    @Override
    @PutMapping("/cars/{id}")
    @PreAuthorize(USER)
    public ResponseEntity<?> updateCar(@PathVariable Long id, @Valid @RequestBody UpdateCarDto car,
                                       BindingResult bindingResult) {
        if (id == null) {
            throw new CarBadRequestException(CAR_ID_NULL);
        }

        if (car == null) {
            throw new CarBadRequestException(CAR_NULL);
        }

        if (bindingResult.hasErrors()) {
            return printValidationErrors(bindingResult);
        }

        return new ResponseEntity<>(teacherService.updateCar(id, car), HttpStatus.CREATED);
    }

    @Override
    @PatchMapping("/{id}")
    @PreAuthorize(USER)
    public ResponseEntity<TeacherDto> updateTeacher(
            @PathVariable Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String password,
            @RequestParam(required = false) String dateOfBirth
    ) {
        if (id == null) {
            throw new TeacherBadRequestException(TEACHER_ID_NULL);
        }

        return new ResponseEntity<>(teacherService.updateTeacher(id, name, email, password, dateOfBirth),
                HttpStatus.CREATED);
    }

    @Override
    @DeleteMapping("/cars/{id}")
    @PreAuthorize(USER)
    public ResponseEntity<CarDto> deleteCarById(@PathVariable Long id) {
        if (id == null) {
            throw new CarBadRequestException(CAR_ID_NULL);
        }

        teacherService.deleteCarById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    @DeleteMapping("/{id}")
    @PreAuthorize(ADMIN)
    public ResponseEntity<TeacherDto> deleteTeacherById(@PathVariable Long id) {
        if (id == null) {
            throw new TeacherBadRequestException(TEACHER_ID_NULL);
        }

        teacherService.deleteTeacherById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
