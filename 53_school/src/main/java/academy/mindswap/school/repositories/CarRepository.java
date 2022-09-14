package academy.mindswap.school.repositories;

import academy.mindswap.school.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findCarsByTeacherId(Long teacherId);

    Boolean existsByLicensePlate(String licensePlate);
}
