package academy.mindswap;

import static academy.mindswap.Message.GAS_LIMIT_VIOLATED;
import static academy.mindswap.Message.TRIP_ALLOWED;

public abstract class Vehicle {
    private int tankFuelLevel;
    private String modelName;
    private float gasConsumption;
    private int maximumSpeed;

    protected Vehicle(String modelName, float gasConsumption, int maximumSpeed) {
        this.modelName = modelName;
        this.gasConsumption = gasConsumption;
        this.maximumSpeed = maximumSpeed;
        tankFuelLevel = 25;
    }

    public void startTrip(float distance, float time) {
        if (isSpeedLimitViolated(distance, time)) {
            Message.speedLimitViolated(calculateNecessarySpeed(distance, time), maximumSpeed);

            return;
        }
        if (!isEnoughtGas(distance)) {
            Message.print(GAS_LIMIT_VIOLATED);

            return;
        }

        decreaseFuel(calculateNecessaryGas(distance));

        Message.print(TRIP_ALLOWED);
    }

    private boolean isSpeedLimitViolated(float distance, float time) {
        return calculateNecessarySpeed(distance, time) > getMaximumSpeed();
    }

    protected float calculateNecessarySpeed(float distance, float time) {
        return distance / time;
    }

    private boolean isEnoughtGas(float distance) {
        return calculateNecessaryGas(distance) <= getTankFuelLevel();
    }

    private void decreaseFuel(float fuelSpent) {
        tankFuelLevel -= fuelSpent;
    }

    private float calculateNecessaryGas(float distance) {
        return (distance * getGasConsumption()) / 100;
    }

    public void refuellGas() {
        tankFuelLevel = 25;
    }

    private int getTankFuelLevel() {
        return tankFuelLevel;
    }

    private int getMaximumSpeed() {
        return maximumSpeed;
    }

    private float getGasConsumption() {
        return gasConsumption;
    }
}
