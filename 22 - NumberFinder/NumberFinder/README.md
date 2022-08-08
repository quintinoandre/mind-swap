````java
package intro_to_java.level2;

public class NumberFinder {

    private static final int[] NUMBERS = {19, 24, 38, 26, 47, 12, 3, 33};

    public static void main(String[] args) {
        findNumber(3); // should print the index where the number was found (6, in this case)
        findNumber(19); // should print the index where the number was found (0, in this case)
        findNumber(1); // should print the index where the number was found (-1, in this case)
    }

    // Implement a method that is capable of finding a given number in the NUMBERS array
    private static void findNumber(int toFind) {

    }
}
````
