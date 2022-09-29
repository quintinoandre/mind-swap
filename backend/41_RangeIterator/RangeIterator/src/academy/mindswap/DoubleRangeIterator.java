package academy.mindswap;

import java.util.Iterator;

public final class DoubleRangeIterator {
    private DoubleRangeIterator() {
    }

    public static Iterator<Double> iterator(Double minValue, Double maxValue, boolean reverse, Double step) {
        return new Iterator<Double>() {
            private Double currentIndex = reverse ? maxValue : minValue;

            @Override
            public boolean hasNext() {
                return reverse ? currentIndex >= minValue : currentIndex <= maxValue;
            }

            @Override
            public Double next() {
                Double valueToReturn = currentIndex;

                if (reverse) {
                    currentIndex -= step;
                } else {
                    currentIndex += step;
                }

                return valueToReturn;
            }
        };
    }
}
