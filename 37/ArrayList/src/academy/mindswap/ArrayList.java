package academy.mindswap;

import academy.mindswap.exceptions.NotExistingElementException;
import academy.mindswap.exceptions.NotNullElementException;
import academy.mindswap.logs.Logger;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static academy.mindswap.logs.LoggerType.ERROR;
import static academy.mindswap.logs.LoggerType.SUCCESS;
import static academy.mindswap.utils.Messages.*;

public class ArrayList implements List {
    private Object[] backbone;
    private static final int ARRAY_LIST_MIN_SIZE = 10;

    private int numberOfElements;

    public ArrayList() {
        backbone = new Object[ARRAY_LIST_MIN_SIZE];

        numberOfElements = 0;
    }

    private void doubleArray() {
        Object[] doubleArray = new Object[size() * 2];

        for (int i = 0; i < size(); i++) {
            doubleArray[i] = backbone[i];
        }

        backbone = doubleArray;
    }

    private void decreaseArraySizeByHalf() {
        Object[] halfArray = new Object[size() / 2];

        for (int i = 0; i < numberOfElements; i++) {
            halfArray[i] = backbone[i];
        }

        backbone = halfArray;
    }

    @Override
    public int size() {
        return backbone.length;
    }

    @Override
    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    @Override
    public boolean contains(Object o) {
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

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        Object[] arrayToReturn = new Object[numberOfElements];

        for (int i = 0; i < numberOfElements; i++) {
            arrayToReturn[i] = backbone[i];
        }

        return arrayToReturn;
    }

    @Override
    public boolean add(Object o) {
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

    @Override
    public boolean remove(Object o) {
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

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < numberOfElements; i++) {
            backbone[i] = null;
        }

        if (backbone.length > ARRAY_LIST_MIN_SIZE) {
            backbone = new Object[ARRAY_LIST_MIN_SIZE];
        }

        numberOfElements = 0;
    }

    @Override
    public Object get(int index) throws NotExistingElementException {
        if (index > numberOfElements - 1 || isEmpty()) {
            Logger.log(ERROR, "get(int index) - " + NOT_EXISTING_ELEMENT);

            throw new NotExistingElementException();
        }

        return backbone[index];
    }

    @Override
    public Object set(int index, Object element) {
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

    @Override
    public void add(int index, Object element) {
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

    @Override
    public Object remove(int index) {
        if (index > numberOfElements - 1 || isEmpty()) {
            Logger.log(ERROR, "remove(int index) - " + NOT_EXISTING_ELEMENT);

            throw new NotExistingElementException();
        }

        Object objToReturn = backbone[index];

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

    @Override
    public int indexOf(Object o) {
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

    @Override
    public int lastIndexOf(Object o) {
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

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }
}
