package academy.mindswap;

import static academy.mindswap.Message.FIX_PINOCCHIO;

public class Pinocchio {
    private int noseSize = 0;
    private boolean isHeadExploded = false;
    private boolean canBecomeRealBoy = true;

    private boolean isRealBoy = false;
    private int goodDeedsDone = 0;

    public void lie() {
        if (isHeadExploded) {
            System.out.println(FIX_PINOCCHIO);

            return;
        }

        if (!isRealBoy) {
            noseSize++;
        }

        if (noseSize >= 100) {
            isHeadExploded = true;

            canBecomeRealBoy = false;
        }

        goodDeedsDone = 0;

        printReport();
    }

    public void fixes() {
        isHeadExploded = false;

        noseSize = 0;

        printReport();
    }

    public void makeGoodDeed() {
        if (isHeadExploded) {
            System.out.println(FIX_PINOCCHIO);

            return;
        }

        if (!isRealBoy && noseSize > 0) {
            noseSize--;
        }

        goodDeedsDone++;

        if (goodDeedsDone >= 2 && noseSize <= 1 && canBecomeRealBoy) {
            isRealBoy = true;
        }

        printReport();
    }

    private void printReport() {
        String convertIsHeadExploded = isHeadExploded ? "yes" : "no";
        String convertCanBecomeRealBoy = canBecomeRealBoy ? "yes" : "no";
        String convertIsRealBoy = isRealBoy ? "yes" : "no";

        System.out.printf("%nNose size: %d%n", noseSize);
        System.out.printf("Is head exploded? %s%n", convertIsHeadExploded);
        System.out.printf("Can become a real boy? %s%n", convertCanBecomeRealBoy);
        System.out.printf("Is a real boy? %s%n", convertIsRealBoy);
        System.out.printf("Good deeds done: %d%n%n", goodDeedsDone);
    }
}
