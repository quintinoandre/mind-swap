package academy.mindswap.client;

import academy.mindswap.utils.Logger;

import java.io.*;
import java.net.Socket;

import static academy.mindswap.EnvironmentVariables.HOST;
import static academy.mindswap.EnvironmentVariables.PORT;
import static academy.mindswap.utils.LoggerType.ERROR;
import static academy.mindswap.utils.LoggerType.WARNING;
import static academy.mindswap.utils.Messages.CLOSE_SOCKET;
import static academy.mindswap.utils.Messages.SERVER_IS_DEAD;

public class Client {
  Socket clientSocket;
  BufferedWriter clientBufferedWriter;
  BufferedReader terminalBufferedReader;

  public static void main(String[] args) {
    Client client = new Client();

    client.startTerminalReader();

    client.handleServer();
  }

  private void startTerminalReader() {
    terminalBufferedReader = new BufferedReader(new InputStreamReader(System.in));
  }

  private void handleServer() {
    connectToServer();

    startListenToServer();

    communicateWithServer();

    closeClientSocket();
  }

  private void connectToServer() {
    try {
      clientSocket = new Socket(HOST, PORT);

      clientBufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
    } catch (IOException e) {
      Logger.log(ERROR, SERVER_IS_DEAD, true);

      connectToServer();
    }
  }

  private String readFromTerminal() {
    String message = null;
    try {
      message = terminalBufferedReader.readLine();
    } catch (IOException e) {
      e.printStackTrace();

      System.exit(1);
    }

    return message;
  }


  private void sendMessages() throws IOException {
    String message = readFromTerminal();

    clientBufferedWriter.write(message);

    clientBufferedWriter.newLine();

    clientBufferedWriter.flush();
  }

  private void communicateWithServer() {
    try {
      sendMessages();

      communicateWithServer();
    } catch (IOException e) {
      System.out.println(SERVER_IS_DEAD);

      handleServer();
    }
  }

  private void closeClientSocket() {
    try {
      Logger.log(WARNING, CLOSE_SOCKET, true);

      clientSocket.close();
    } catch (IOException e) {
      e.printStackTrace();

      System.exit(1);
    }
  }

  private void startListenToServer() {
    try {
      new Thread(new ServerListener(clientSocket.getInputStream())).start();
    } catch (IOException e) {
      handleServer();
    }
  }

  private static class ServerListener implements Runnable {
    BufferedReader serverBufferedReader;

    public ServerListener(InputStream inputStream) {
      serverBufferedReader = new BufferedReader(new InputStreamReader(inputStream));
    }

    @Override
    public void run() {
      try {
        readServerMessage();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    private void readServerMessage() throws IOException {
      String readMessageFromServer = serverBufferedReader.readLine();

      System.out.println(readMessageFromServer);

      readServerMessage();
    }
  }
}
