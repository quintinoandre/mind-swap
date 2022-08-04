package academy.mindswap;

import java.util.Iterator;

public final class FloatRangeIterator {
    private FloatRangeIterator() {
    }

    public static Iterator<Float> iterator(Float minValue, Float maxValue, boolean reverse, Float step) {
        return new Iterator<Float>() {
            private Float currentIndex = reverse ? maxValue : minValue;

            @Override
            public boolean hasNext() {
                return reverse ? currentIndex >= minValue : currentIndex <= maxValue;
            }

            @Override
            public Float next() {
                Float valueToReturn = currentIndex;

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
