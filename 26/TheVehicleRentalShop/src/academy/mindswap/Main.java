package academy.mindswap;

public class Main {
    public static void main(String[] args) {
        NormalCar normal = new NormalCar("Honda", 7);
        normal.startTrip(200, 1);

        HybridCar hybrid = new HybridCar("Nissan", 6, 6);
        // hybrid.startTrip(100, 1);

        Motorcycle moto = new Motorcycle("Yamaha", 6);
        moto.startTrip(80, 0.5f);
    }
}
