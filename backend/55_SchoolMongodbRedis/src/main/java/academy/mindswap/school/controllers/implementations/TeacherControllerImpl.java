package academy.mindswap.school.controllers.implementations;

import academy.mindswap.school.commands.teacher.RolesDto;
import academy.mindswap.school.commands.teacher.SaveTeacherDto;
import academy.mindswap.school.commands.teacher.TeacherDto;
import academy.mindswap.school.commands.teacher.UpdateTeacherDto;
import academy.mindswap.school.controllers.interfaces.TeacherController;
import academy.mindswap.school.exceptions.teachers.TeacherBadRequestException;
import academy.mindswap.school.models.Car;
import academy.mindswap.school.services.interfaces.TeacherService;
import academy.mindswap.school.utils.RequestHandler;
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

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

import static academy.mindswap.school.exceptions.teachers.TeacherExceptionMessages.*;
import static academy.mindswap.school.utils.role.HasRoleTypes.ADMIN;
import static academy.mindswap.school.utils.role.HasRoleTypes.USER;
import static academy.mindswap.school.utils.validation.PrintValidationErrors.printValidationErrors;

@Tag(name = "Teachers", description = "The Teacher API. Contains all the operations that can be performed on teachers" +
        " and cars")
@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("api/v1/teachers")
public class TeacherControllerImpl implements TeacherController {
    private final TeacherService teacherService;
    private final RequestHandler requestHandler;

    @Autowired
    public TeacherControllerImpl(TeacherService teacherService, RequestHandler requestHandler) {
        this.teacherService = teacherService;
        this.requestHandler = requestHandler;
    }

    @Operation(summary = "Save a new teacher", description = "Save a new teacher")
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = TeacherDto.class)))
    @Override
    @PostMapping
    @PreAuthorize(USER)
    public ResponseEntity<?> save(@Valid @RequestBody SaveTeacherDto teacher,
                                  BindingResult bindingResult) {
        if (teacher == null) {
            throw new TeacherBadRequestException(TEACHER_NULL);
        }

        if (bindingResult.hasErrors()) {
            return printValidationErrors(bindingResult);
        }

        return new ResponseEntity<>(teacherService.save(teacher), HttpStatus.CREATED);
    }

    @Operation(summary = "Find all cars (⚠️ only admin users)", description = "Find all cars")
    @Override
    @GetMapping("/cars/all")
    //@LogExecutionTime
    @PreAuthorize(ADMIN)
    public ResponseEntity<List<Car>> findAllCars() {
        return new ResponseEntity<>(teacherService.findAllCars(), HttpStatus.OK);
    }

    /*@Operation(summary = "Find cars by teacher id", description = "Find cars by teacher id")
    @Override
    @GetMapping("/{id}/cars")
    @PreAuthorize(USER)
    public ResponseEntity<List<Car>> findCarsById(@PathVariable String id) {
        if (id == null) {
            throw new TeacherBadRequestException(TEACHER_ID_NULL);
        }

        return new ResponseEntity<>(teacherService.findCarsById(id), HttpStatus.OK);
    }*/

    @Operation(summary = "Find cars by teacher id", description = "Find cars by teacher id")
    @Override
    @GetMapping("/cars")
    @PreAuthorize(USER)
    public ResponseEntity<List<Car>> findCarsById(HttpServletRequest request) {
        return new ResponseEntity<>(teacherService.findCarsById(requestHandler.getTeacherId(request)), HttpStatus.OK);
    }

    /*@Operation(summary = "Find teacher by id", description = "Find teacher by id")
    @Override
    @GetMapping("/{id}")
    @PreAuthorize(USER)
    public ResponseEntity<TeacherDto> findById(@PathVariable String id) {
        if (id == null) {
            throw new TeacherBadRequestException(TEACHER_ID_NULL);
        }

        return new ResponseEntity<>(teacherService.findById(id), HttpStatus.OK);
    }*/

    @Operation(summary = "Find all teachers (⚠️ only admin users)", description = "Find all teachers")
    @Override
    @GetMapping("/all")
    //@LogExecutionTime
    @PreAuthorize(ADMIN)
    public ResponseEntity<List<TeacherDto>> findAll() {
        return new ResponseEntity<>(teacherService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Find teacher by id", description = "Find teacher by id")
    @Override
    @GetMapping
    @PreAuthorize(USER)
    public ResponseEntity<TeacherDto> findById(HttpServletRequest request) {
        return new ResponseEntity<>(teacherService.findById(requestHandler.getTeacherId(request)), HttpStatus.OK);
    }

    @Operation(summary = "Assign roles to a teacher (⚠️ only admin users)", description = "Assign roles to a teacher")
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = TeacherDto.class)))
    @Override
    @PutMapping("/{id}/roles")
    @PreAuthorize(ADMIN)
    public ResponseEntity<?> assignRoles(String id, RolesDto rolesDto, BindingResult bindingResult) {
        if (id == null) {
            throw new TeacherBadRequestException(TEACHER_ID_NULL);
        }

        if (rolesDto == null) {
            throw new TeacherBadRequestException(ROLES_NULL);
        }

        if (bindingResult.hasErrors()) {
            return printValidationErrors(bindingResult);
        }

        return new ResponseEntity<>(teacherService.assignRoles(id, rolesDto), HttpStatus.OK);
    }

    /*@Operation(summary = "Update a teacher", description = "Update a teacher")
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = TeacherDto.class)))
    @Override
    @PutMapping("/{id}")
    @PreAuthorize(USER)
    public ResponseEntity<?> update(@PathVariable String id, @Valid @RequestBody UpdateTeacherDto
            teacher, BindingResult bindingResult
    ) {
        if (id == null) {
            throw new TeacherBadRequestException(TEACHER_ID_NULL);
        }

        if (teacher == null) {
            throw new TeacherBadRequestException(TEACHER_NULL);
        }

        if (bindingResult.hasErrors()) {
            return printValidationErrors(bindingResult);
        }

        return new ResponseEntity<>(teacherService.update(id, teacher), HttpStatus.OK);
    }*/

    @Operation(summary = "Update a teacher", description = "Update a teacher")
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = TeacherDto.class)))
    @Override
    @PutMapping
    @PreAuthorize(USER)
    public ResponseEntity<?> update(HttpServletRequest request, @Valid @RequestBody UpdateTeacherDto
            teacher, BindingResult bindingResult
    ) {
        if (teacher == null) {
            throw new TeacherBadRequestException(TEACHER_NULL);
        }

        if (bindingResult.hasErrors()) {
            return printValidationErrors(bindingResult);
        }

        return new ResponseEntity<>(teacherService.update(requestHandler.getTeacherId(request), teacher),
                HttpStatus.OK);
    }


    @Operation(summary = "Delete a teacher by id (⚠️ only admin users)", description = "Delete a teacher by id")
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true)))
    @Override
    @DeleteMapping("/{id}")
    @PreAuthorize(ADMIN)
    public ResponseEntity<?> delete(@PathVariable String id) {
        if (id == null) {
            throw new TeacherBadRequestException(TEACHER_ID_NULL);
        }

        teacherService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
