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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
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

@Tag(name = "Teachers", description = "The Teacher API. Contains all the operations that can be performed on teachers" +
        " and cars")
@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("api/v1/teachers")
public class TeacherControllerImpl implements TeacherController {
    private final TeacherService teacherService;

    @Autowired
    public TeacherControllerImpl(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @Operation(summary = "Save a new car", description = "Save a new car")
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = CarDto.class)))
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

    @Operation(summary = "Save a new teacher", description = "Save a new teacher")
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = TeacherDto.class)))
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

    @Operation(summary = "Find teacher by car id (⚠️ only admin users)", description = "Find teacher by car id")
    @Override
    @GetMapping("/cars/{id}/teacher")
    @PreAuthorize(ADMIN)
    public ResponseEntity<TeacherDto> findTeacherByCarId(@PathVariable Long id) {
        if (id == null) {
            throw new CarBadRequestException(CAR_ID_NULL);
        }

        return new ResponseEntity<>(teacherService.findTeacherByCarId(id), HttpStatus.OK);
    }

    @Operation(summary = "Find teachers by shop id (⚠️ only admin users)", description = "Find teachers by shop id")
    @Override
    @GetMapping("/shops/{id}/teachers")
    @PreAuthorize(ADMIN)
    public ResponseEntity<List<TeacherDto>> findTeachersByShopId(@PathVariable Long id) {
        if (id == null) {
            throw new ShopBadRequestException(SHOP_ID_NULL);
        }

        return new ResponseEntity<>(teacherService.findTeachersByShopId(id), HttpStatus.OK);
    }

    @Operation(summary = "Find car by id", description = "Find car by id")
    @Override
    @GetMapping("/cars/{id}")
    @PreAuthorize(USER)
    public ResponseEntity<CarDto> findCarById(@PathVariable Long id) {
        if (id == null) {
            throw new CarBadRequestException(CAR_ID_NULL);
        }

        return new ResponseEntity<>(teacherService.findCarById(id), HttpStatus.OK);
    }

    @Operation(summary = "Find cars by teacher id", description = "Find cars by teacher id")
    @Override
    @GetMapping("/{id}/cars")
    @PreAuthorize(USER)
    public ResponseEntity<List<CarDto>> findCarsByTeacherId(@PathVariable Long id) {
        if (id == null) {
            throw new TeacherBadRequestException(TEACHER_ID_NULL);
        }

        return new ResponseEntity<>(teacherService.findCarsByTeacherId(id), HttpStatus.OK);
    }

    @Operation(summary = "Find teacher by id", description = "Find teacher by id")
    @Override
    @GetMapping("/{id}")
    @PreAuthorize(USER)
    public ResponseEntity<TeacherDto> findTeacherById(@PathVariable Long id) {
        if (id == null) {
            throw new TeacherBadRequestException(TEACHER_ID_NULL);
        }

        return new ResponseEntity<>(teacherService.findTeacherById(id), HttpStatus.OK);
    }

    @Operation(summary = "Find all cars (⚠️ only admin users)", description = "Find all cars")
    @Override
    @GetMapping("/cars")
    //@LogExecutionTime
    @PreAuthorize(ADMIN)
    public List<CarDto> findAllCars() {
        return teacherService.findAllCars();
    }

    @Operation(summary = "Find all teachers (⚠️ only admin users)", description = "Find all teachers")
    @Override
    @GetMapping
    //@LogExecutionTime
    @PreAuthorize(ADMIN)
    public List<TeacherDto> findAllTeachers() {
        return teacherService.findAllTeachers();
    }

    @Operation(summary = "Update a car", description = "Update a car")
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = CarDto.class)))
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

    @Operation(summary = "Update a teacher", description = "Update a teacher")
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

    @Operation(summary = "Delete a car by id", description = "Delete a car by id")
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true)))
    @Override
    @DeleteMapping("/cars/{id}")
    @PreAuthorize(USER)
    public ResponseEntity<?> deleteCarById(@PathVariable Long id) {
        if (id == null) {
            throw new CarBadRequestException(CAR_ID_NULL);
        }

        teacherService.deleteCarById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Delete a teacher by id", description = "Delete a teacher by id")
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true)))
    @Override
    @DeleteMapping("/{id}")
    @PreAuthorize(ADMIN)
    public ResponseEntity<?> deleteTeacherById(@PathVariable Long id) {
        if (id == null) {
            throw new TeacherBadRequestException(TEACHER_ID_NULL);
        }

        teacherService.deleteTeacherById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
