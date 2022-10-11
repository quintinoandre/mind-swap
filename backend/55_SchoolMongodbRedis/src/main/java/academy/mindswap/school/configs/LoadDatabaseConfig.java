package academy.mindswap.school.configs;

import academy.mindswap.school.exceptions.teachers.TeacherNotFoundException;
import academy.mindswap.school.models.Car;
import academy.mindswap.school.models.Shop;
import academy.mindswap.school.models.Teacher;
import academy.mindswap.school.repositories.ShopRepository;
import academy.mindswap.school.repositories.TeacherRepository;
import academy.mindswap.school.utils.role.RoleTypes;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
@Slf4j
public class LoadDatabaseConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoadDatabaseConfig.class);

    @Bean
    CommandLineRunner commandLineRunner(TeacherRepository teacherRepository, ShopRepository shopRepository,
                                        PasswordEncoder bcryptEncoder) {
        return args -> {
            Car car1 = Car
                    .builder()
                    .brand("BMW")
                    .model("S3")
                    .licensePlate("11-22-AA")
                    .manufacturingDate(LocalDate.of(2000, Month.JANUARY, 5))
                    .build();

            Car car2 = Car
                    .builder()
                    .brand("Mercedes")
                    .model("C203")
                    .licensePlate("22-11-BB")
                    .manufacturingDate(LocalDate.of(2001, Month.FEBRUARY, 1))
                    .build();

            String email1 = "claudia.reynolds@gmail.com";

            Teacher teacher1 = Teacher
                    .builder()
                    .name("Claudia Reynolds")
                    .email(email1)
                    .password(bcryptEncoder.encode("123456"))
                    .dateOfBirth(LocalDate.of(2000, Month.JANUARY, 5))
                    .cars(List.of(car1))
                    .roles(List.of(RoleTypes.ADMIN, RoleTypes.USER))
                    .build();

            teacherRepository.findByEmail(email1)
                    .ifPresentOrElse(
                            s -> LOGGER.error("Student with email ({}) already exists", s.getEmail()),
                            () -> {
                                LOGGER.info("Inserting {} teacher", teacher1.getName());

                                teacherRepository.insert(teacher1);
                            }
                    );

            String email2 = "glenn.barker@gmail.com";

            Teacher teacher2 = Teacher
                    .builder()
                    .name("Glenn Barker")
                    .email(email2)
                    .password(bcryptEncoder.encode("123456"))
                    .dateOfBirth(LocalDate.of(2004, Month.FEBRUARY, 1))
                    .cars(List.of(car2))
                    .roles(List.of(RoleTypes.USER))
                    .build();

            if (Boolean.TRUE.equals(teacherRepository.existsByEmail(email2))) {
                LOGGER.error("Student with email ({}) already exists", email2);
            } else {
                LOGGER.info("Inserting {} teacher", teacher2.getName());

                teacherRepository.insert(teacher2);
            }

            Teacher teacher1WithId = teacherRepository.findByEmail(email1).orElseThrow(TeacherNotFoundException::new);

            Teacher teacher2WithId = teacherRepository.findByEmail(email2).orElseThrow(TeacherNotFoundException::new);

            String name = "Fast Car";

            Shop shop = Shop.builder()
                    .name(name)
                    .rating(7)
                    .teachersIds(List.of(teacher1WithId.getId(), teacher2WithId.getId()))
                    .build();

            if (Boolean.TRUE.equals(shopRepository.existsByName(name))) {
                LOGGER.error("Shop with name ({}) already exists", name);
            } else {
                LOGGER.info("Inserting {} shop", shop.getName());

                shopRepository.insert(shop);
            }
        };
    }
}
