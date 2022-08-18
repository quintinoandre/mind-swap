package academy.mindswap.utils;

import java.util.Random;

public final class GenerateRandomIntegerNumber {
  private GenerateRandomIntegerNumber() {
  }

  public static int generateRandomIntegerNumber(int min, int max) {
    return new Random().nextInt(min, max + 1);
  }
}