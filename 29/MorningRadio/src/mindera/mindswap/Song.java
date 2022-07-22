package mindera.mindswap;

public final class Song {
    public static final int I_CANT_MAKE_YOU_LOVE_ME = 1;
    public static final int COWBOYS_DONT_CRY = 2;
    public static final int FEEL_IT_STILL = 3;
    public static final int THUNDERSTRUCK = 4;
    public static final int HEAT_WAVES = 5;
    public static final int DESERT_WINDS = 6;
    public static final int EYE_OF_THE_TIGER = 7;
    public static final int COMMERCIAL_BREAK = 8;

    private Song() {
    }

    public static void start(int song) {
        switch (song) {
            case 1:
                System.out.println("I Can't Make You Love Me, by Landa");
                break;
            case 2:
                System.out.println("Cowboys Don’t Cry, by Oliver Tree");
                break;
            case 3:
                System.out.println("Feel It Still, by Portugal. The Man");
                break;
            case 4:
                System.out.println("Thunderstruck, by AC/DC");
                break;
            case 5:
                System.out.println("Heat Waves, by Glass Animals & iann dior");
                break;
            case 6:
                System.out.println("Desert Winds, by Joefish");
                break;
            case 8:
                System.out.println("Commercial break...");
                break;
            case 7:
            default:
                System.out.println("Eye of the Tiger, by Survivor");
                break;
        }
    }
}
