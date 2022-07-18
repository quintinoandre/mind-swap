package academy.mindswap;

import java.util.SplittableRandom;

import static academy.mindswap.Print.*;

public class DrunkBear extends Bear {
    SplittableRandom random = new SplittableRandom();

    @Override
    public void talk() {
        boolean fallAsleep = random.nextInt(1, 101) <= 20;

        if (getBatteryLevel() == LIMIT_BATTERY_LEVEL) {
            Print.message(LOW_BATTERY);

            return;
        }
        
        if (fallAsleep) {
            Print.message(SNORING);

            decreaseBatteryLevel();

            return;
        }


        Print.message(LOVE_YOU);

        decreaseBatteryLevel();
    }
}
