package academy.mindswap;

public class Main {
    public static void main(String[] args) {
        int[] NUMBERS = {23, 45, 67, 123, 26, 33, 31, 4};

        int[] result = ClosestNumbers.calculateClosestNumbers(NUMBERS);

        System.out.printf("[%d,%d]%n", result[0], result[1]);
    }
}
