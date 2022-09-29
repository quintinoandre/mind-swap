package academy.mindswap.school.controllers;

//import academy.mindswap.school.aop.LogExecutionTime;

import academy.mindswap.school.commands.car.CarDto;
import academy.mindswap.school.commands.car.SaveCarDto;
import academy.mindswap.school.commands.car.UpdateCarDto;
import academy.mindswap.school.commands.teacher.SaveTeacherDto;
import academy.mindswap.school.commands.teacher.TeacherDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static academy.mindswap.school.utils.HasRoleTypes.ADMIN;
import static academy.mindswap.school.utils.HasRoleTypes.USER;

public interface TeacherController {
    @Operation(summary = "Save a new car", description = "Save a new car")
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = CarDto.class)))
    @PostMapping("/{id}/cars")
    @PreAuthorize(USER)
    ResponseEntity<?> saveCar(@Valid @RequestBody SaveCarDto car, BindingResult bindingResult,
                              @PathVariable("id") Long teacherId);

    @Operation(summary = "Save a new teacher", description = "Save a new teacher")
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = TeacherDto.class)))
    @PostMapping
    @PreAuthorize(USER)
    ResponseEntity<?> saveTeacher(@Valid @RequestBody SaveTeacherDto teacher,
                                  BindingResult bindingResult);

    @Operation(summary = "Find teacher by car id (⚠️ only admin users)", description = "Find teacher by car id")
    @GetMapping("/cars/{id}/teacher")
    @PreAuthorize(ADMIN)
    ResponseEntity<TeacherDto> findTeacherByCarId(@PathVariable Long id);

    @Operation(summary = "Find teachers by shop id (⚠️ only admin users)", description = "Find teachers by shop id")
    @GetMapping("/shops/{id}/teachers")
    @PreAuthorize(ADMIN)
    ResponseEntity<List<TeacherDto>> findTeachersByShopId(@PathVariable Long id);

    @Operation(summary = "Find car by id", description = "Find car by id")
    @GetMapping("/cars/{id}")
    @PreAuthorize(USER)
    ResponseEntity<CarDto> findCarById(@PathVariable Long id);

    @Operation(summary = "Find cars by teacher id", description = "Find cars by teacher id")
    @GetMapping("/{id}/cars")
    @PreAuthorize(USER)
    ResponseEntity<List<CarDto>> findCarsByTeacherId(@PathVariable Long id);

    @Operation(summary = "Find teacher by id", description = "Find teacher by id")
    @GetMapping("/{id}")
    @PreAuthorize(USER)
    ResponseEntity<TeacherDto> findTeacherById(@PathVariable Long id);

    @Operation(summary = "Find all cars (⚠️ only admin users)", description = "Find all cars")
    @GetMapping("/cars")
    //@LogExecutionTime
    @PreAuthorize(ADMIN)
    List<CarDto> findAllCars();

    @Operation(summary = "Find all teachers (⚠️ only admin users)", description = "Find all teachers")
    @GetMapping
    //@LogExecutionTime
    @PreAuthorize(ADMIN)
    List<TeacherDto> findAllTeachers();

    @Operation(summary = "Update a car", description = "Update a car")
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = CarDto.class)))
    @PutMapping("/cars/{id}")
    @PreAuthorize(USER)
    ResponseEntity<?> updateCar(@PathVariable Long id, @Valid @RequestBody UpdateCarDto car,
                                BindingResult bindingResult);

    @Operation(summary = "Update a teacher", description = "Update a teacher")
    @PatchMapping("/{id}")
    @PreAuthorize(USER)
    ResponseEntity<TeacherDto> updateTeacher(
            @PathVariable Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String password,
            @RequestParam(required = false) String dateOfBirth
    );

    @Operation(summary = "Delete a car by id", description = "Delete a car by id")
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true)))
    @DeleteMapping("/cars/{id}")
    @PreAuthorize(USER)
    ResponseEntity<?> deleteCarById(@PathVariable Long id);

    @Operation(summary = "Delete a teacher by id", description = "Delete a teacher by id")
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true)))
    @DeleteMapping("/{id}")
    @PreAuthorize(ADMIN)
    ResponseEntity<?> deleteTeacherById(@PathVariable Long id);
}
