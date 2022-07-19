package academy.mindswap;

public final class NumberFinder {
    private static final int[] NUMBERS = {19, 24, 38, 26, 47, 12, 3, 33};

    private NumberFinder() {
    }

    public static int findNumber(int toFind) {
        for (int i = 0; i < NUMBERS.length; i++) {
            if (NUMBERS[i] == toFind) {
                return i;
            }
        }

        return -1;
    }
}
