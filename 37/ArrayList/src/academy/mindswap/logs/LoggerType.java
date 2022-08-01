package academy.mindswap.logs;

public enum LoggerType {
    ERROR("error"),
    SUCCESS("success");

    private final String description;

    LoggerType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
