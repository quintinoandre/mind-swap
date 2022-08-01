package academy.mindswap;

public class Test {
    public static void main(String[] args) {
        addANewElementToTheArrayListByObject_ShouldReturnTrueAndIncreaseANumberOfElementsByOne();
        addANewNullElementToTheArrayListByObject_ShouldReturnFalse();

        addANewElementToTheArrayListByIndexAndObject_ShouldIncreaseANumberOfElementsByOne();
        addANewNullElementToTheArrayListByIndexAndObject_ShouldNotIncreaseANumberOfElements();

        getAnElementByIndex_ShouldReturnTheRequiredElement();
        getANonExistingElementByIndex_ShouldReturnAnException();

        clearArray_ShouldPutAllTheArrayElementsIntoNullAndResizeTheArrayListToDefaultSize();

        removeAnElementFromTheArrayListByObject_ShouldDecreaseANumberOfElements();
        removeANullElementFromTheArrayListByObject_ShouldReturnFalse();
        removeAnElementFromAnEmptyArrayListByObject_ShouldReturnFalse();
        removeANonExistingElementFromAnArrayListByObject_ShouldReturnFalse();

        removeAnElementFromTheArrayListByIndex_ShouldDecreaseANumberOfElements();
        removeAnElementFromAnEmptyArrayListByIndex_ShouldReturnAnException();
        removeANonExistingElementFromAnArrayListByIndex_ShouldReturnAnException();

        checkIfAnElementExistsByObject_ShouldReturnTrue();
        checkIfANonExistingElementExistsByObject_ShouldReturnFalse();
        checkIfANullElementExistsByObject_ShouldReturnFalse();
        checkIfAnElementExistsOnAEmptyArrayListByObject_ShouldReturnTrue();

        toArray_ShouldReturnAnArrayWithNonNullElements();

        // TODO: set(int index, Object element)
        // TODO: indexOf(Object o)
        // TODO: lastIndexOf(Object o)
    }

    private static void addANewElementToTheArrayListByObject_ShouldReturnTrueAndIncreaseANumberOfElementsByOne() {
        //GIVEN
        ArrayList arrayList = new ArrayList();
        Object obj = new Object();

        //WHEN
        arrayList.add(obj);

        //THEN
        if (arrayList.getNumberOfElements() != 1) {
            throw new RuntimeException("The ArrayList size should be 1. Was " + arrayList.getNumberOfElements() + ".");
        }

        if (arrayList.get(0) != obj) {
            throw new RuntimeException("The element wasn't added.");
        }
    }

    private static void addANewNullElementToTheArrayListByObject_ShouldReturnFalse() {
        //GIVEN
        ArrayList arrayList = new ArrayList();

        //WHEN
        boolean response = arrayList.add(null);

        //THEN
        if (response) {
            throw new RuntimeException("The new object was added to the ArrayList.");
        }
    }

    private static void addANewElementToTheArrayListByIndexAndObject_ShouldIncreaseANumberOfElementsByOne() {
        //GIVEN
        ArrayList arrayList = new ArrayList();
        Object obj = new Object();
        arrayList.add(obj);
        arrayList.add(obj);
        arrayList.add(obj);

        //WHEN
        arrayList.add(1, obj);

        //THEN
        if (arrayList.getNumberOfElements() != 4) {
            throw new RuntimeException("The ArrayList size should be 4. Was " + arrayList.getNumberOfElements() + ".");
        }

        if (arrayList.get(0) != obj) {
            throw new RuntimeException("The element wasn't added.");
        }
    }

    private static void addANewNullElementToTheArrayListByIndexAndObject_ShouldNotIncreaseANumberOfElements() {
        //GIVEN
        ArrayList arrayList = new ArrayList();

        //WHEN / THEN
        try {
            arrayList.add(5, null);
        } catch (ArrayIndexOutOfBoundsException e) {
            return;
        }
    }

    private static void getAnElementByIndex_ShouldReturnTheRequiredElement() {
        //GIVEN
        ArrayList arrayList = new ArrayList();
        Object obj = new Object();
        arrayList.add(obj);

        //WHEN
        Object responseObject = arrayList.get(0);

        //THEN
        if (responseObject != obj) {
            throw new RuntimeException("The required element was not the one obtained.");
        }
    }

    private static void getANonExistingElementByIndex_ShouldReturnAnException() {
        //GIVEN
        ArrayList arrayList = new ArrayList();
        Object obj = new Object();
        arrayList.add(obj);

        //WHEN / THEN
        try {
            arrayList.get(1);
        } catch (ArrayIndexOutOfBoundsException e) {
            return;
        }
    }

    private static void clearArray_ShouldPutAllTheArrayElementsIntoNullAndResizeTheArrayListToDefaultSize() {
        //GIVEN
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 11; i++) {
            arrayList.add(i);
        }

        //WHEN
        arrayList.clear();

        //THEN
        if (arrayList.size() != 10) {
            throw new RuntimeException("The ArrayList wasn't cleaned properly.");
        }

        try {
            arrayList.get(0);
        } catch (ArrayIndexOutOfBoundsException e) {
            return;
        }
    }

    private static void removeAnElementFromTheArrayListByObject_ShouldDecreaseANumberOfElements() {
        //GIVEN
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(1);
        Object obj = 1;

        //WHEN
        arrayList.remove(obj);

        //THEN
        if (arrayList.getNumberOfElements() != 4) {
            throw new RuntimeException("The ArrayList size should be 4. Was " + arrayList.getNumberOfElements() + ".");
        }

        try {
            arrayList.get(4);
        } catch (ArrayIndexOutOfBoundsException e) {
            return;
        }
    }

    private static void removeANullElementFromTheArrayListByObject_ShouldReturnFalse() {
        //GIVEN
        ArrayList arrayList = new ArrayList();

        //WHEN
        boolean response = arrayList.remove(null);

        //THEN
        if (response) {
            throw new RuntimeException("The object was removed from the ArrayList.");
        }
    }

    private static void removeAnElementFromAnEmptyArrayListByObject_ShouldReturnFalse() {
        //GIVEN
        ArrayList arrayList = new ArrayList();
        Object obj = new Object();

        //WHEN
        boolean response = arrayList.remove(obj);

        //THEN
        if (response) {
            throw new RuntimeException("The object was removed from the ArrayList.");
        }
    }

    private static void removeANonExistingElementFromAnArrayListByObject_ShouldReturnFalse() {
        //GIVEN
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        Object obj = 4;

        //WHEN
        boolean response = arrayList.remove(obj);

        //THEN
        if (response) {
            throw new RuntimeException("The object was removed from the ArrayList.");
        }
    }

    private static void removeAnElementFromTheArrayListByIndex_ShouldDecreaseANumberOfElements() {
        //GIVEN
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        //WHEN
        arrayList.remove(1);

        //THEN
        if (arrayList.getNumberOfElements() != 2) {
            throw new RuntimeException("The ArrayList size should be 2. Was " + arrayList.getNumberOfElements() + ".");
        }
    }

    private static void removeAnElementFromAnEmptyArrayListByIndex_ShouldReturnAnException() {
        //GIVEN
        ArrayList arrayList = new ArrayList();

        //WHEN / THEN
        try {
            arrayList.remove(0);
        } catch (ArrayIndexOutOfBoundsException e) {
            return;
        }
    }

    private static void removeANonExistingElementFromAnArrayListByIndex_ShouldReturnAnException() {
        //GIVEN
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        //WHEN / THEN
        try {
            arrayList.remove(3);
        } catch (ArrayIndexOutOfBoundsException e) {
            return;
        }
    }

    private static void checkIfAnElementExistsByObject_ShouldReturnTrue() {
        //GIVEN
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        //WHEN
        boolean response = arrayList.contains(2);

        //THEN
        if (!response) {
            throw new RuntimeException("The object doesn't exists on the ArrayList.");
        }
    }

    private static void checkIfANonExistingElementExistsByObject_ShouldReturnFalse() {
        //GIVEN
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        //WHEN
        boolean response = arrayList.contains(4);

        //THEN
        if (response) {
            throw new RuntimeException("The object exists on the ArrayList.");
        }
    }

    private static void checkIfANullElementExistsByObject_ShouldReturnFalse() {
        //GIVEN
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);

        //WHEN
        boolean response = arrayList.contains(null);

        //THEN
        if (response) {
            throw new RuntimeException("The object exists on the ArrayList.");
        }
    }

    private static void checkIfAnElementExistsOnAEmptyArrayListByObject_ShouldReturnTrue() {
        //GIVEN
        ArrayList arrayList = new ArrayList();

        //WHEN
        boolean response = arrayList.contains(1);

        //THEN
        if (response) {
            throw new RuntimeException("The object exists on the ArrayList.");
        }
    }

    private static void toArray_ShouldReturnAnArrayWithNonNullElements() {
        //GIVEN
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        //WHEN
        Object[] array = arrayList.toArray();

        //THEN
        if (array.length != 3) {
            throw new RuntimeException("The array doesn't have the right size.");
        }
    }
}
