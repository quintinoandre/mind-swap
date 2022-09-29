package academy.mindswap;

public final class CharacterSwitcher {
    private CharacterSwitcher() {
    }

    public static String switchCharacters(String str) {
        return str.substring(str.length() - 1).concat(str.substring(1, str.length() - 1)) + str.charAt(0);
    }
}
