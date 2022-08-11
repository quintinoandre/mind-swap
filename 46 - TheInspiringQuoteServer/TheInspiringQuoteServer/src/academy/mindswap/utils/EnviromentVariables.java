package academy.mindswap.utils;

public class EnviromentVariables {
  private EnviromentVariables() {
  }

  public static final String FILE_PATH = "resources/quotes.txt";
  public static final int SERVER_PORT = 8080;
  public static final String HOST = "localhost"; //or "127.0.0.1"
  public static final String WORD_TO_EXIT_CLIENT_SERVER = "exit";
  public static final int BUFFER_SIZE = 1024;
  public static final int CLIENT_SERVER_TIMEOUT = 10000;
}
