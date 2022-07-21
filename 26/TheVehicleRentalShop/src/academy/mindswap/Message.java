package academy.mindswap;

public final class Message {
    public static final String GAS_LIMIT_VIOLATED = "The gas necessary to perform this trip in the required time, is higher than the car's maximum gas level.";
    public static final String TRIP_ALLOWED = "You're allowed to perform your trip.";
    public static final String HYBRID_TRIP_ALLOWED = "You made your trip in electric mode.";
    public static final String DISTANCE_LIMIT_VIOLATED = "Your motorcycle can't perform distances bigger than 80km.";

    private Message() {
    }

    public static void print(String message) {
        System.out.println(message);
    }

    public static void speedLimitViolated(float necessarySpeed, float vehicleMaximumSpeed) {
        System.out.printf("You exceeded the speed limit of the car. The necessary speed to perform this trip in the " +
                        "required time is %dkm/h and the vehicle's maximum speed is %dkm/h.%n", (int) (necessarySpeed),
                (int) vehicleMaximumSpeed);
    }

    public static void gasLimitViolated(float necessaryGas, int tankFuelLevel) {
        System.out.printf("You exceeded the maximum gas level of the car. The necessary gas to perform this trip in " +
                "the required time is %fL and the vehicle's fuel level is %dL.%n", necessaryGas, tankFuelLevel);
    }
}
