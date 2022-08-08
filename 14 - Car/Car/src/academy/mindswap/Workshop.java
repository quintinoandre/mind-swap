package academy.mindswap;

public class Workshop {
    private Workshop() {
    }

    public static void changeTires(int integrityLimit, Tire[] tires) {
        for (int i = 0; i < tires.length; i++) {
            if (tires[i].getIntegrity() < integrityLimit) {
                tires[i] = new Tire();
            }
        }
    }
}
