package academy.mindswap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static academy.mindswap.utils.EnvironmentVariables.*;
import static academy.mindswap.utils.Messages.START_CLIENT_SERVER_MESSAGE;
import static academy.mindswap.utils.Messages.YES;
import static academy.mindswap.utils.ReadFromFile.readFromFile;

public class Client {
  public static void main(String[] args) {
    Client tcpClient = new Client();

    try {
      tcpClient.start();
    } catch (IOException e) {
      System.err.println(e.getMessage());
    } finally {
      if (tcpClient.socket != null) {
        try {
          tcpClient.socket.close();
        } catch (IOException e) {
          System.err.println(e.getMessage());
        }
      }
    }
  }

  private Socket socket;
  private PrintWriter out;
  private BufferedReader systemIn;
  private BufferedReader in;

  private void start() throws IOException {
    systemIn = new BufferedReader(new InputStreamReader(System.in));

    communicateWithServer(HOST, SERVER_PORT);
  }

  private void communicateWithServer(String host, int port) throws IOException {
    System.out.println(START_CLIENT_SERVER_MESSAGE);

    if (systemIn.readLine().equalsIgnoreCase(YES)) {
      sentMessage(readFromFile(ORIGIN_FILE_PATH), host, port);
    } else {
      return;
    }

    receiveMessage();
  }

  private void sentMessage(String message, String host, int port) throws IOException {
    socket = new Socket(host, port);

    out = new PrintWriter(socket.getOutputStream(), true);

    out.println(message);

    out.flush();
  }

  private void receiveMessage() throws IOException {
    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

    System.out.println(in.readLine());
  }
}
