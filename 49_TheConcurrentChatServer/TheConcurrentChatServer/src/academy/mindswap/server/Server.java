package academy.mindswap.server;

import academy.mindswap.utils.Logger;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static academy.mindswap.EnvironmentVariables.PORT;
import static academy.mindswap.server.ChatOption.*;
import static academy.mindswap.utils.LoggerType.*;
import static academy.mindswap.utils.Messages.*;

public class Server {
  private int clientsCounter;
  private ServerSocket serverSocket;
  private List<ClientHandler> clientHandlerList;

  public static void main(String[] args) {
    Server server = new Server();

    server.start();
  }

  private void start() {
    try {
      serverSocket = new ServerSocket(PORT);

      Logger.log(SUCCESS, SERVER_STARTED + PORT + ".", true);

      clientHandlerList = new CopyOnWriteArrayList<>();

      acceptClient();
    } catch (IOException e) {
      e.printStackTrace();

      System.exit(1);
    }
  }

  private void acceptClient() {
    Socket clientSocket = null;

    try {
      clientSocket = serverSocket.accept();

      String threadName = CLIENT + (++clientsCounter);

      ClientHandler clientHandler = new ClientHandler(clientSocket, threadName);

      clientHandlerList.add(clientHandler);

      new Thread(clientHandler, threadName).start();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      acceptClient();
    }
  }

  private void broadCast(String message) {
    for (int i = 0; i < clientHandlerList.size(); i++) {
      if (!clientHandlerList.get(i).threadName.equals(getCurrentThreadName())) {
        try {
          clientHandlerList.get(i)
              .sendMessageToClient(getCurrentThreadName().concat(": ").concat(message));
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  private int getClientHandlerIndex(String string) {
    if (string.startsWith("\\")) {
      for (ClientHandler clientHandler : clientHandlerList) {
        if (clientHandler.threadName.equals(CLIENT.concat(string.toLowerCase()
            .replaceFirst("[^ ]+ ", "")
            .replaceFirst("client ", "")
            .replaceAll(" .*", "")))) {
          return clientHandlerList.indexOf(clientHandler);
        }
      }
    } else {
      for (ClientHandler clientHandler : clientHandlerList) {
        if (clientHandler.threadName.equals(getCurrentThreadName())) {
          return clientHandlerList.indexOf(clientHandler);
        }
      }
    }

    return -1;
  }

  private String getCurrentThreadName() {
    return Thread.currentThread().getName();
  }

  private class ClientHandler implements Runnable {
    private final Socket clientSocket;
    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;
    private String threadName;

    public ClientHandler(Socket socket, String threadName) {
      clientSocket = socket;
      this.threadName = threadName;
    }

    private void startBuffers() throws IOException {
      bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

      bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    private void handleClient() {
      readMessageFromClient();

      handleClient();
    }

    private void sendMessageToClient(String message) throws IOException {
      bufferedWriter.write(message);

      bufferedWriter.newLine();

      bufferedWriter.flush();
    }

    private void removeClient() {
      Logger.log(WARNING, getCurrentThreadName().concat(CLIENT_LEFT), true);

      clientHandlerList.remove(getClientHandlerIndex(getCurrentThreadName()));

      Thread.currentThread().stop();
    }

    private void handleChatOption(ChatOption chatOption, String clientMessage) throws IOException {
      switch (chatOption) {
        case HELP -> {
          Logger.log(SUCCESS, HELP.getName().concat(" (").concat(getCurrentThreadName()).concat(")"),
              false);

          sendMessageToClient(CHAP_OPTIONS);
        }
        case WHISPER -> {
          Logger.log(SUCCESS, WHISPER.getName().concat(" (").concat(getCurrentThreadName()).concat(")"),
              false);

          int clientHandlerIndex = getClientHandlerIndex(clientMessage);

          if (clientHandlerIndex == -1) {
            Logger.log(ERROR, NON_EXISTENT_CLIENT.concat(" (").concat(getCurrentThreadName()).concat(")"),
                false);

            sendMessageToClient(NON_EXISTENT_CLIENT);

            return;
          }

          clientHandlerList.get(clientHandlerIndex)
              .sendMessageToClient(getCurrentThreadName()
                  .concat(" (whisper): ")
                  .concat(clientMessage.replaceAll("^.*\\d+ +", "")));
        }
        case LIST -> clientHandlerList.forEach(clientHandler -> {
          try {
            Logger.log(SUCCESS, LIST.getName().concat(" (").concat(getCurrentThreadName()).concat(")"),
                false);

            sendMessageToClient(clientHandler.threadName);
          } catch (IOException e) {
            e.printStackTrace();
          }
        });
        case SHOUT -> {
          Logger.log(SUCCESS, SHOUT.getName().concat(" (").concat(getCurrentThreadName()).concat(")"),
              false);

          broadCast(clientMessage
              .replaceAll("\\".concat(chatOption.getName()) + " +", "")
              .toUpperCase());
        }
      }
    }

    private void readMessageFromClient() {
      try {
        if (clientSocket.isClosed()) {
          removeClient();

          return;
        }

        String clientMessage = bufferedReader.readLine();

        if (clientMessage == null) {
          clientSocket.close();

          return;
        }

        ChatOption chatOption = getChatOption(clientMessage);

        if (chatOption == null && clientMessage.startsWith("\\")) {
          Logger.log(ERROR, INCORRECT_COMMAND.concat(" (").concat(getCurrentThreadName()).concat(")"),
              false);

          sendMessageToClient(INCORRECT_COMMAND);

          return;
        }

        if (chatOption == null) {
          broadCast(clientMessage);

          return;
        }

        handleChatOption(chatOption, clientMessage);

      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    private void greetClient() throws IOException {
      Logger.log(SUCCESS, CHAT_WELCOME.concat(" (").concat(getCurrentThreadName()).concat(")"),
          false);

      sendMessageToClient(CHAT_WELCOME);
    }

    @Override
    public void run() {
      try {
        startBuffers();

        greetClient();

        Logger.log(SUCCESS, getCurrentThreadName().concat(CLIENT_ARRIVED), true);

        handleClient();
      } catch (IOException e) {
        try {
          clientSocket.close();
        } catch (IOException ex) {
          ex.printStackTrace();
        }
      }
    }
  }
}
