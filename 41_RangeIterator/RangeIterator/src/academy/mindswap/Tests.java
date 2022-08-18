package academy.mindswap;

import academy.mindswap.exceptions.ValuesNotTheSameTypeException;
import academy.mindswap.exceptions.WrongTypeOfValuesException;

import java.util.LinkedList;
import java.util.List;

public final class Tests {
    private Tests() {
    }

    public static void main(String[] args) {
        ShouldReturnTheRangeWithIntegerValuesAndTheFirstNumberLowerThanTheSecondNumber();
        ShouldReturnTheRangeWithFloatValuesAndTheFirstNumberLowerThanTheSecondNumber();
        ShouldReturnTheRangeWithDoubleValuesAndTheFirstNumberLowerThanTheSecondNumber();
        ShouldNotReturnTheRangeWithValuesWithTheTypeDifferentFromIntegerFloatOrDouble();
        ShouldNotReturnTheRangeWithValuesOfDifferentTypes();
    }

    private static void ShouldReturnTheRangeWithIntegerValuesAndTheFirstNumberLowerThanTheSecondNumber() {
        //GIVEN
        Integer fistsNumber = 12;
        Integer secondNumber = 23;
        Integer step = 1;
        RangeIterator rangeIterator = new RangeIterator(fistsNumber, secondNumber, false, step);
        List list = new LinkedList();

        //WHEN
        for (Object num : rangeIterator) {
            list.add(num);
        }

        //THEN
        if (list.size() != ((secondNumber - fistsNumber) / step) + 1) {
            throw new RuntimeException("The range iterator doesn't return the right number of values");
        }
    }

    private static void ShouldReturnTheRangeWithFloatValuesAndTheFirstNumberLowerThanTheSecondNumber() {
        //GIVEN
        Float fistsNumber = 12.5f;
        Float secondNumber = 23.5f;
        Float step = 0.1f;
        RangeIterator rangeIterator = new RangeIterator(fistsNumber, secondNumber, false, step);
        List list = new LinkedList();

        //WHEN
        for (Object num : rangeIterator) {
            list.add(num);
        }

        //THEN
        if (list.size() == 0) {
            throw new RuntimeException("The range iterator doesn't return the right number of values");
        }
    }

    private static void ShouldReturnTheRangeWithDoubleValuesAndTheFirstNumberLowerThanTheSecondNumber() {
        //GIVEN
        Double fistsNumber = 12.5d;
        Double secondNumber = 23.5d;
        Double step = 0.1d;
        RangeIterator rangeIterator = new RangeIterator(fistsNumber, secondNumber, false, step);
        List list = new LinkedList();

        //WHEN
        for (Object num : rangeIterator) {
            list.add(num);
        }

        //THEN
        if (list.size() == 0) {
            throw new RuntimeException("The range iterator doesn't return the right number of values");
        }
    }

    private static void ShouldNotReturnTheRangeWithValuesWithTheTypeDifferentFromIntegerFloatOrDouble() {
        //GIVEN / WHEN / THEN
        try {
            new RangeIterator("12", "23", false, "1");
        } catch (WrongTypeOfValuesException e) {
            return;
        }
    }

    private static void ShouldNotReturnTheRangeWithValuesOfDifferentTypes() {
        //GIVEN / WHEN / THEN
        try {
            new RangeIterator(12, "23", false, 1);
        } catch (ValuesNotTheSameTypeException e) {
            return;
        }
    }
}



