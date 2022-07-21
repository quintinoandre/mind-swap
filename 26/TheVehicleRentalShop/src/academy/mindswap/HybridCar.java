package academy.mindswap;

import static academy.mindswap.Message.HYBRID_TRIP_ALLOWED;

public class HybridCar extends Car {
    private float batteryPowerLevel;
    private float batteryConsumption;

    public HybridCar(String modelName, float gasConsumption, float batteryConsumption) {
        super(modelName, gasConsumption);

        this.batteryPowerLevel = 100;
        this.batteryConsumption = batteryConsumption;
    }

    @Override
    public void startTrip(float distance, float time) {
        if (calculateNecessarySpeed(distance, time) <= 25 && isEnoughtBatteryPower(distance)) {

            decreaseBattery(calculateNecessaryBatteryPower(distance));

            Message.print(HYBRID_TRIP_ALLOWED);

            return;
        }

        super.startTrip(distance, time);
    }

    private float calculateNecessaryBatteryPower(float distance) {
        return (distance * getBatteryConsumption()) / 100;
    }

    private boolean isEnoughtBatteryPower(float distance) {
        return calculateNecessaryBatteryPower(distance) <= getBatteryPowerLevel();
    }

    private void decreaseBattery(float batterySpent) {
        batteryPowerLevel -= batterySpent;
    }

    public void refuellBattery() {
        batteryPowerLevel = 100;
    }

    private float getBatteryConsumption() {
        return batteryConsumption;
    }

    private float getBatteryPowerLevel() {
        return batteryPowerLevel;
    }
}
