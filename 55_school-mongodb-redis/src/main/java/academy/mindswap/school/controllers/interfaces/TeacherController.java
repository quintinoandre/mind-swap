package academy.mindswap.school.controllers.interfaces;

//import academy.mindswap.school.aop.LogExecutionTime;

import academy.mindswap.school.commands.teacher.RolesDto;
import academy.mindswap.school.commands.teacher.SaveTeacherDto;
import academy.mindswap.school.commands.teacher.TeacherDto;
import academy.mindswap.school.commands.teacher.UpdateTeacherDto;
import academy.mindswap.school.models.Car;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

import static academy.mindswap.school.utils.role.HasRoleTypes.ADMIN;
import static academy.mindswap.school.utils.role.HasRoleTypes.USER;

public interface TeacherController {
    @Operation(summary = "Save a new teacher", description = "Save a new teacher")
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = TeacherDto.class)))
    @PostMapping
    @PreAuthorize(USER)
    ResponseEntity<?> save(@Valid @RequestBody SaveTeacherDto teacher,
                           BindingResult bindingResult);

    @Operation(summary = "Find all cars (⚠️ only admin users)", description = "Find all cars")
    @GetMapping("/cars/all")
    //@LogExecutionTime
    @PreAuthorize(ADMIN)
    ResponseEntity<List<Car>> findAllCars();

    /*@Operation(summary = "Find cars by teacher id", description = "Find cars by teacher id")
    @GetMapping("/{id}/cars")
    @PreAuthorize(USER)
    ResponseEntity<List<Car>> findCarsById(@PathVariable String id);*/

    @Operation(summary = "Find cars by teacher id", description = "Find cars by teacher id")
    @GetMapping("/cars")
    @PreAuthorize(USER)
    ResponseEntity<List<Car>> findCarsById(HttpServletRequest request);

    /*@Operation(summary = "Find teacher by id", description = "Find teacher by id")
    @GetMapping("/{id}")
    @PreAuthorize(USER)
    ResponseEntity<TeacherDto> findById(@PathVariable String id);*/

    @Operation(summary = "Find all teachers (⚠️ only admin users)", description = "Find all teachers")
    @GetMapping("/all")
    //@LogExecutionTime
    @PreAuthorize(ADMIN)
    ResponseEntity<List<TeacherDto>> findAll();

    @Operation(summary = "Find teacher by id", description = "Find teacher by id")
    @GetMapping
    @PreAuthorize(USER)
    ResponseEntity<TeacherDto> findById(HttpServletRequest request);

    @Operation(summary = "Assign roles to a teacher (⚠️ only admin users)", description = "Assign roles to a teacher")
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = TeacherDto.class)))
    @PutMapping("/{id}/roles")
    @PreAuthorize(ADMIN)
    ResponseEntity<?> assignRoles(@PathVariable String id, @Valid @RequestBody RolesDto
            rolesDto, BindingResult bindingResult);

    /*@Operation(summary = "Update a teacher", description = "Update a teacher")
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = TeacherDto.class)))
    @PutMapping("/{id}")
    @PreAuthorize(USER)
    ResponseEntity<?> update(@PathVariable String id, @Valid @RequestBody UpdateTeacherDto
            teacher, BindingResult bindingResult
    );*/

    @Operation(summary = "Update a teacher", description = "Update a teacher")
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = TeacherDto.class)))
    @PutMapping
    @PreAuthorize(USER)
    ResponseEntity<?> update(HttpServletRequest request, @Valid @RequestBody UpdateTeacherDto
            teacher, BindingResult bindingResult
    );

    @Operation(summary = "Delete a teacher by id", description = "Delete a teacher by id")
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true)))
    @DeleteMapping("/{id}")
    @PreAuthorize(ADMIN)
    ResponseEntity<?> delete(@PathVariable String id);
}
