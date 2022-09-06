package academy.mindswap.personscars.services;

import academy.mindswap.personscars.models.Car;
import academy.mindswap.personscars.repositories.CarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car save(Car car) {
        return carRepository.save(car);
    }

    public Car findById(Integer id) {
        Optional<Car> car = carRepository.findById(id);

        if (car.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "car not found");
        }

        return car.get();
    }

    public Car findByLicensePlateIgnoreCase(String licensePlate) {
        return carRepository.findByLicensePlateIgnoreCase(licensePlate);
    }

    public List<Car> findAllByBrand(String brand) {
        return carRepository.findAllByBrand(brand);
    }

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public Car updateById(Integer id, Car car) {
        Optional<Car> oldCar = carRepository.findById(id);

        if (oldCar.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "car not found");
        }

        car.setId(id);

        return carRepository.save(car);
    }

    public void deleteById(Integer id) {
        Optional<Car> carOptional = carRepository.findById(id);

        if (carOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "car not found");
        }

        carRepository.deleteById(id);
    }
}
