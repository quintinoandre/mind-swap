package academy.mindswap;

public final class Greeting {
    private Greeting() {
    }

    public static void greeting(String name) {
        System.out.printf("Hello, %s!%n", name);
    }
}
