package academy.mindswap;

import static academy.mindswap.utils.PrintSeparator.printSeparator;

public class Main {
    public static void main(String[] args) {
        RangeIterator<Integer> rangeIterator = new RangeIterator<>(12, 23, false,
                1);

        for (Object num : rangeIterator) {
            System.out.println(num);
        }

        printSeparator("-", 50);

        RangeIterator<Float> rangeIterator2 = new RangeIterator<>(12.5f, 23.5f, true,
                0.1f);

        for (Object num : rangeIterator2) {
            System.out.println(num);
        }

        printSeparator("-", 50);

        RangeIterator<Double> rangeIterator3 = new RangeIterator<>(12.5d, 23.5d, false,
                0.1d);

        for (Object num : rangeIterator3) {
            System.out.println(num);
        }

        //new RangeIterator(12, 23.5, false, 1);
        new RangeIterator("12", "23", false, "1");
    }
}
