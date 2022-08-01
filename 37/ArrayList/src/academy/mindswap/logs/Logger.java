package academy.mindswap.logs;

import java.io.FileWriter;
import java.io.IOException;

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

    public static void log(LoggerType loggerType, String message) {
        singleton().writeLog(loggerType, message);
    }

    private void writeLog(LoggerType loggerType, String message) {
        FileWriter writer = null;

        try {
            writer = new FileWriter("src/academy/mindswap/logs/".concat(loggerType.getDescription()).concat("_logs.log"), true);

            writer.write(message.concat("\n"));
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