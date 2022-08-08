package academy.mindswap;

public class StolenNumber {
    public static void main(String[] args) {
        System.out.println(findStolenNumber(new int[]{1, 2, 3, 5, 6, 7, 8, 9, 10}));
        System.out.println(findStolenNumber(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 10}));
        System.out.println(findStolenNumber(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
    }

    public static String findStolenNumber(int[] numbers) {
        String returnedNumber;

        for (int i = 1; i <= numbers.length; i++) {
            if (i != numbers[i - 1]) {
                returnedNumber = String.valueOf(i);

                return returnedNumber;
            }
        }

        return "no number was stolen";
    }
}
