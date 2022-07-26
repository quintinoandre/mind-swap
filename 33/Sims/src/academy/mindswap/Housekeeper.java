package academy.mindswap;

public class Housekeeper {
    private final String name;
    private boolean wasPaid;

    public Housekeeper(String name) {
        this.name = name;
    }

    public boolean wasPaid() {
        return wasPaid;
    }

    public void setWasPaid() {
        this.wasPaid = true;
    }
}
