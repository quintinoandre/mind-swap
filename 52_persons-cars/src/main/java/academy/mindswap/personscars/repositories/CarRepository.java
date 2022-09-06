package academy.mindswap.personscars.repositories;

import academy.mindswap.personscars.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
    @Query(value = "SELECT * FROM cars WHERE brand LIKE %?1%", nativeQuery = true)
    List<Car> findAllByBrand(String brand);

    Car findByLicensePlateIgnoreCase(String licensePlate);
}
