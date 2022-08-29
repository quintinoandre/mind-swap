package academy.mindswap.utils.logger;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Class that registers the app logs.
 */
public final class Logger {
    private static Logger logger;

    private Logger() {
    }

    public static Logger singleton() {
        if (logger == null) {
            logger = new Logger();
        }

        return logger;
    }

    public static void log(LoggerType loggerType, String message, boolean printOnTerminal) {
        singleton().writeLog(loggerType, message, printOnTerminal);
    }

    private void writeLog(LoggerType loggerType, String message, boolean printOnTerminal) {
        FileWriter writer = null;
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTime = now.format(formatter);

        try {
            writer = new FileWriter("resources/logs/".concat(loggerType.getDescription()).concat("-logs.log"), true);

            writer.write(formatDateTime.concat(" - ").concat(message.concat("\n")));

            if (printOnTerminal) {
                System.out.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}