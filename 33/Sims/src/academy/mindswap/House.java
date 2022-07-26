package academy.mindswap;

import static academy.mindswap.utils.Messages.HOUSE_CLEANLINESS_LEVEL;

public class House {
    private int cleanlinessLevel;
    private final int MIN_CLEANLINESS_LEVEL = 20;

    public House() {
        cleanlinessLevel = 100;
    }

    void decreaseCleanlinessLevel(int dirtinessQuantity) {
        if (cleanlinessLevel - dirtinessQuantity < 0) {
            cleanlinessLevel = 0;

            System.out.printf(HOUSE_CLEANLINESS_LEVEL, cleanlinessLevel);

            return;
        }

        cleanlinessLevel -= dirtinessQuantity;

        System.out.printf(HOUSE_CLEANLINESS_LEVEL, cleanlinessLevel);
    }

    void increaseCleanlinessLevel(int cleanlinessQuantity) {
        if (cleanlinessLevel + cleanlinessQuantity > 100) {
            cleanlinessLevel = 100;

            System.out.printf(HOUSE_CLEANLINESS_LEVEL, cleanlinessLevel);

            return;
        }

        cleanlinessLevel += cleanlinessQuantity;

        System.out.printf(HOUSE_CLEANLINESS_LEVEL, cleanlinessLevel);
    }

    boolean isHouseClean() {
        return cleanlinessLevel >= MIN_CLEANLINESS_LEVEL;
    }

    void cleanHouse() {
        cleanlinessLevel = 100;

        System.out.printf(HOUSE_CLEANLINESS_LEVEL, cleanlinessLevel);
    }
}
