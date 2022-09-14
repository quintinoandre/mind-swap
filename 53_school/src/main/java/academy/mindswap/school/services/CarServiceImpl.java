package academy.mindswap.school.services;

import academy.mindswap.school.commands.car.CarConverter;
import academy.mindswap.school.commands.car.CarDto;
import academy.mindswap.school.commands.car.SaveCarDto;
import academy.mindswap.school.commands.car.UpdateCarDto;
import academy.mindswap.school.exceptions.cars.CarBadRequestException;
import academy.mindswap.school.exceptions.cars.CarNotFoundException;
import academy.mindswap.school.exceptions.cars.CarsNotFoundException;
import academy.mindswap.school.models.Car;
import academy.mindswap.school.models.Teacher;
import academy.mindswap.school.repositories.CarRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static academy.mindswap.school.exceptions.cars.CarExceptionMessages.LICENSE_PLATE_TAKEN;
import static academy.mindswap.school.utils.CarMessages.*;

@Service
@Slf4j
public class CarServiceImpl implements CarService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CarServiceImpl.class);
    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    private void verifyCarExists(Long id) {
        boolean carExists = carRepository.existsById(id);

        if (carExists) {
            return;
        }

        throw new CarNotFoundException();
    }

    private void verifyLicencePlateExits(String licensePlate) {
        boolean carExists = carRepository.existsByLicensePlate(licensePlate);

        if (carExists) {
            throw new CarBadRequestException(LICENSE_PLATE_TAKEN);
        }
    }

    @Override
    public CarDto save(SaveCarDto car, Teacher teacher) {
        Car carEntity = CarConverter.convertSaveCarDtoToEntity(car);

        verifyLicencePlateExits(carEntity.getLicensePlate());

        carEntity.setTeacher(teacher);

        LOGGER.info(CAR_SAVED);

        return CarConverter.convertToDto(carRepository.save(carEntity));
    }

    @Override
    public CarDto findById(Long id) {
        Car carEntity = carRepository.findById(id).orElseThrow(CarNotFoundException::new);

        return CarConverter.convertToDto(carEntity);
    }

    @Override
    public List<CarDto> findAll() {
        List<Car> carsEntities = carRepository.findAll();

        if (carsEntities.isEmpty()) {
            throw new CarsNotFoundException();
        }

        return carsEntities.stream().map(CarConverter::convertToDto).toList();
    }

    @Override
    public CarDto update(Long id, UpdateCarDto car) {
        Car carEntity = CarConverter.convertUpdateCarDtoToEntity(car);

        verifyCarExists(id);

        carEntity.setId(id);

        LOGGER.info(CAR_UPDATED);

        return CarConverter.convertToDto(carRepository.save(carEntity));
    }

    @Override
    public void deleteById(Long id) {
        verifyCarExists(id);

        LOGGER.info(CAR_DELETED);

        carRepository.deleteById(id);
    }

    @Override
    public List<CarDto> findCarsByTeacherId(Long id) {
        List<Car> carsEntities = carRepository.findCarsByTeacherId(id);

        if (carsEntities.isEmpty()) {
            throw new CarsNotFoundException();
        }

        return carsEntities.stream().map(CarConverter::convertToDto).toList();
    }
}
