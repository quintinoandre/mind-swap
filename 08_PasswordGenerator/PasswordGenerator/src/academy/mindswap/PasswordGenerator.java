package academy.mindswap;

public class PasswordGenerator {
    public static void main(String[] args) {
        System.out.println(generatePassword("Peter Gabriel"));
        System.out.println(generatePassword("Brian Adams"));
    }

    public static String generatePassword(String musicianName) {
        String[] musicianNames = musicianName.split(" ");

        return musicianNames[musicianNames.length - 1]
                .replaceAll("(?i)a", "@")
                .replaceAll("(?i)i", "!");
    }
}
