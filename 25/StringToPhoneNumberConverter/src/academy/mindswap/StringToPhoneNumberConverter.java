package academy.mindswap;

public final class StringToPhoneNumberConverter {
    private static final String[] phoneKeys = {" ", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ", "*"};

    private StringToPhoneNumberConverter() {
    }

    public static String convert(String str) {
        char[] charArray = str.toCharArray();

        String numberConverted = "";

        for (int i = 0; i < charArray.length; i++) {
            numberConverted = numberConverted.concat(getNumberFromLetter(charArray[i]));
        }

        return numberConverted;
    }

    private static String getNumberFromLetter(char letter) {
        for (int i = 0; i < phoneKeys.length; i++) {
            if (phoneKeys[i].contains(String.valueOf(letter))) {
                return i == phoneKeys.length - 1 ? "0" : String.valueOf(i + 1);
            }
        }

        return "";
    }
}
