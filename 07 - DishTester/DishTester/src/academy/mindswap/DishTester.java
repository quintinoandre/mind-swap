package academy.mindswap;

public class DishTester {
    public static void main(String[] args) {
        System.out.println(testDish("Bobb Dylan", "beef wellington"));
        System.out.println(testDish("Mick Jagger", "mushroom soup"));
    }

    public static boolean testDish(String musicianName, String dish) {
        return musicianName.toLowerCase().charAt(0) == dish.toLowerCase().charAt(0)
                && musicianName.toLowerCase().charAt(musicianName.length() - 1) ==
                dish.toLowerCase().charAt(dish.length() - 1);
    }
}
