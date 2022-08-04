package academy.mindswap;

import java.util.Iterator;

public class RangeIterator<T> implements Iterable<T> {
    private Integer integerMinValue;
    private Integer integerMaxValue;
    private Integer integerStep;


    private Float floatMinValue;
    private Float floatMaxValue;
    private Float floatStep;

    private Double doubleMinValue;
    private Double doubleMaxValue;
    private Double doubleStep;
    private final boolean reverse;


    public RangeIterator(T firstValue, T secondValue, boolean reverse, T step) {
        if (firstValue instanceof Integer) {
            this.integerMinValue = Math.min(((Integer) firstValue), ((Integer) secondValue));
            this.integerMaxValue = Math.max((Integer) firstValue, ((Integer) secondValue));
            this.integerStep = ((Integer) step);
        }

        if (firstValue instanceof Float) {
            this.floatMinValue = Math.min(((Float) firstValue), ((Float) secondValue));
            this.floatMaxValue = Math.max((Float) firstValue, ((Float) secondValue));
            this.floatStep = ((Float) step);
        }

        if (firstValue instanceof Double) {
            this.doubleMinValue = Math.min(((Double) firstValue), ((Double) secondValue));
            this.doubleMaxValue = Math.max((Double) firstValue, ((Double) secondValue));
            this.doubleStep = ((Double) step);
        }

        this.reverse = reverse;
    }

    @Override
    public Iterator<T> iterator() {
        if (floatMinValue != null) {
            return (Iterator<T>) FloatRangeIterator.iterator(floatMinValue, floatMaxValue, reverse, floatStep);
        }

        if (doubleMinValue != null) {
            return (Iterator<T>) DoubleRangeIterator.iterator(doubleMinValue, doubleMaxValue, reverse, doubleStep);
        }

        return (Iterator<T>) IntegerRangeIterator.iterator(integerMinValue, integerMaxValue, reverse, integerStep);
    }
}
