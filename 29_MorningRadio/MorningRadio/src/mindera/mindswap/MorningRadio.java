package mindera.mindswap;

import static mindera.mindswap.Host.MUSIC_LOVER;
import static mindera.mindswap.Host.TALKER;
import static mindera.mindswap.Song.*;

public class MorningRadio {
    private int maxNumberSongsPerDay;

    private boolean emissionIsClosed = false;

    private int totalNumberOfPlayedSongs = 0;
    private int numberOfPlayedSongs = 0;
    private Host host;

    public MorningRadio(Host host) {
        this.host = host;
        maxNumberSongsPerDay = host == MUSIC_LOVER ? 100 : 50;
    }

    public void playSong() {
        if (totalNumberOfPlayedSongs == maxNumberSongsPerDay || emissionIsClosed) {
            System.out.println("We can't play more songs for today. Please open emission again.");

            emissionIsClosed = true;

            totalNumberOfPlayedSongs = 0;

            numberOfPlayedSongs = 0;

            return;
        }

        if (numberOfPlayedSongs == 2) {
            Song.start(COMMERCIAL_BREAK);

            numberOfPlayedSongs = 0;

            return;
        }

        int randomSong = (int) (Math.random() * 7 - 1 + 1) + 1;

        if (numberOfPlayedSongs == 1 && host == TALKER) {
            System.out.println("Talking...");
        } else {
            Song.start(randomSong);
        }

        totalNumberOfPlayedSongs++;

        numberOfPlayedSongs++;
    }

    public void openEmission(Weekday weekday) {
        emissionIsClosed = false;

        switch (weekday) {
            case MONDAY:
                Song.start(I_CANT_MAKE_YOU_LOVE_ME);
                break;
            case TUESDAY:
                Song.start(COWBOYS_DONT_CRY);
                break;
            case WEDNESDAY:
                Song.start(FEEL_IT_STILL);
                break;
            case THURSDAY:
                Song.start(THUNDERSTRUCK);
                break;
            case FRIDAY:
                Song.start(HEAT_WAVES);
                break;
            case SATURDAY:
                Song.start(DESERT_WINDS);
                break;
            case SUNDAY:
            default:
                Song.start(EYE_OF_THE_TIGER);
                break;
        }

        totalNumberOfPlayedSongs++;

        numberOfPlayedSongs++;
    }
}
