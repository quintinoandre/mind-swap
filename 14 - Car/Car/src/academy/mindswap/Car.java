package academy.mindswap;

public class Car {
    private Tire[] tires = {new Tire(), new Tire(20), new Tire(90), new Tire()};
    private final int INTEGRITY_LIMIT = 15;
    private boolean isCarOn;

    public void clickPowerButton() {
        if (isCarOn == false && !isTiresIntegrityOk()) {
            System.out.println("Your tires are not ok! Please change it.");
        }

        isCarOn = !isCarOn;
    }

    public void accelerate(int km) {
        if (isCarOn) {
            Engine.moveCar(km, tires);

            if (!isTiresIntegrityOk()) {
                clickPowerButton();

                Radio.playBoom();

            }

            return;
        }

        System.out.println("Please click on the power button");
    }

    public void changeTires() {
        Workshop.changeTires(INTEGRITY_LIMIT, tires);
    }

    private boolean isTiresIntegrityOk() {
        for (Tire tire : tires) {
            if (tire.getIntegrity() < INTEGRITY_LIMIT) {
                return false;
            }
        }

        return true;
    }
}
