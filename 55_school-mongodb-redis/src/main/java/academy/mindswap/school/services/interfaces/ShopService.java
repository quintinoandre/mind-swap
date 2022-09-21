package academy.mindswap.school.services.interfaces;

import academy.mindswap.school.commands.shop.SaveShopDto;
import academy.mindswap.school.commands.shop.ShopDto;
import academy.mindswap.school.commands.shop.UpdateShopDto;
import academy.mindswap.school.commands.teacher.TeacherDto;

import java.util.List;

public interface ShopService {
    ShopDto save(SaveShopDto shop);

    List<ShopDto> findByTeacherId(String id);

    List<TeacherDto> findTeachersByShopId(String id);

    ShopDto findById(String id);

    List<ShopDto> findAll();

    ShopDto assignTeacher(String id, String teacherId);

    ShopDto update(String id, UpdateShopDto shop);

    ShopDto deleteTeacher(String id, String teacherId);

    void delete(String id);
}
