# The Vehicle Rental Shop

### A vehicle rental shop has a list of vehicles available for renting.

### These vehicles can be rented by requesting a car or a motorcycle, specifically.

### All vehicles start with 25L in their tank.

### After being used, the vehicle can be returned to the store.

### The vehicle should be returned in specific conditions:

### The fuel amount available in the vehicle should be 20L. If not, the missing amount will be charged (1.5 euro/L).

## VEHICLE: CAR

### A car is a vehicle, and it as all vehicles, it has a model name and gas consumption value (KM/L). It also has a maximum speed value of 120km/h.

### A trip with the car (driving) is represented by indicating the distance and time of the trip.

### The trip cannot be performed if:

- The necessary speed is higher than the maximum speed
- There is not enough gas for the distance

### Otherwise, the trip will result in reducing the available fuel (according to its gas consumption value).

### The car, as any vehicle, can be refuelled.

## VEHICLE: HYBRID CAR

### A hybrid car is a specific type of car, which has a battery-related properties beyond the car properties.

### Specifically, hybrid cars have a battery power (starting at full charge), and a battery consumption value (KM/%).

### For driving, the hybrid car's system may choose to spend battery power for the trip if:

- The trip's speed is lower than 25km/h
- There is enough battery power for the trip

### Otherwise, it behaves as a regular car.

### The battery of the hybrid car can also be recharged.

## VEHICLE: MOTORCYCLE

### A motorcycle is a vehicle, and it has a model name, a gas consumption value (KM/L), and a maximum speed value of 100km/h.

### The trip is performed similarly to a car, with a small difference: motorcycles can only perform shorter trips, with a maximum of 80km.

### The motorcycle, as any vehicle, can be refuelled.
