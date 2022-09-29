package academy.mindswap;

import static academy.mindswap.Print.*;

public class CrankyBear extends Bear {
    private boolean isDead = false;

    @Override
    public void talk() {
        if (isDead) {
            Print.message(LOW_BATTERY);

            return;
        }

        if (getBatteryLevel() < 50) {
            singSadSong();

            return;
        }

        Print.message(LOVE_YOU);

        decreaseBatteryLevel();
    }

    private void singSadSong() {
        Print.message(SAD_SONG);

        isDead = true;
    }

    @Override
    public void chargeBattery() {
        super.chargeBattery();

        isDead = false;
    }
}
