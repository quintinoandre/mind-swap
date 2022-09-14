package academy.mindswap.school.controllers;

import academy.mindswap.school.commands.shop.SaveShopDto;
import academy.mindswap.school.commands.shop.ShopDto;
import academy.mindswap.school.commands.shop.UpdateShopDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public interface ShopController {
    @PostMapping
    ResponseEntity<?> save(@Valid @RequestBody SaveShopDto shop, BindingResult bindingResult);

    @GetMapping("/teacher/{id}")
    ResponseEntity<List<ShopDto>> findByTeacherId(@PathVariable Long id);

    @GetMapping("/{id}")
    ResponseEntity<ShopDto> findById(@PathVariable Long id);

    @GetMapping
    List<ShopDto> findAll();

    @PutMapping("/{id}/teacher/{teacherId}")
    ResponseEntity<?> assignTeacher(@PathVariable Long id, @PathVariable Long teacherId);

    @PutMapping("/{id}")
    ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody UpdateShopDto shop,
                             BindingResult bindingResult);

    @DeleteMapping("/{id}")
    ResponseEntity<ShopDto> delete(@PathVariable Long id);
}
