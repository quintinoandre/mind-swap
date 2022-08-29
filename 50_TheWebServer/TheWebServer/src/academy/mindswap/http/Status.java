package academy.mindswap.http;

import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static academy.mindswap.utils.logger.Logger.log;
import static academy.mindswap.utils.logger.LoggerType.ERROR;

public final class Status {
    private Status() {
    }

    public static void status200(String httpFilePath, DataOutputStream dataOutputStream) {
        try {
            File file = new File(httpFilePath);

            byte[] bytes = Files.readAllBytes(Path.of(file.getPath()));

            String header = "HTTP/1.1 200 Document Follows\r\n"
                    .concat(extractContentType(file))
                    .concat("Server: mindswap\r\n")
                    .concat("Content-Length: " + file.length() + "\r\n\r\n");

            dataOutputStream.writeBytes(header);

            dataOutputStream.write(bytes);
        } catch (IOException e) {
            log(ERROR, e.getMessage(), true);
        }
    }

    public static void status404(String httpFilePath, DataOutputStream dataOutputStream) {
        try {
            File file = new File(httpFilePath);

            byte[] bytes = Files.readAllBytes(Path.of(file.getPath()));

            String header = "HTTP/1.1 404 Not Found\r\n"
                    .concat(extractContentType(file))
                    .concat("Server: mindswap\r\n")
                    .concat("Content-Length: " + file.length() + "\r\n\r\n");

            dataOutputStream.writeBytes(header);

            dataOutputStream.write(bytes);
        } catch (IOException e) {
            log(ERROR, e.getMessage(), true);
        }
    }

    public static void status405(String httpFilePath, DataOutputStream dataOutputStream) {
        try {
            File file = new File(httpFilePath);

            byte[] bytes = Files.readAllBytes(Path.of(file.getPath()));

            String header = "HTTP/1.1 405 Method Not Allowed\r\n"
                    .concat(extractContentType(file))
                    .concat("Server: mindswap\r\n")
                    .concat("Content-Length: " + file.length() + "\r\n\r\n");

            dataOutputStream.writeBytes(header);

            dataOutputStream.write(bytes);
        } catch (IOException e) {
            log(ERROR, e.getMessage(), true);
        }
    }

    private static String extractContentType(File file) {
        String contentType = null;

        try {
            contentType = Files.probeContentType(Path.of(file.getPath()));
        } catch (IOException e) {
            log(ERROR, e.getMessage(), true);
        }

        assert contentType != null;

        return "Content-Type: ".concat(contentType).concat("; charset=UTF-8\r\n");
    }
}
