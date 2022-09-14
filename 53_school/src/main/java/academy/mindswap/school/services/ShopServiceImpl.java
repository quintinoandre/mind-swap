package academy.mindswap.school.services;

import academy.mindswap.school.commands.shop.SaveShopDto;
import academy.mindswap.school.commands.shop.ShopConverter;
import academy.mindswap.school.commands.shop.ShopDto;
import academy.mindswap.school.commands.shop.UpdateShopDto;
import academy.mindswap.school.exceptions.shops.ShopBadRequestException;
import academy.mindswap.school.exceptions.shops.ShopNotFoundException;
import academy.mindswap.school.exceptions.shops.ShopsNotFoundException;
import academy.mindswap.school.exceptions.teachers.TeacherBadRequestException;
import academy.mindswap.school.models.Shop;
import academy.mindswap.school.models.Teacher;
import academy.mindswap.school.repositories.ShopRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static academy.mindswap.school.exceptions.shops.ShopExceptionMessages.NAME_TAKEN;
import static academy.mindswap.school.exceptions.teachers.TeacherExceptionMessages.SHOP_ALREADY_ASSIGN;
import static academy.mindswap.school.utils.ShopMessages.*;

@Service
@Slf4j
public class ShopServiceImpl implements ShopService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ShopServiceImpl.class);
    private final ShopRepository shopRepository;
    private final TeacherService teacherService;

    @Autowired
    public ShopServiceImpl(ShopRepository shopRepository, TeacherService teacherService) {
        this.shopRepository = shopRepository;
        this.teacherService = teacherService;
    }

    private void verifyShopExists(Long id) {
        boolean shopExists = shopRepository.existsById(id);

        if (shopExists) {
            return;
        }

        throw new ShopNotFoundException();
    }

    private Shop findShop(Long id) {
        return shopRepository.findById(id).orElseThrow(ShopNotFoundException::new);
    }

    private void verifyNameExits(String name) {
        boolean shopExists = shopRepository.existsByName(name);

        if (shopExists) {
            throw new ShopBadRequestException(NAME_TAKEN);
        }
    }

    @Override
    public ShopDto save(SaveShopDto shop) {
        Shop shopEntity = ShopConverter.convertSaveShopDtoToEntity(shop);

        verifyNameExits(shopEntity.getName());

        LOGGER.info(SHOP_SAVED);

        return ShopConverter.convertToDto(shopRepository.save(shopEntity));
    }

    @Override
    public ShopDto findById(Long id) {
        return ShopConverter.convertToDto(findShop(id));
    }

    @Override
    public List<ShopDto> findByTeacherId(Long id) {
        List<Shop> shopsEntities = shopRepository.findByTeachersId(id);

        if (shopsEntities.isEmpty()) {
            throw new ShopsNotFoundException();
        }

        return shopsEntities.stream().map(ShopConverter::convertToDto).toList();
    }

    @Override
    public List<ShopDto> findAll() {
        List<Shop> shopsEntities = shopRepository.findAll();

        if (shopsEntities.isEmpty()) {
            throw new ShopsNotFoundException();
        }

        return shopsEntities.stream().map(ShopConverter::convertToDto).toList();
    }

    @Override
    public ShopDto update(Long id, UpdateShopDto shop) {
        Shop shopEntity = ShopConverter.convertUpdateShopDtoToEntity(shop);

        verifyShopExists(id);

        shopEntity.setId(id);

        LOGGER.info(SHOP_UPDATED);

        return ShopConverter.convertToDto(shopRepository.save(shopEntity));
    }

    @Override
    public void delete(Long id) {
        verifyShopExists(id);

        LOGGER.info(SHOP_DELETED);

        shopRepository.deleteById(id);
    }

    @Override
    public ShopDto assignTeacher(Long id, Long teacherId) {
        Teacher newTeacherEntity = teacherService.findTeacher(teacherId);

        Shop shopEntity = findShop(id);

        List<Teacher> teachersEntities = shopEntity.getTeachers();

        if (teachersEntities.stream().anyMatch(teacherEntity -> teacherEntity.getId().equals(teacherId))) {
            throw new TeacherBadRequestException(SHOP_ALREADY_ASSIGN);
        }

        teachersEntities.add(newTeacherEntity);

        shopEntity.setTeachers(teachersEntities);

        LOGGER.info(TEACHER_ASSIGN);

        return ShopConverter.convertToDto(shopRepository.save(shopEntity));
    }
}
