package academy.mindswap;

public class Shop {
    private String name;
    private int totalBearsCreated = 0;
    private int totalSimpleBearsCreated = 0;
    private int totalCrankyBearsCreated = 0;
    private int totalDrunkBearsCreated = 0;

    public Shop(String name) {
        this.name = name;
    }

    public Bear createABear() {
        totalBearsCreated++;

        if (totalBearsCreated % 2 == 0) {
            totalSimpleBearsCreated++;

            return new SimpleBear();
        }

        if (totalBearsCreated % 5 == 0) {
            totalCrankyBearsCreated++;

            return new CrankyBear();
        }

        totalDrunkBearsCreated++;

        return new DrunkBear();
    }

    public void compareProduction(Shop competingStore) {
        if (competingStore.totalBearsCreated == totalBearsCreated) {
            System.out.println("It was a draw");

            return;
        }

        if (competingStore.totalBearsCreated > totalBearsCreated) {
            printReport(name, competingStore.name, totalBearsCreated, competingStore.totalBearsCreated);

            return;
        }

        printReport(competingStore.name, name, competingStore.totalBearsCreated, totalBearsCreated);
    }

    private void printReport(String loserName, String winnerName, int loserNumberOfCreatedBears,
                             int winnerNumberOfCreatedBears) {
        System.out.printf("The loser shop was %s with %d created bears %n", loserName, loserNumberOfCreatedBears);
        System.out.printf("The winner shop was %s with %d created bears %n", winnerName, winnerNumberOfCreatedBears);
    }

    public void getTypeOfBearsCreated() {
        System.out.printf("Simple Bears: %d %n", totalSimpleBearsCreated);
        System.out.printf("Cranky Bears: %d %n", totalCrankyBearsCreated);
        System.out.printf("Drunk Bears: %d %n", totalDrunkBearsCreated);
    }
}
