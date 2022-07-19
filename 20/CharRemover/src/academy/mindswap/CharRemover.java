package academy.mindswap;

public final class CharRemover {
    private CharRemover() {
    }

    public static String removeChar(String str, int charIndex) {
        /*String[] charArray = str.split("");

        String newStr = "";

        for (int i = 0; i < charArray.length; i++) {
            if (i != charIndex) {
                newStr = newStr.concat(charArray[i]);
            }
        }

        return newStr;*/

        return str.substring(0, charIndex).concat(str.substring(charIndex + 1));
    }
}
