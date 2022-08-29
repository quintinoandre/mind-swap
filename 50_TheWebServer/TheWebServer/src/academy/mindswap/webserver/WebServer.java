package academy.mindswap.webserver;

import academy.mindswap.http.MethodType;
import academy.mindswap.http.Routes;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static academy.mindswap.EnvironmentVariables.PORT;
import static academy.mindswap.http.MethodType.*;
import static academy.mindswap.http.Status.*;
import static academy.mindswap.utils.logger.Logger.log;
import static academy.mindswap.utils.logger.LoggerType.ERROR;
import static academy.mindswap.utils.logger.LoggerType.SUCCESS;
import static academy.mindswap.webserver.WebServerMessages.*;

public class WebServer {
    private ServerSocket serverSocket;
    private ExecutorService executorService;

    public static void main(String[] args) {
        int port = PORT;

        if (System.getenv("PORT") != null) {
            port = Integer.parseInt(System.getenv("PORT"));
        }

        new WebServer().start(port);
    }

    private void start(int port) {
        try {
            serverSocket = new ServerSocket(port);

            executorService = Executors.newCachedThreadPool();

            log(SUCCESS, String.format(SERVER_RUNNING, serverSocket.getInetAddress().getHostAddress(), port),
                    true);

            acceptRequest();
        } catch (IOException e) {
            log(ERROR, SERVER_ERROR, true);
        }
    }

    private void acceptRequest() {
        Socket clientSocket;

        try {
            clientSocket = serverSocket.accept();

            executorService.submit(new RequestHandler(clientSocket));
        } catch (IOException e) {
            log(ERROR, CLIENT_CONNECTION_ERROR, true);
        }

        acceptRequest();
    }

    private static class RequestHandler implements Runnable {
        DataOutputStream dataOutputStream;
        BufferedReader bufferedReader;
        Socket clientSocket;

        public RequestHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;

            try {
                dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());

                bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            } catch (IOException e) {
                log(ERROR, e.getMessage(), true);
            }
        }

        @Override
        public void run() {
            handleRequest();
        }

        private void handleRequest() {
            String httpRequest;

            try {
                httpRequest = bufferedReader.readLine();

                log(SUCCESS, httpRequest, true);

                MethodType method = getHttpMethod(httpRequest);

                String resource = getResource(httpRequest);

                response(method, resource);
            } catch (IOException e) {
                log(ERROR, CLIENT_CONNECTION_ERROR, true);
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    log(ERROR, e.getMessage(), true);
                }
            }
        }

        private MethodType getHttpMethod(String httpRequest) {
            return Arrays.stream(values()).filter(method -> method.getDescription().equals(httpRequest.replaceAll(httpRequest.replaceAll("^(" +
                            GET.getDescription() + "|" +
                            POST.getDescription() + "|" +
                            PUT.getDescription() + "|" +
                            PATCH.getDescription() + "|" +
                            DELETE.getDescription() +
                            ")", ""), "")))
                    .findFirst()
                    .orElse(null);
        }

        private String getResource(String httpRequest) {
            return httpRequest.replaceAll("^(" +
                            GET.getDescription() + "|" +
                            POST.getDescription() + "|" +
                            PUT.getDescription() + "|" +
                            PATCH.getDescription() + "|" +
                            DELETE.getDescription() +
                            ") ", "")
                    .replaceAll(" .*", "");
        }

        private String getProtocol(String httpRequest) {
            return httpRequest.replaceAll("^.* ", "");
        }

        private void response(MethodType method, String resource) throws IOException {
            if (method == GET) {
                switch (resource) {
                    case Routes.GET -> status200("www/pages/index.html", dataOutputStream);
                    case Routes.GET_IMAGE -> status200("www/pages/image.html", dataOutputStream);
                    case Routes.GET_AUDIO -> status200("www/pages/audio.html", dataOutputStream);
                    default -> {
                        if (fileExists(resource)) {
                            status200("www".concat(resource), dataOutputStream);

                            return;
                        }

                        status404("www/pages/404.html", dataOutputStream);
                    }
                }
            }

            status405("www/pages/405.html", dataOutputStream);

            dataOutputStream.flush();
        }

        private boolean fileExists(String resource) {
            return Files.exists(Path.of("www".concat(resource)));
        }
    }
}
