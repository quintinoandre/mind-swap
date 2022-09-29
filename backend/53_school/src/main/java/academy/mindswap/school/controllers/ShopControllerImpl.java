package academy.mindswap.school.controllers;

import academy.mindswap.school.commands.shop.SaveShopDto;
import academy.mindswap.school.commands.shop.ShopDto;
import academy.mindswap.school.commands.shop.UpdateShopDto;
import academy.mindswap.school.exceptions.shops.ShopBadRequestException;
import academy.mindswap.school.exceptions.teachers.TeacherBadRequestException;
import academy.mindswap.school.services.ShopService;
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

import static academy.mindswap.school.exceptions.shops.ShopExceptionMessages.SHOP_ID_NULL;
import static academy.mindswap.school.exceptions.shops.ShopExceptionMessages.SHOP_NULL;
import static academy.mindswap.school.exceptions.teachers.TeacherExceptionMessages.TEACHER_ID_NULL;
import static academy.mindswap.school.utils.HasRoleTypes.ADMIN;
import static academy.mindswap.school.utils.HasRoleTypes.USER;
import static academy.mindswap.school.utils.PrintValidationErrors.printValidationErrors;

@Tag(name = "Shops", description = "The Shops API. Contains all the operations that can be performed on shops")
@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("api/v1/shops")
public class ShopControllerImpl implements ShopController {
    private final ShopService shopService;

    @Autowired
    public ShopControllerImpl(ShopService shopService) {
        this.shopService = shopService;
    }

    @Operation(summary = "Save a new shop (⚠️ only admin users)", description = "Save a new shop")
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = ShopDto.class)))
    @Override
    @PostMapping
    @PreAuthorize(ADMIN)
    public ResponseEntity<?> save(@Valid @RequestBody SaveShopDto shop, BindingResult bindingResult) {
        if (shop == null) {
            throw new ShopBadRequestException(SHOP_NULL);
        }

        if (bindingResult.hasErrors()) {
            return printValidationErrors(bindingResult);
        }

        return new ResponseEntity<>(shopService.save(shop), HttpStatus.CREATED);
    }

    @Operation(summary = "Find shop by teacher id", description = "Find shop by teacher id")
    @Override
    @GetMapping("/teacher/{id}")
    @PreAuthorize(USER)
    public ResponseEntity<List<ShopDto>> findByTeacherId(@PathVariable Long id) {
        if (id == null) {
            throw new TeacherBadRequestException(TEACHER_ID_NULL);
        }

        return new ResponseEntity<>(shopService.findByTeacherId(id), HttpStatus.OK);
    }

    @Operation(summary = "Find shop by id", description = "Find shop by id")
    @Override
    @GetMapping("/{id}")
    @PreAuthorize(USER)
    public ResponseEntity<ShopDto> findById(@PathVariable Long id) {
        if (id == null) {
            throw new ShopBadRequestException(SHOP_ID_NULL);
        }

        return new ResponseEntity<>(shopService.findById(id), HttpStatus.OK);
    }

    @Operation(summary = "Find all shops", description = "Find all shops")
    @Override
    @GetMapping
    @PreAuthorize(USER)
    public List<ShopDto> findAll() {
        return shopService.findAll();
    }

    @Operation(summary = "Assign a teacher to a shop (⚠️ only admin users)", description = "Assign a teacher to a shop")
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = ShopDto.class)))
    @Override
    @PutMapping("/{id}/teacher/{teacherId}")
    @PreAuthorize(ADMIN)
    public ResponseEntity<?> assignTeacher(@PathVariable Long id, @PathVariable Long teacherId) {
        if (id == null) {
            throw new ShopBadRequestException(SHOP_ID_NULL);
        }

        if (teacherId == null) {
            throw new TeacherBadRequestException(TEACHER_ID_NULL);
        }

        return new ResponseEntity<>(shopService.assignTeacher(id, teacherId), HttpStatus.CREATED);
    }

    @Operation(summary = "Update a shop (⚠️ only admin users)", description = "Update a shop")
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = ShopDto.class)))
    @Override
    @PutMapping("/{id}")
    @PreAuthorize(ADMIN)
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody UpdateShopDto shop,
                                    BindingResult bindingResult) {
        if (id == null) {
            throw new ShopBadRequestException(SHOP_ID_NULL);
        }

        if (shop == null) {
            throw new ShopBadRequestException(SHOP_NULL);
        }

        if (bindingResult.hasErrors()) {
            return printValidationErrors(bindingResult);
        }

        return new ResponseEntity<>(shopService.update(id, shop), HttpStatus.CREATED);
    }

    @Operation(summary = "Delete a shop (⚠️ only admin users)", description = "Delete a shop")
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true)))
    @Override
    @DeleteMapping("/{id}")
    @PreAuthorize(ADMIN)
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (id == null) {
            throw new ShopBadRequestException(SHOP_ID_NULL);
        }

        shopService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
