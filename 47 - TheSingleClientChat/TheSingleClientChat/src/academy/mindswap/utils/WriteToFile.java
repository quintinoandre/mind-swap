package academy.mindswap.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static academy.mindswap.utils.EnvironmentVariables.ORIGIN_FILE_PATH;

public final class WriteToFile {
  private WriteToFile() {
  }

  public static void writeToFile(String filePath, BufferedReader data) throws IOException {
    BufferedWriter writer = null;

    try {
      int numberOfLines = (int) Files.lines(Paths.get(ORIGIN_FILE_PATH)).count();

      writer = new BufferedWriter(new FileWriter(filePath, true));

      for (int i = 0; i < numberOfLines; i++) {
        writer.write(data.readLine().concat("\n"));

        writer.flush();
      }
    } finally {
      assert writer != null;

      writer.close();
    }
  }
}