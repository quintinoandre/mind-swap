package academy.mindswap;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static academy.mindswap.utils.EnviromentVariables.*;
import static academy.mindswap.utils.GenerateRandomIntegerNumber.generateRandomIntegerNumber;
import static academy.mindswap.utils.Messages.*;
import static academy.mindswap.utils.ReadLineFromFile.readLineFromFile;

public class Server {
  public static void main(String[] args) {
    Server udpServer = new Server();

    try {
      udpServer.start();
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  private DatagramSocket socket;

  private void start() throws IOException {
    socket = new DatagramSocket(SERVER_PORT);

    byte[] receivedBuffer = new byte[BUFFER_SIZE];

    while (socket.isBound()) {
      System.out.printf(START_SERVER_MESSAGE, SERVER_PORT);

      DatagramPacket packetReceived = new DatagramPacket(receivedBuffer, receivedBuffer.length);

      socket.receive(packetReceived);

      String messageReceived = new String(packetReceived.getData(), 0, packetReceived.getLength());

      String response;

      if (messageReceived.toLowerCase().matches("^ *".concat(SERVER_MESSAGE).concat(" *$"))) {
        response = getRandomMessage(FILE_PATH);
      } else {
        response = MAYBE_SERVER_MESSAGE;
      }

      sentPacket(packetReceived, response);
    }
  }

  private String getRandomMessage(String filePath) throws IOException {
    int numberOfLines = (int) Files.lines(Paths.get(filePath)).count();

    String message;

    do {
      message = readLineFromFile(FILE_PATH, generateRandomIntegerNumber(0, numberOfLines));
    } while (message.matches("^$"));

    return message;
  }

  private void sentPacket(DatagramPacket packet, String message) throws IOException {
    InetAddress address = packet.getAddress();

    int clientPort = packet.getPort();

    byte[] bytes = message.getBytes(StandardCharsets.UTF_8);

    DatagramPacket responsePacket = new DatagramPacket(bytes, bytes.length, address, clientPort);

    socket.send(responsePacket);
  }
}
