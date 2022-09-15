package academy.mindswap.school.configs;

import academy.mindswap.school.builders.TeacherBuilder;
import academy.mindswap.school.models.Car;
import academy.mindswap.school.models.Role;
import academy.mindswap.school.models.Shop;
import academy.mindswap.school.models.Teacher;
import academy.mindswap.school.repositories.CarRepository;
import academy.mindswap.school.repositories.RoleRepository;
import academy.mindswap.school.repositories.ShopRepository;
import academy.mindswap.school.repositories.TeacherRepository;
import academy.mindswap.school.utils.RoleTypes;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class SeedersConfig {
    @Bean
    CommandLineRunner commandLineRunner(TeacherRepository teacherRepository, CarRepository carRepository,
                                        ShopRepository shopRepository, RoleRepository roleRepository,
                                        PasswordEncoder bcryptEncoder) {
        return args -> {
            Teacher teacher1 = TeacherBuilder
                    .builder()
                    .name("Claudia Reynolds")
                    .email("claudia.reynolds@gmail.com")
                    .password(bcryptEncoder.encode("123"))
                    .dateOfBirth(LocalDate.of(2000, Month.JANUARY, 5))
                    .build();

            Teacher teacher1WithId = teacherRepository.save(teacher1);

            Teacher teacher2 = TeacherBuilder
                    .builder()
                    .name("Glenn Barker")
                    .email("glenn.barker@gmail.com")
                    .password(bcryptEncoder.encode("123"))
                    .dateOfBirth(LocalDate.of(2004, Month.FEBRUARY, 1))
                    .build();

            Teacher teacher2WithId = teacherRepository.save(teacher2);

            Car car1 = Car
                    .builder()
                    .brand("BMW")
                    .model("S3")
                    .licensePlate("11-22-AA")
                    .manufacturingDate(LocalDate.of(2000, Month.JANUARY, 5))
                    .teacher(teacher1WithId)
                    .build();

            Car car2 = Car
                    .builder()
                    .brand("Mercedes")
                    .model("C203")
                    .licensePlate("22-11-BB")
                    .manufacturingDate(LocalDate.of(2001, Month.FEBRUARY, 1))
                    .teacher(teacher2WithId)
                    .build();

            carRepository.saveAll(List.of(car1, car2));

            Shop shop = Shop.builder()
                    .name("Fast Car")
                    .rating(7)
                    .teachers(List.of(teacher1, teacher2))
                    .build();

            shopRepository.save(shop);

            Role roleAdmin = Role.builder()
                    .type(RoleTypes.ROLE_ADMIN.toString())
                    .teachers(List.of(teacher1WithId))
                    .build();

            Role roleUser = Role.builder()
                    .type(RoleTypes.ROLE_USER.toString())
                    .teachers(List.of(teacher1WithId, teacher2WithId))
                    .build();

            roleRepository.saveAll(List.of(roleAdmin, roleUser));
        };
    }
}
