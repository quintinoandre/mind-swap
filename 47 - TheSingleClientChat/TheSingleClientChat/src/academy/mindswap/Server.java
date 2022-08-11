package academy.mindswap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import static academy.mindswap.utils.EnvironmentVariables.COPY_FILE_PATH;
import static academy.mindswap.utils.EnvironmentVariables.SERVER_PORT;
import static academy.mindswap.utils.Messages.SERVER_RESPONSE_MESSAGE;
import static academy.mindswap.utils.Messages.START_SERVER_MESSAGE;
import static academy.mindswap.utils.WriteToFile.writeToFile;

public class Server {
  public static void main(String[] args) {
    Server udpServer = new Server();

    try {
      udpServer.start();
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  private ServerSocket serverSocket;
  private BufferedReader in;
  private PrintWriter out;

  private void start() throws IOException {
    serverSocket = new ServerSocket(SERVER_PORT);

    while (serverSocket.isBound()) {
      System.out.printf(START_SERVER_MESSAGE, SERVER_PORT);

      Socket clientSocket = serverSocket.accept();

      in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

      writeToFile(COPY_FILE_PATH, in);

      sentMessage(clientSocket, SERVER_RESPONSE_MESSAGE);
    }
  }

  private void sentMessage(Socket clientSocket, String message) throws IOException {
    out = new PrintWriter(clientSocket.getOutputStream(), true);

    out.println(message);

    out.flush();
  }
}
