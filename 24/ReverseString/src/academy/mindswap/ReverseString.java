package academy.mindswap;

public final class ReverseString {
    private ReverseString() {
    }

    public static String reverse(String strToReverse) {
        String[] arrayStrToReverse = strToReverse.split("");
        String reversedString = "";

        for (int i = arrayStrToReverse.length; i > 0; i--) {
            reversedString = reversedString.concat(arrayStrToReverse[i - 1]);
        }

        return reversedString;
    }

}
