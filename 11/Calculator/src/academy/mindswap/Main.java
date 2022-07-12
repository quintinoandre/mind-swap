package academy.mindswap;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        float sum = calculator.sum(1, 2);
        float subtract = calculator.subtract(4, 3);
        float multiply = calculator.multiply(2, 3);
        float divide = calculator.divide(6, 3);

        System.out.println(sum); //should print 3
        System.out.println(subtract); //should print 1
        System.out.println(multiply); //should print 6
        System.out.println(divide); //should print 2
    }
}
