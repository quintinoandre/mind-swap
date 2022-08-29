package academy.mindswap.webserver;

public final class WebServerMessages {
    private WebServerMessages() {
    }

    public static final String SERVER_RUNNING = "Server running on host: %s and port: %d";
    public static final String SERVER_ERROR = "Server couldn't start";
    public static final String CLIENT_CONNECTION_ERROR = "Couldn't establish connection with client";
}
