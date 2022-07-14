package academy.mindswap;

public class Engine {
    private Engine() {
    }

    public static void moveCar(int km, Tire[] tires) {
        for (Tire tire : tires) {
            tire.updateIntegrity(km);
        }
    }
}
