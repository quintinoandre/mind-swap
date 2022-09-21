package academy.mindswap.school.controllers.interfaces;

import academy.mindswap.school.commands.shop.SaveShopDto;
import academy.mindswap.school.commands.shop.ShopDto;
import academy.mindswap.school.commands.shop.UpdateShopDto;
import academy.mindswap.school.commands.teacher.TeacherDto;
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

public interface ShopController {
    @Operation(summary = "Save a new shop (⚠️ only admin users)", description = "Save a new shop")
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = ShopDto.class)))
    @PostMapping
    @PreAuthorize(ADMIN)
    ResponseEntity<?> save(@Valid @RequestBody SaveShopDto shop, BindingResult bindingResult);

    /*@Operation(summary = "Find shop by teacher id", description = "Find shop by teacher id")
    @GetMapping("/teacher/{id}")
    @PreAuthorize(USER)
    ResponseEntity<List<ShopDto>> findByTeacherId(@PathVariable String id);*/

    @Operation(summary = "Find shop by teacher id", description = "Find shop by teacher id")
    @GetMapping("/teacher")
    @PreAuthorize(USER)
    ResponseEntity<List<ShopDto>> findByTeacherId(HttpServletRequest request);

    @Operation(summary = "Find teachers by shop id (⚠️ only admin users)", description = "Find teachers by shop id")
    @GetMapping("/{id}/teachers")
    @PreAuthorize(ADMIN)
    ResponseEntity<List<TeacherDto>> findTeachersByShopId(@PathVariable String id);

    @Operation(summary = "Find shop by id", description = "Find shop by id")
    @GetMapping("/{id}")
    @PreAuthorize(USER)
    ResponseEntity<ShopDto> findById(@PathVariable String id);

    @Operation(summary = "Find all shops", description = "Find all shops")
    @GetMapping
    @PreAuthorize(USER)
    ResponseEntity<List<ShopDto>> findAll(HttpServletRequest request);

    @Operation(summary = "Assign a teacher to a shop (⚠️ only admin users)", description = "Assign a teacher to a shop")
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = ShopDto.class)))
    @PutMapping("/{id}/teacher/{teacherId}")
    @PreAuthorize(ADMIN)
    ResponseEntity<?> assignTeacher(@PathVariable String id, @PathVariable String teacherId);

    @Operation(summary = "Update a shop (⚠️ only admin users)", description = "Update a shop")
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = ShopDto.class)))
    @PutMapping("/{id}")
    @PreAuthorize(ADMIN)
    ResponseEntity<?> update(@PathVariable String id, @Valid @RequestBody UpdateShopDto shop,
                             BindingResult bindingResult);

    @Operation(summary = "Delete a teacher from shop (⚠️ only admin users)", description = "Delete a teacher from shop")
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true)))
    @DeleteMapping("/{id}/teacher/{teacherId}")
    @PreAuthorize(ADMIN)
    ResponseEntity<?> deleteTeacher(@PathVariable String id, @PathVariable String teacherId);

    @Operation(summary = "Delete a shop (⚠️ only admin users)", description = "Delete a shop")
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true)))
    @DeleteMapping("/{id}")
    @PreAuthorize(ADMIN)
    ResponseEntity<?> delete(@PathVariable String id);
}
