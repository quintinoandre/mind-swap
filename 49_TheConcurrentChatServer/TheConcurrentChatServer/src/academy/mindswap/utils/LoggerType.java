package academy.mindswap.utils;

public enum LoggerType {
  ERROR("error"),
  SUCCESS("success"),

  WARNING("warning");

  private final String description;

  LoggerType(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }
}