package academy.mindswap.school.services;

//import academy.mindswap.school.aop.LogExecutionTime;

import academy.mindswap.school.commands.car.CarDto;
import academy.mindswap.school.commands.car.SaveCarDto;
import academy.mindswap.school.commands.car.UpdateCarDto;
import academy.mindswap.school.commands.teacher.SaveTeacherDto;
import academy.mindswap.school.commands.teacher.TeacherConverter;
import academy.mindswap.school.commands.teacher.TeacherDto;
import academy.mindswap.school.exceptions.teachers.TeacherBadRequestException;
import academy.mindswap.school.exceptions.teachers.TeacherNotFoundException;
import academy.mindswap.school.exceptions.teachers.TeachersNotFoundException;
import academy.mindswap.school.models.Teacher;
import academy.mindswap.school.repositories.TeacherRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import static academy.mindswap.school.exceptions.teachers.TeacherExceptionMessages.EMAIL_TAKEN;
import static academy.mindswap.school.utils.TeacherMessages.*;

@Service
@Slf4j
public class TeacherServiceImpl implements TeacherService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TeacherServiceImpl.class);
    private final TeacherRepository teacherRepository;
    private final CarService carService;
    private final PasswordEncoder bcryptEncoder;

    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository, CarService carService,
                              PasswordEncoder bcryptEncoder) {
        this.teacherRepository = teacherRepository;
        this.carService = carService;
        this.bcryptEncoder = bcryptEncoder;
    }

    private void verifyTeacherExists(Long id) {
        boolean teacherExists = teacherRepository.existsById(id);

        if (teacherExists) {
            return;
        }

        throw new TeacherNotFoundException();
    }

    private void verifyEmailExits(String email) {
        boolean teacherExists = teacherRepository.existsByEmail(email);

        if (teacherExists) {
            throw new TeacherBadRequestException(EMAIL_TAKEN);
        }
    }

    @Override
    public Teacher findTeacher(Long id) {
        return teacherRepository.findById(id).orElseThrow(TeacherNotFoundException::new);
    }

    @Override
    public Teacher findByEmail(String email) {
        return teacherRepository.findByEmail(email).orElseThrow(TeacherNotFoundException::new);
    }

    @Override
    public TeacherDto saveTeacher(SaveTeacherDto teacher) {
        Teacher teacherEntity = TeacherConverter.convertSaveTeacherDtoToEntity(teacher);

        verifyEmailExits(teacherEntity.getEmail());

        teacherEntity.setPassword(bcryptEncoder.encode(teacher.getPassword()));

        LOGGER.info(TEACHER_SAVED);

        return TeacherConverter.convertToDto(teacherRepository.save(teacherEntity));
    }

    @Override
    public CarDto saveCar(SaveCarDto car, Long teacherId) {
        Teacher teacher = findTeacher(teacherId);

        /*if (teacher.getCar() != null) {
            throw new IllegalArgumentException("the teacher already has a car");
        }*/

        return carService.save(car, teacher);
    }

    @Override
    //@LogExecutionTime
    public TeacherDto findTeacherById(Long id) {
        Teacher teacherEntity = findTeacher(id);

        return TeacherConverter.convertToDto(teacherEntity);
    }

    @Override
    public TeacherDto findTeacherByCarId(Long id) {
        Teacher teacherEntity = teacherRepository.findByCarsId(id).orElseThrow(TeacherNotFoundException::new);

        return TeacherConverter.convertToDto(teacherEntity);
    }

    @Override
    public List<TeacherDto> findTeachersByShopId(Long id) {
        List<Teacher> teachersEntities = teacherRepository.findByShopsId(id);

        if (teachersEntities.isEmpty()) {
            throw new TeachersNotFoundException();
        }

        return teachersEntities.stream().map(TeacherConverter::convertToDto).toList();
    }

    @Override
    public List<CarDto> findCarsByTeacherId(Long id) {
        verifyTeacherExists(id);

        return carService.findCarsByTeacherId(id);
    }

    @Override
    public List<TeacherDto> findAllTeachers() {
        List<Teacher> teachersEntities = teacherRepository.findAll();

        if (teachersEntities.isEmpty()) {
            throw new TeachersNotFoundException();
        }

        return teachersEntities.stream().map(TeacherConverter::convertToDto).toList();
    }

    @Override
    public CarDto findCarById(Long id) {
        return carService.findById(id);
    }

    @Override
    public List<CarDto> findAllCars() {
        return carService.findAll();
    }

    @Override
    @Transactional
    public TeacherDto updateTeacher(Long id, String name, String email, String password, String dateOfBirth) {
        Teacher teacherEntity = findTeacher(id);

        if (name != null && name.length() > 0 && !Objects.equals(teacherEntity.getName(), name)) {
            teacherEntity.setName(name);
        }

        if (email != null && email.length() > 0 && !Objects.equals(teacherEntity.getEmail(), email)
        ) {
            verifyEmailExits(email);

            teacherEntity.setEmail(email);
        }

        if (password != null && password.length() > 0 && !Objects.equals(teacherEntity.getPassword(), password)
        ) {
            teacherEntity.setPassword(password);
        }

        if (dateOfBirth != null && dateOfBirth.length() > 0 && !Objects.equals(teacherEntity.getDateOfBirth(), dateOfBirth)) {
            teacherEntity.setDateOfBirth(LocalDate.parse(dateOfBirth));
        }

        LOGGER.info(TEACHER_UPDATED);

        return TeacherConverter.convertToDto(teacherEntity);
    }

    @Override
    public CarDto updateCar(Long id, UpdateCarDto car) {
        return carService.update(id, car);
    }

    @Override
    public void deleteTeacherById(Long id) {
        verifyTeacherExists(id);

        LOGGER.info(TEACHER_DELETED);

        teacherRepository.deleteById(id);
    }

    @Override
    public void deleteCarById(Long id) {
        carService.deleteById(id);
    }
}
