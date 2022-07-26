package academy.mindswap;

import academy.mindswap.exceptions.*;

import static academy.mindswap.DivisionType.*;

public class Main {
    public static void main(String[] args) {
        Sim sim = new Sim("André");

        try {
            sim.buyHouse();
        } catch (NotMoreThanOneHouseException exception) {
            System.out.println(exception.getMessage());
        }

        try {
            sim.buyHouse();
        } catch (NotMoreThanOneHouseException exception) {
            System.out.println(exception.getMessage());
        }

        try {
            sim.hireHousekeeper("Luís");
        } catch (NotHouseException exception) {
            System.out.println(exception.getMessage());
        } catch (NotGoBathroomException exception) {
            System.out.println(exception.getMessage());
        } catch (NotEnergyException exception) {
            System.out.println(exception.getMessage());
        }


        try {
            sim.watchTv(LIVING_ROOM);
        } catch (NotHouseException exception) {
            System.out.println(exception.getMessage());
        } catch (NotCleanHouseException exception) {
            System.out.println(exception.getMessage());
        } catch (NotGoBathroomException exception) {
            System.out.println(exception.getMessage());
        } catch (NotEnergyException exception) {
            System.out.println(exception.getMessage());
        }

        try {
            sim.work(HOME_OFFICE);
        } catch (NotHouseException exception) {
            System.out.println(exception.getMessage());
        } catch (NotCleanHouseException exception) {
            System.out.println(exception.getMessage());
        } catch (NotGoBathroomException exception) {
            System.out.println(exception.getMessage());
        } catch (NotEnergyException exception) {
            System.out.println(exception.getMessage());
        }

        try {
            sim.work(HOME_OFFICE);
        } catch (NotHouseException exception) {
            System.out.println(exception.getMessage());
        } catch (NotCleanHouseException exception) {
            System.out.println(exception.getMessage());
        } catch (NotGoBathroomException exception) {
            System.out.println(exception.getMessage());
        } catch (NotEnergyException exception) {
            System.out.println(exception.getMessage());
        }

        try {
            sim.work(HOME_OFFICE);
        } catch (NotHouseException exception) {
            System.out.println(exception.getMessage());
        } catch (NotCleanHouseException exception) {
            System.out.println(exception.getMessage());
        } catch (NotGoBathroomException exception) {
            System.out.println(exception.getMessage());
        } catch (NotEnergyException exception) {
            System.out.println(exception.getMessage());
        }

        try {
            sim.sleep(BEDROOM);
        } catch (NotHouseException exception) {
            System.out.println(exception.getMessage());
        } catch (NotCleanHouseException exception) {
            System.out.println(exception.getMessage());
        } catch (NotGoBathroomException exception) {
            System.out.println(exception.getMessage());
        }

        try {
            sim.eat(KITCHEN);
        } catch (NotHouseException exception) {
            System.out.println(exception.getMessage());
        } catch (NotCleanHouseException exception) {
            System.out.println(exception.getMessage());
        } catch (NotGoBathroomException exception) {
            System.out.println(exception.getMessage());
        } catch (NotEnergyException exception) {
            System.out.println(exception.getMessage());
        }

        sim.goToTheBathroom();

        try {
            sim.eat(KITCHEN);
        } catch (NotHouseException exception) {
            System.out.println(exception.getMessage());
        } catch (NotCleanHouseException exception) {
            System.out.println(exception.getMessage());
        } catch (NotGoBathroomException exception) {
            System.out.println(exception.getMessage());
        } catch (NotEnergyException exception) {
            System.out.println(exception.getMessage());
        }

        sim.goToTheBathroom();

        try {
            sim.watchTv(LIVING_ROOM);
        } catch (NotHouseException exception) {
            System.out.println(exception.getMessage());
        } catch (NotCleanHouseException exception) {
            System.out.println(exception.getMessage());
        } catch (NotGoBathroomException exception) {
            System.out.println(exception.getMessage());
        } catch (NotEnergyException exception) {
            System.out.println(exception.getMessage());
        }

        try {
            sim.callHouseKeeper();
        } catch (NotGoBathroomException exception) {
            System.out.println(exception.getMessage());
        } catch (NotEnergyException exception) {
            System.out.println(exception.getMessage());
        } catch (NotHireHousekeeperException exception) {
            System.out.println(exception.getMessage());
        } catch (NotPaidHousekeeperException exception) {
            System.out.println(exception.getMessage());
        }

        try {
            sim.payHousekeeper();
        } catch (NotGoBathroomException exception) {
            System.out.println(exception.getMessage());
        } catch (NotEnergyException exception) {
            System.out.println(exception.getMessage());
        } catch (NotHireHousekeeperException exception) {
            System.out.println(exception.getMessage());
        }

        try {
            sim.callHouseKeeper();
        } catch (NotGoBathroomException exception) {
            System.out.println(exception.getMessage());
        } catch (NotEnergyException exception) {
            System.out.println(exception.getMessage());
        } catch (NotHireHousekeeperException exception) {
            System.out.println(exception.getMessage());
        } catch (NotPaidHousekeeperException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
