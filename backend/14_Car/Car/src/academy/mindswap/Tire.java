package academy.mindswap;

public class Tire {
    private int integrity;
    private final int DETERIORATE_RATE = 5;

    public Tire() {
        integrity = 100; // valor default
    }

    public Tire(int integrity) {
        this.integrity = integrity;
    }

    public void updateIntegrity(int km) {
        integrity -= km * DETERIORATE_RATE;
    }

    public int getIntegrity() {
        return integrity;
    }
}
