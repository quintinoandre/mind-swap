package academy.mindswap;

public final class ClosestNumbers {
    private ClosestNumbers() {
    }

    public static int[] calculateClosestNumbers(int[] numbers) {
        int previousSmallestDifference = Math.abs(numbers[0] - numbers[1]);
        int nextSmallestDifference;
        int[] closestNumbers = {numbers[0], numbers[1]};

        for (int i = 1; i < numbers.length - 1; i++) {
            nextSmallestDifference = Math.abs(numbers[i] - numbers[i + 1]);

            if (nextSmallestDifference < previousSmallestDifference) {
                previousSmallestDifference = nextSmallestDifference;

                closestNumbers[0] = numbers[i];

                closestNumbers[1] = numbers[i + 1];
            }
        }

        return closestNumbers;
    }
}
