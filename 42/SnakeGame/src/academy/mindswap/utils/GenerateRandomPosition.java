package academy.mindswap.utils;

import java.util.Random;

public final class GenerateRandomPosition {
    private GenerateRandomPosition() {
    }

    public static int generateRandomPosition(int min, int max) {
        Random random = new Random();

        return random.nextInt(min + 1, max);
    }
}
