package academy.mindswap;

public class Calculator {
    public float sum(float number1, float number2) {
        return number1 + number2;
    }

    public float subtract(float number1, float number2) {
        return number1 - number2;
    }

    public float multiply(float number1, float number2) {
        return number1 * number2;
    }

    public float divide(float number1, float number2) {
        if (number2 == 0) {
            return 0;
        }

        return number1 / number2;
    }

}
