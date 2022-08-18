package academy.mindswap;

public class Print {
    public static String LOVE_YOU = "I love you";
    public static String LOW_BATTERY = "Battery with low level, please charge it";
    public static String SAD_SONG = "I took my last breath";
    public static String SNORING = "Zzzz Zzzz Zzzz";

    private Print() {
    }

    public static void message(String message) {
        System.out.println(message);
    }
}
