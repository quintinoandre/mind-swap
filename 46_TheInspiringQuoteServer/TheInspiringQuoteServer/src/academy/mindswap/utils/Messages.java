package academy.mindswap.utils;

public final class Messages {
  private Messages() {
  }

  public static final String START_CLIENT_SERVER_MESSAGE = "Enter a message to send to the server: ";
  public static final String START_SERVER_MESSAGE = "Server start on port %d.%nWaiting for packet...%n";
  public static final String MAYBE_SERVER_MESSAGE = "Maybe you wanted to say: \"HIT ME\"";
  public static final String ERROR_TIMEOUT = "Error: Timeout Occurred, packet may have been lost.";

  public static final String SERVER_MESSAGE = "hit me";
}
