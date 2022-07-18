package academy.mindswap;

import static academy.mindswap.Print.LOVE_YOU;
import static academy.mindswap.Print.LOW_BATTERY;

public class Bear {
    public final int LIMIT_BATTERY_LEVEL = 5;
    private int batteryLevel;

    public Bear() {
        batteryLevel = 100;
    }

    public void talk() {
        if (getBatteryLevel() == LIMIT_BATTERY_LEVEL) {
            Print.message(LOW_BATTERY);

            return;
        }

        Print.message(LOVE_YOU);

        decreaseBatteryLevel();
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void decreaseBatteryLevel() {
        batteryLevel--;
    }

    public void chargeBattery() {
        batteryLevel = 100;
    }
}
