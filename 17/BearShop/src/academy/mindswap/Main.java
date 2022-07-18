package academy.mindswap;

public class Main {
    public static void main(String[] args) {

        /*CrankyBear crankyBear = new CrankyBear();

        for (int i = 0; i < 60; i++) {
            crankyBear.talk();
        }*/

        Shop shop1 = new Shop("Shop A");
        Shop shop2 = new Shop("Shop B");

        for (int i = 0; i < 50; i++) {
            shop1.createABear();
        }

        for (int i = 0; i < 100; i++) {
            shop2.createABear();
        }

        shop1.getTypeOfBearsCreated();
        shop2.getTypeOfBearsCreated();

        shop1.compareProduction(shop2);
        shop2.compareProduction(shop1);
    }
}
