package academy.mindswap.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public final class WriteToFile {
    private WriteToFile() {
    }

    public static void writeToFile(String filePath, String message) throws IOException {
        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter(filePath, false));

            writer.write(message);

            writer.flush();
        } finally {
            assert writer != null;

            writer.close();
        }
    }
}
