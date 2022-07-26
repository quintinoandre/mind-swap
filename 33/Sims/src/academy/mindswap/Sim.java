package academy.mindswap;

import academy.mindswap.exceptions.*;

import static academy.mindswap.utils.Messages.*;

public class Sim {
    private final String name;
    private House house;
    private Housekeeper housekeeper;

    private boolean needToGoToTheBathroom;
    private int energyLevel;

    public Sim(String name) {
        this.name = name;
        energyLevel = 100;
    }

    public void buyHouse() throws NotMoreThanOneHouseException {
        if (hasHouse()) {
            throw new NotMoreThanOneHouseException();
        }

        house = new House();
    }

    public void hireHousekeeper(String name) throws NotHouseException, NotGoBathroomException, NotEnergyException {
        if (!hasHouse()) {
            throw new NotHouseException();
        }

        if (needToGoToTheBathroom) {
            throw new NotGoBathroomException();
        }

        if (!hasEnergy()) {
            throw new NotEnergyException();
        }

        housekeeper = new Housekeeper(name);
    }

    public void payHousekeeper() throws NotGoBathroomException, NotEnergyException, NotHireHousekeeperException {
        if (needToGoToTheBathroom) {
            throw new NotGoBathroomException();
        }

        if (!hasEnergy()) {
            throw new NotEnergyException();
        }

        if (!hasHousekeeper()) {
            throw new NotHireHousekeeperException();
        }

        housekeeper.setWasPaid();
    }

    public void callHouseKeeper() throws NotGoBathroomException, NotEnergyException,
            NotHireHousekeeperException, NotPaidHousekeeperException {
        if (needToGoToTheBathroom) {
            throw new NotGoBathroomException();
        }

        if (!hasEnergy()) {
            throw new NotEnergyException();
        }

        if (!hasHousekeeper()) {
            throw new NotHireHousekeeperException();
        }

        if (!housekeeper.wasPaid()) {
            throw new NotPaidHousekeeperException();
        }

        house.cleanHouse();
    }

    public void eat(DivisionType divisionType) throws NotHouseException, NotCleanHouseException,
            NotGoBathroomException, NotEnergyException {
        if (!hasHouse()) {
            throw new NotHouseException();
        }

        if (!isHouseClean()) {
            throw new NotCleanHouseException();
        }

        if (needToGoToTheBathroom) {
            throw new NotGoBathroomException();
        }

        if (!hasEnergy()) {
            throw new NotEnergyException();
        }

        System.out.printf(EATING, divisionType.toString());

        house.decreaseCleanlinessLevel(divisionType.getDirtinessLevel());

        increaseEnergyLevel(20);

        needToGoToTheBathroom = true;
    }

    public void sleep(DivisionType divisionType) throws NotHouseException, NotCleanHouseException,
            NotGoBathroomException {
        if (!hasHouse()) {
            throw new NotHouseException();
        }

        if (!isHouseClean()) {
            throw new NotCleanHouseException();
        }

        if (needToGoToTheBathroom) {
            throw new NotGoBathroomException();
        }

        System.out.printf(SLEEPING, divisionType.toString());

        house.decreaseCleanlinessLevel(divisionType.getDirtinessLevel());

        increaseEnergyLevel(100);
    }

    public void watchTv(DivisionType divisionType) throws NotHouseException, NotCleanHouseException,
            NotGoBathroomException, NotEnergyException {
        if (!hasHouse()) {
            throw new NotHouseException();
        }

        if (!isHouseClean()) {
            throw new NotCleanHouseException();
        }

        if (needToGoToTheBathroom) {
            throw new NotGoBathroomException();
        }

        if (!hasEnergy()) {
            throw new NotEnergyException();
        }

        System.out.printf(WATCHING_TV, divisionType.toString());

        house.decreaseCleanlinessLevel(divisionType.getDirtinessLevel());

        decreaseEnergyLevel(10);
    }

    public void work(DivisionType divisionType) throws NotHouseException, NotCleanHouseException,
            NotGoBathroomException, NotEnergyException {
        if (!hasHouse()) {
            throw new NotHouseException();
        }

        if (!isHouseClean()) {
            throw new NotCleanHouseException();
        }

        if (needToGoToTheBathroom) {
            throw new NotGoBathroomException();
        }

        if (!hasEnergy()) {
            throw new NotEnergyException();
        }

        System.out.printf(WORKING, divisionType.toString());

        house.decreaseCleanlinessLevel(divisionType.getDirtinessLevel());

        decreaseEnergyLevel(50);
    }

    public void goToTheBathroom() {
        needToGoToTheBathroom = false;
    }

    public void increaseEnergyLevel(int quantityOfEnergy) {
        if (energyLevel + quantityOfEnergy > 100) {
            energyLevel = 100;

            System.out.printf(ENERGY_LEVEL, energyLevel);

            return;
        }

        energyLevel += quantityOfEnergy;

        System.out.printf(ENERGY_LEVEL, energyLevel);
    }

    public void decreaseEnergyLevel(int quantityOfEnergy) {
        if (energyLevel - quantityOfEnergy < 0) {
            energyLevel = 0;

            System.out.printf(ENERGY_LEVEL, energyLevel);

            return;
        }

        energyLevel -= quantityOfEnergy;

        System.out.printf(ENERGY_LEVEL, energyLevel);
    }

    private boolean hasEnergy() {
        return energyLevel > 0;
    }

    private boolean hasHouse() {
        return house != null;
    }

    private boolean hasHousekeeper() {
        return housekeeper != null;
    }

    private boolean isHouseClean() {
        return house.isHouseClean();
    }
}
