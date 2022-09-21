package academy.mindswap.school.services.implementations;

//import academy.mindswap.school.aop.LogExecutionTime;

import academy.mindswap.school.commands.teacher.RolesDto;
import academy.mindswap.school.commands.teacher.SaveTeacherDto;
import academy.mindswap.school.commands.teacher.TeacherDto;
import academy.mindswap.school.commands.teacher.UpdateTeacherDto;
import academy.mindswap.school.converters.TeacherConverter;
import academy.mindswap.school.exceptions.teachers.TeacherBadRequestException;
import academy.mindswap.school.exceptions.teachers.TeacherNotFoundException;
import academy.mindswap.school.exceptions.teachers.TeachersNotFoundException;
import academy.mindswap.school.models.Car;
import academy.mindswap.school.models.Teacher;
import academy.mindswap.school.repositories.TeacherRepository;
import academy.mindswap.school.services.interfaces.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

import static academy.mindswap.school.exceptions.teachers.TeacherExceptionMessages.EMAIL_TAKEN;
import static academy.mindswap.school.utils.teacher.TeacherMessages.*;

@Service
@Slf4j
public class TeacherServiceImpl implements TeacherService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TeacherServiceImpl.class);
    private final TeacherRepository teacherRepository;
    private final PasswordEncoder bcryptEncoder;

    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository, PasswordEncoder bcryptEncoder) {
        this.teacherRepository = teacherRepository;
        this.bcryptEncoder = bcryptEncoder;
    }

    private void verifyEmailExits(String email) {
        boolean teacherExists = teacherRepository.existsByEmail(email);

        if (teacherExists) {
            throw new TeacherBadRequestException(EMAIL_TAKEN);
        }
    }

    @Override
    public TeacherDto save(SaveTeacherDto teacher) {
        Teacher teacherEntity = TeacherConverter.convertSaveTeacherDtoToEntity(teacher);

        verifyEmailExits(teacherEntity.getEmail());

        teacherEntity.setPassword(bcryptEncoder.encode(teacher.getPassword()));

        LOGGER.info(TEACHER_SAVED);

        return TeacherConverter.convertToDto(teacherRepository.save(teacherEntity));
    }

    @Override
    public List<Car> findCarsById(String id) {
        return teacherRepository.findById(id).orElseThrow(TeacherNotFoundException::new).getCars();
    }

    @Override
    public List<Car> findAllCars() {
        List<Car> cars = new LinkedList<>();

        teacherRepository.findAll().forEach(teacher -> cars.addAll(teacher.getCars()));

        return cars;
    }

    //@LogExecutionTime
    @Override
    public TeacherDto findById(String id) {
        Teacher teacherEntity = findTeacher(id);

        return TeacherConverter.convertToDto(teacherEntity);
    }

    @Override
    public List<TeacherDto> findAll() {
        List<Teacher> teachersEntities = teacherRepository.findAll();

        if (teachersEntities.isEmpty()) {
            throw new TeachersNotFoundException();
        }

        return teachersEntities.stream().map(TeacherConverter::convertToDto).toList();
    }

    @Override
    public TeacherDto assignRoles(String id, RolesDto rolesDto) {
        Teacher updatedTeacher = findTeacher(id);

        updatedTeacher.setRoles(rolesDto.getRoles());

        LOGGER.info(ROLES_ASSIGN);

        return TeacherConverter.convertToDto(teacherRepository.save(updatedTeacher));
    }

    @Override
    public TeacherDto update(String id, UpdateTeacherDto teacher) {
        Teacher teacherEntity = TeacherConverter.convertUpdateTeacherDtoToEntity(teacher);

        Teacher updatedTeacher = findTeacher(id);

        if (teacherEntity.getName() != null && !teacherEntity.getName().equals(updatedTeacher.getName())) {
            updatedTeacher.setName(teacherEntity.getName());
        }

        if (teacherEntity.getEmail() != null && !teacherEntity.getEmail().equals(updatedTeacher.getEmail())) {
            updatedTeacher.setEmail(teacherEntity.getEmail());
        }

        if (teacherEntity.getPassword() != null && !bcryptEncoder.matches(teacherEntity.getPassword(),
                updatedTeacher.getPassword())) {
            updatedTeacher.setPassword(bcryptEncoder.encode(teacherEntity.getPassword()));
        }

        if (teacherEntity.getDateOfBirth() != null &&
                !teacherEntity.getDateOfBirth().equals(updatedTeacher.getDateOfBirth())) {
            updatedTeacher.setDateOfBirth(teacherEntity.getDateOfBirth());
        }

        if (teacherEntity.getCars() != null) {
            updatedTeacher.setCars(teacherEntity.getCars());
        }

        LOGGER.info(TEACHER_UPDATED);

        return TeacherConverter.convertToDto(teacherRepository.save(updatedTeacher));
    }

    @Override
    public void delete(String id) {
        verifyTeacherExists(id);

        LOGGER.info(TEACHER_DELETED);

        teacherRepository.deleteById(id);
    }

    @Override
    public void verifyTeacherExists(String id) {
        boolean teacherExists = teacherRepository.existsById(id);

        if (teacherExists) {
            return;
        }

        throw new TeacherNotFoundException();
    }

    @Override
    public Teacher findTeacher(String id) {
        return teacherRepository.findById(id).orElseThrow(TeacherNotFoundException::new);
    }

    @Override
    public Teacher findByEmail(String email) {
        return teacherRepository.findByEmail(email).orElseThrow(TeacherNotFoundException::new);
    }
}
