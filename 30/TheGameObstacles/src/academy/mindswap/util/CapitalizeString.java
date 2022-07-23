package academy.mindswap.util;

public final class CapitalizeString {
    private CapitalizeString() {
    }

    public static String capitalize(String string) {
        return string.substring(0, 1).concat(string.substring(1).toLowerCase());
    }
}
