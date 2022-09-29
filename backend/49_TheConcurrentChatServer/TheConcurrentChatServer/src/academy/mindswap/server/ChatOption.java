package academy.mindswap.server;

import java.util.Arrays;

public enum ChatOption {
  HELP("\\help", "List all chat options available"),

  WHISPER("\\whisper", "Send a message to a specified client"),
  LIST("\\list", "List all connected clients"),
  SHOUT("\\shout", "Send an uppercase message to all clients");

  private final String name;
  private final String description;

  ChatOption(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public static ChatOption getChatOption(String terminalCommand) {
    if (terminalCommand.toLowerCase().startsWith(WHISPER.getName())) {
      return Arrays.stream(values())
          .filter(chatOption -> terminalCommand.toLowerCase()
              .matches("^" + "\\".concat(chatOption.getName()) + " +(client +)?[0-9]+ +.+$"))
          .findFirst()
          .orElse(null);
    }

    if (terminalCommand.toLowerCase().startsWith(SHOUT.getName())) {
      return Arrays.stream(values())
          .filter(chatOption -> terminalCommand.toLowerCase()
              .matches("^" + "\\".concat(chatOption.getName()) + " +.+$"))
          .findFirst()
          .orElse(null);
    }

    return Arrays.stream(values())
        .filter(chatOption -> terminalCommand.toLowerCase().matches("^" + "\\".concat(chatOption.getName()) + "$"))
        .findFirst()
        .orElse(null);
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }
}
