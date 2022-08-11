package academy.mindswap.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public final class ReadFromFile {
  private ReadFromFile() {
  }

  public static String readFromFile(String filePath) throws IOException {
    BufferedReader reader = null;

    StringBuilder stringBuilder = new StringBuilder();

    try {
      reader = new BufferedReader(new FileReader(filePath));

      String line;

      while ((line = reader.readLine()) != null) {
        stringBuilder.append(line).append("\n");
      }
    } finally {
      assert reader != null;

      reader.close();
    }

    return stringBuilder.toString();
  }
}