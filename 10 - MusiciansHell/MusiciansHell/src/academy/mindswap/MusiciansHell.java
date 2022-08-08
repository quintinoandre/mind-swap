package academy.mindswap;

public class MusiciansHell {
    public static void main(String[] args) {
        System.out.println(pickMusician(new String[]{"Steven Tyler", "Erykah Badu", "Mick Jagger", "Paul McCartney", "Brandon Flowers", "Alex Turner"}));
    }

    public static String pickMusician(String[] musicians) {
        int max = 15;
        int min = 10;

        for (String musicianName : musicians) {
            int randomNumber = (int) (Math.random() * (max - min + 1) + min);

            System.out.println(randomNumber);

            if (randomNumber < musicianName.replaceAll(" ", "").length()) return musicianName;
        }

        return "No one will stay to help.";

        /*
        for (int i = 0; i < musicians.length; i++) {
            if ((Math.random() * (15 - 10 + 1) + 10) < musicians[i].length()) {
                return musicians[i];
            }
        }

        return "No one will stay to help.";
        */
    }
}
