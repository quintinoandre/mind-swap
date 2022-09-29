package academy.mindswap.personscars.controller;

import academy.mindswap.personscars.models.Car;
import academy.mindswap.personscars.services.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public Car save(@RequestBody Car car) {
        return carService.save(car);
    }

    @GetMapping("/{id}")
    public Car findById(@PathVariable Integer id) {
        return carService.findById(id);
    }

    @GetMapping("bylicenseplate/{licenseplate}")
    public Car findByLicensePlateIgnoreCase(@PathVariable String licenseplate) {
        return carService.findByLicensePlateIgnoreCase(licenseplate);
    }

    @GetMapping("/bybrand/{brand}")
    public List<Car> findAllByBrand(@PathVariable String brand) {
        return carService.findAllByBrand(brand);
    }

    @GetMapping
    public List<Car> findAll() {
        return carService.findAll();
    }

    @PutMapping("/{id}")
    public Car updateById(@PathVariable Integer id, @RequestBody Car car) {
        return carService.updateById(id, car);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        carService.deleteById(id);
    }
}
