package academy.mindswap.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

public final class ReadLineFromFile {
  private ReadLineFromFile() {
  }

  public static String readLineFromFile(String filePath, int line) {
    try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
      Optional<String> optional = lines.skip(line).findFirst();

      return optional.orElse("");
    } catch (IOException e) {
      System.out.println(e.getMessage());

      return null;
    }
  }
}