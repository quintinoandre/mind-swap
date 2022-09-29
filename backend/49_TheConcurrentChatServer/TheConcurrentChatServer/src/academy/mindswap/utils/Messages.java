package academy.mindswap.utils;

import static academy.mindswap.server.ChatOption.*;

public final class Messages {
  private Messages() {
  }

  public static final String SERVER_STARTED = "Server is running on port ";
  public static final String SERVER_IS_DEAD = "Hum... seems that the server is dead.";
  public static final String CLOSE_SOCKET = "Closing socket...";
  public static final String CHAT_WELCOME = "Welcome to our chat!";
  public static final String CLIENT = "Client ";
  public static final String CLIENT_ARRIVED = " arrived.";
  public static final String CLIENT_LEFT = " left.";
  public static final String INCORRECT_COMMAND = "Incorrect terminal command!";

  public static final String NON_EXISTENT_CLIENT = "Client not found!";

  public static final String CHAP_OPTIONS = HELP.getName().concat(" - ").concat(HELP.getDescription())
      .concat("\n")
      .concat(WHISPER.getName()).concat(" <client> <message>").concat(" - ").concat(WHISPER.getDescription())
      .concat("\n")
      .concat(LIST.getName()).concat(" - ").concat(LIST.getDescription())
      .concat("\n")
      .concat(SHOUT.getName()).concat(" <message>").concat(" - ").concat(SHOUT.getDescription());
}
