package academy.mindswap;

import academy.mindswap.exceptions.NotExistingElementException;
import academy.mindswap.exceptions.NotNullElementException;
import academy.mindswap.logs.Logger;

import java.util.Iterator;

import static academy.mindswap.logs.LoggerType.ERROR;
import static academy.mindswap.logs.LoggerType.SUCCESS;
import static academy.mindswap.utils.Messages.*;

public class ArrayList<T> implements Iterable<T> {
    private T[] backbone;
    private static final int ARRAY_LIST_MIN_SIZE = 10;

    private int numberOfElements;

    public ArrayList() {
        backbone = (T[]) new Object[ARRAY_LIST_MIN_SIZE];

        numberOfElements = 0;
    }

    private void doubleArray() {
        T[] doubleArray = (T[]) new Object[size() * 2];

        for (int i = 0; i < size(); i++) {
            doubleArray[i] = backbone[i];
        }

        backbone = doubleArray;
    }

    private void decreaseArraySizeByHalf() {
        T[] halfArray = (T[]) new Object[size() / 2];

        for (int i = 0; i < numberOfElements; i++) {
            halfArray[i] = backbone[i];
        }

        backbone = halfArray;
    }

    public int size() {
        return backbone.length;
    }

    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    public boolean contains(T o) {
        if (o == null) {
            Logger.log(ERROR, "contains(Object o) - " + NO_NULL_ELEMENT);

            return false;
        }

        if (isEmpty()) {
            Logger.log(ERROR, "contains(Object o) - " + NOT_EXISTING_ELEMENT);

            return false;
        }

        for (int i = 0; i < numberOfElements - 1; i++) {
            if (backbone[i].equals(o)) {
                return true;
            }
        }

        return false;
    }

    public Iterator iterator() {
        return new Iterator() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < numberOfElements;
            }

            @Override
            public Object next() {
                return get(currentIndex++);
            }
        };
    }

    public T[] toArray() {
        T[] arrayToReturn = (T[]) new Object[numberOfElements];

        for (int i = 0; i < numberOfElements; i++) {
            arrayToReturn[i] = backbone[i];
        }

        return arrayToReturn;
    }

    public boolean add(T o) {
        if (o == null) {
            Logger.log(ERROR, "add(Object o) - " + NO_NULL_ELEMENT);

            return false;
        }

        if (numberOfElements == size()) {
            doubleArray();
        }

        backbone[numberOfElements] = o;

        numberOfElements++;

        Logger.log(SUCCESS, "add(Object o) - " + NEW_ELEMENT_ADDED);

        return true;
    }

    public boolean remove(T o) {
        if (o == null) {
            Logger.log(ERROR, "remove(Object o) - " + NO_NULL_ELEMENT);

            return false;
        }

        if (isEmpty()) {
            Logger.log(ERROR, "remove(Object o) - " + NOT_EXISTING_ELEMENT);

            return false;
        }

        int previousNumberOfElements = numberOfElements;

        for (int i = 0; i < numberOfElements; i++) {
            if (backbone[i].equals(o)) {
                backbone[i] = null;

                for (int j = i; j < numberOfElements; j++) {
                    backbone[j] = backbone[j + 1];
                }

                numberOfElements--;

                Logger.log(SUCCESS, "remove(Object o) - " + ELEMENT_REMOVED);

                i--;
            }
        }

        if (previousNumberOfElements == numberOfElements) {
            Logger.log(ERROR, "remove(Object o) - " + NOT_EXISTING_ELEMENT);

            return false;
        }

        if (size() >= numberOfElements * 2) {
            decreaseArraySizeByHalf();
        }

        return true;
    }

    public void clear() {
        for (int i = 0; i < numberOfElements; i++) {
            backbone[i] = null;
        }

        if (backbone.length > ARRAY_LIST_MIN_SIZE) {
            backbone = (T[]) new Object[ARRAY_LIST_MIN_SIZE];
        }

        numberOfElements = 0;
    }

    public T get(int index) throws NotExistingElementException {
        if (index > numberOfElements - 1 || isEmpty()) {
            Logger.log(ERROR, "get(int index) - " + NOT_EXISTING_ELEMENT);

            throw new NotExistingElementException();
        }

        return backbone[index];
    }

    public T set(int index, T element) {
        if (element == null) {
            Logger.log(ERROR, "set(int index, Object element)" + NO_NULL_ELEMENT);

            throw new NotNullElementException();
        }

        if (index > numberOfElements - 1 || isEmpty()) {
            Logger.log(ERROR, "set(int index, Object element)" + NOT_EXISTING_ELEMENT);

            throw new NotExistingElementException();
        }

        backbone[index] = element;

        return element;
    }

    public void add(int index, T element) {
        if (element == null) {
            Logger.log(ERROR, "add(int index, Object element) - " + NO_NULL_ELEMENT);

            throw new NotNullElementException();
        }

        if (index >= numberOfElements) {
            add(element);

            return;
        }

        if (numberOfElements == size()) {
            doubleArray();
        }

        for (int i = numberOfElements - 1; i >= 0; i--) {
            backbone[i + 1] = backbone[i];

            if (index == i) {
                backbone[i] = element;

                break;
            }
        }

        numberOfElements++;

        Logger.log(SUCCESS, "add(int index, Object element) - " + NEW_ELEMENT_ADDED);
    }

    public T remove(int index) {
        if (index > numberOfElements - 1 || isEmpty()) {
            Logger.log(ERROR, "remove(int index) - " + NOT_EXISTING_ELEMENT);

            throw new NotExistingElementException();
        }

        T objToReturn = backbone[index];

        backbone[index] = null;

        if (index == numberOfElements - 1) {
            numberOfElements--;

            Logger.log(SUCCESS, "remove(int index) - " + ELEMENT_REMOVED);

            if (size() >= numberOfElements * 2) {
                decreaseArraySizeByHalf();
            }

            return objToReturn;
        }

        for (int i = index; i < numberOfElements; i++) {
            backbone[i] = backbone[i + 1];
        }

        numberOfElements--;

        Logger.log(SUCCESS, "remove(int index) - " + ELEMENT_REMOVED);

        if (size() >= numberOfElements * 2) {
            decreaseArraySizeByHalf();
        }

        return objToReturn;
    }

    public int indexOf(T o) {
        if (o == null) {
            Logger.log(ERROR, "indexOf(Object o) - " + NO_NULL_ELEMENT);

            throw new NotNullElementException();
        }

        for (int i = 0; i < numberOfElements; i++) {
            if (backbone[i].equals(o)) {
                return i;
            }
        }

        return -1;
    }

    public int lastIndexOf(T o) {
        if (o == null) {
            Logger.log(ERROR, "lastIndexOf(Object o) - " + NO_NULL_ELEMENT);

            throw new NotNullElementException();
        }

        for (int i = numberOfElements - 1; i >= 0; i--) {
            if (backbone[i].equals(o)) {
                return i;
            }
        }

        return -1;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }
}
