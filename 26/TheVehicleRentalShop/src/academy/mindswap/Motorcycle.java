package academy.mindswap;

import static academy.mindswap.Message.DISTANCE_LIMIT_VIOLATED;

public class Motorcycle extends Vehicle {

    public Motorcycle(String modelName, float gasConsumption) {
        super(modelName, gasConsumption, 100);
    }

    @Override
    public void startTrip(float distance, float time) {
        if (distance > 80) {
            Message.print(DISTANCE_LIMIT_VIOLATED);

            return;
        }
        
        super.startTrip(distance, time);
    }
}
