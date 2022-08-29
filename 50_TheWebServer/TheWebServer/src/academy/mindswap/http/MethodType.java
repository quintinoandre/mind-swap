package academy.mindswap.http;

public enum MethodType {
    GET("GET"),
    POST("POST"),
    PUT("PUT"),
    PATCH("PATCH"),
    DELETE("DELETE");

    private final String description;

    MethodType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
