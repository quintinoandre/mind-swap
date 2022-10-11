package academy.mindswap.school.services.implementations;

import academy.mindswap.school.commands.shop.SaveShopDto;
import academy.mindswap.school.commands.shop.ShopDto;
import academy.mindswap.school.commands.shop.UpdateShopDto;
import academy.mindswap.school.commands.teacher.TeacherDto;
import academy.mindswap.school.converters.ShopConverter;
import academy.mindswap.school.converters.TeacherConverter;
import academy.mindswap.school.exceptions.shops.ShopBadRequestException;
import academy.mindswap.school.exceptions.shops.ShopNotFoundException;
import academy.mindswap.school.exceptions.shops.ShopsNotFoundException;
import academy.mindswap.school.exceptions.teachers.TeacherBadRequestException;
import academy.mindswap.school.exceptions.teachers.TeacherNotFoundException;
import academy.mindswap.school.exceptions.teachers.TeachersNotFoundException;
import academy.mindswap.school.models.Shop;
import academy.mindswap.school.models.Teacher;
import academy.mindswap.school.repositories.ShopRepository;
import academy.mindswap.school.services.interfaces.ShopService;
import academy.mindswap.school.services.interfaces.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import static academy.mindswap.school.exceptions.shops.ShopExceptionMessages.NAME_TAKEN;
import static academy.mindswap.school.exceptions.teachers.TeacherExceptionMessages.SHOP_ALREADY_ASSIGN;
import static academy.mindswap.school.utils.shop.ShopMessages.*;

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

    private void verifyShopExists(String id) {
        boolean shopExists = shopRepository.existsById(id);

        if (shopExists) {
            return;
        }

        throw new ShopNotFoundException();
    }

    @Cacheable(value = "shops", key = "#id")
    private Shop findShop(String id) {
        return shopRepository.findById(id).orElseThrow(ShopNotFoundException::new);
    }

    private void verifyNameExits(String name) {
        boolean shopExists = shopRepository.existsByName(name);

        if (shopExists) {
            throw new ShopBadRequestException(NAME_TAKEN);
        }
    }

    @Override
    @CacheEvict(value = "shops", allEntries = true)
    public ShopDto save(SaveShopDto shop) {
        Shop shopEntity = ShopConverter.convertSaveShopDtoToEntity(shop);

        verifyNameExits(shopEntity.getName());

        LOGGER.info(SHOP_SAVED);

        return ShopConverter.convertToDto(shopRepository.insert(shopEntity));
    }

    @Override
    @Cacheable(value = "shops", key = "#id.concat('-shops')")
    public List<ShopDto> findByTeacherId(String id) {
        List<Shop> shopsEntities = shopRepository.findByTeachersIds(id);

        if (shopsEntities.isEmpty()) {
            throw new ShopsNotFoundException();
        }

        return shopsEntities.stream().map(ShopConverter::convertToDto).toList();
    }

    @Override
    @Cacheable(value = "shops", key = "#id.concat('-teachers')")
    public List<TeacherDto> findTeachersByShopId(String id) {
        List<String> teachersIds = shopRepository.findById(id).orElseThrow(ShopNotFoundException::new)
                .getTeachersIds();

        if (teachersIds.isEmpty()) {
            throw new TeachersNotFoundException();
        }

        List<Teacher> teachers = new LinkedList<>();

        teachersIds.forEach(teacherId -> teachers.add(teacherService.findTeacher(teacherId)));

        return teachers.stream().map(TeacherConverter::convertToDto).toList();
    }

    @Override
    @Cacheable(value = "shops", key = "#id")
    public ShopDto findById(String id) {
        return ShopConverter.convertToDto(findShop(id));
    }

    @Override
    @Cacheable(value = "shops")
    public List<ShopDto> findAll() {
        List<Shop> shopsEntities = shopRepository.findAll();

        if (shopsEntities.isEmpty()) {
            throw new ShopsNotFoundException();
        }

        return shopsEntities.stream().map(ShopConverter::convertToDto).toList();
    }

    @Override
    @CacheEvict(value = "shops", allEntries = true)
    public ShopDto assignTeacher(String id, String teacherId) {
        teacherService.verifyTeacherExists(teacherId);

        Shop shopEntity = findShop(id);

        List<String> teachersIds = new LinkedList<>();

        if (shopEntity.getTeachersIds() != null) {
            teachersIds.addAll(shopEntity.getTeachersIds());

            if (teachersIds.stream().anyMatch(item -> item.equals(teacherId))) {
                throw new TeacherBadRequestException(SHOP_ALREADY_ASSIGN);
            }
        }

        teachersIds.add(teacherId);

        shopEntity.setTeachersIds(teachersIds);

        LOGGER.info(TEACHER_ASSIGN);

        return ShopConverter.convertToDto(shopRepository.save(shopEntity));
    }

    @Override
    @CacheEvict(value = "shops", allEntries = true)
    public ShopDto update(String id, UpdateShopDto shop) {
        Shop shopEntity = ShopConverter.convertUpdateShopDtoToEntity(shop);

        Shop updatedShop = findShop(id);

        if (shopEntity.getName() != null && !shopEntity.getName().equals(updatedShop.getName())) {
            updatedShop.setName(shopEntity.getName());
        }

        if (shopEntity.getRating() != null && !shopEntity.getRating().equals(updatedShop.getRating())) {
            updatedShop.setRating(shopEntity.getRating());
        }

        LOGGER.info(SHOP_UPDATED);

        return ShopConverter.convertToDto(shopRepository.save(updatedShop));
    }

    @Override
    @CacheEvict(value = "shops", allEntries = true)
    public ShopDto deleteTeacher(String id, String teacherId) {
        teacherService.verifyTeacherExists(teacherId);

        Shop shopEntity = findShop(id);

        if (shopEntity.getTeachersIds() != null && !shopEntity.getTeachersIds().contains(teacherId)) {
            throw new TeacherNotFoundException();
        }

        List<String> teachersIds = new LinkedList<>(shopEntity.getTeachersIds().stream().filter(item ->
                !Objects.equals(item, teacherId)).toList());

        shopEntity.setTeachersIds(teachersIds);

        LOGGER.info(TEACHER_DELETED);

        return ShopConverter.convertToDto(shopRepository.save(shopEntity));
    }

    @Override
    @CacheEvict(value = "shops", allEntries = true)
    public void delete(String id) {
        verifyShopExists(id);

        LOGGER.info(SHOP_DELETED);

        shopRepository.deleteById(id);
    }
}
