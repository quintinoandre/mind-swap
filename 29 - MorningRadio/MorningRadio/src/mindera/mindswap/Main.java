package mindera.mindswap;

import static mindera.mindswap.Host.MUSIC_LOVER;
import static mindera.mindswap.Weekday.MONDAY;
import static mindera.mindswap.Weekday.TUESDAY;

public class Main {
    public static void main(String[] args) {
        MorningRadio morningRadio = new MorningRadio(MUSIC_LOVER);

        morningRadio.openEmission(MONDAY);

        for (int i = 0; i < 148; i++) {
            morningRadio.playSong();
        }

        morningRadio.playSong();

        morningRadio.openEmission(TUESDAY);
    }
}
