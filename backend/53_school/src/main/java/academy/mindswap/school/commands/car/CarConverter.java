package academy.mindswap.school.commands.car;

import academy.mindswap.school.models.Car;

public final class CarConverter {
    private CarConverter() {
    }

    public static CarDto convertToDto(Car car) {
        return CarDto.builder()
                .id(car.getId())
                .brand(car.getBrand())
                .model(car.getModel())
                .licensePlate(car.getLicensePlate())
                .manufacturingDate(car.getManufacturingDate())
                .age(car.getAge())
                .build();
    }

    public static Car convertSaveCarDtoToEntity(SaveCarDto saveCarDto) {
        return Car.builder()
                .brand(saveCarDto.getBrand())
                .model(saveCarDto.getModel())
                .licensePlate(saveCarDto.getLicensePlate())
                .manufacturingDate(saveCarDto.getManufacturingDate())
                .build();
    }

    public static Car convertUpdateCarDtoToEntity(UpdateCarDto updateCarDto) {
        return Car.builder()
                .brand(updateCarDto.getBrand())
                .model(updateCarDto.getModel())
                .licensePlate(updateCarDto.getLicensePlate())
                .manufacturingDate(updateCarDto.getManufacturingDate())
                .build();
    }
}
