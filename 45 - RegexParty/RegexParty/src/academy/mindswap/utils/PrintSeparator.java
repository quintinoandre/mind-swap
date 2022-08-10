package academy.mindswap.utils;

import java.util.stream.IntStream;

public final class PrintSeparator {
  private PrintSeparator() {
  }

  public static void printSeparator(String character, int times) {
    StringBuilder stringBuilder = new StringBuilder();

    IntStream.range(0, times).forEach(item -> stringBuilder.append(character));

    System.out.println(stringBuilder);
  }
}