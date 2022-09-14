package academy.mindswap.school.services;

import academy.mindswap.school.commands.shop.SaveShopDto;
import academy.mindswap.school.commands.shop.ShopDto;
import academy.mindswap.school.commands.shop.UpdateShopDto;

import java.util.List;

public interface ShopService {
    ShopDto save(SaveShopDto shop);

    ShopDto findById(Long id);

    List<ShopDto> findByTeacherId(Long id);

    List<ShopDto> findAll();

    ShopDto update(Long id, UpdateShopDto shop);

    void delete(Long id);

    ShopDto assignTeacher(Long id, Long teacherId);
}
