package academy.mindswap;

import java.util.Iterator;

public final class IntegerRangeIterator {
    private IntegerRangeIterator() {
    }

    public static Iterator<Integer> iterator(Integer minValue, Integer maxValue, boolean reverse, Integer step) {
        return new Iterator<Integer>() {
            private Integer currentIndex = reverse ? maxValue : minValue;

            @Override
            public boolean hasNext() {
                return reverse ? currentIndex >= minValue : currentIndex <= maxValue;
            }

            @Override
            public Integer next() {
                Integer valueToReturn = currentIndex;

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
