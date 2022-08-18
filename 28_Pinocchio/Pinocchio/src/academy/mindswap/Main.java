package academy.mindswap;

public class Main {
    public static void main(String[] args) {
        Pinocchio pinocchio = new Pinocchio();

        for (int i = 0; i < 98; i++) {
            pinocchio.lie();
        }

        pinocchio.lie();
        pinocchio.makeGoodDeed();
        pinocchio.fixes();
        pinocchio.lie();
        pinocchio.makeGoodDeed();
        pinocchio.makeGoodDeed();
        pinocchio.lie();
        pinocchio.lie();
        pinocchio.makeGoodDeed();
        pinocchio.makeGoodDeed();

        for (int i = 0; i < 100; i++) {
            pinocchio.lie();
        }
    }
}
