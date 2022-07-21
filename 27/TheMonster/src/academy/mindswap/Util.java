package academy.mindswap;

public final class Util {

    public static int randomNumber(int min, int max) {
        if (min == max) {
            return min;
        }
        
        return (int) (Math.random() * max - min + 1) + min;
    }

    private Util() {
    }
}
