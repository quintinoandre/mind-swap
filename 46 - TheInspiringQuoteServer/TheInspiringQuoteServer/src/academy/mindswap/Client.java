package academy.mindswap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.nio.charset.StandardCharsets;

import static academy.mindswap.utils.EnviromentVariables.*;
import static academy.mindswap.utils.Messages.ERROR_TIMEOUT;
import static academy.mindswap.utils.Messages.START_CLIENT_SERVER_MESSAGE;

public class Client {
  public static void main(String[] args) {
    Client udpClient = new Client();

    try {
      udpClient.start();
    } catch (SocketTimeoutException e) {
      System.err.println(ERROR_TIMEOUT);
    } catch (IOException e) {
      System.err.println(e.getMessage());
    } finally {
      if (udpClient.socket != null) {
        udpClient.socket.close();
      }
    }
  }

  private DatagramSocket socket;
  private BufferedReader reader;

  private void start() throws IOException {
    reader = new BufferedReader(new InputStreamReader(System.in));

    communicateWithServer(HOST, SERVER_PORT);
  }

  private void communicateWithServer(String host, int port) throws IOException {
    String message;

    System.out.println(START_CLIENT_SERVER_MESSAGE);

    while (!(message = reader.readLine()).equalsIgnoreCase(WORD_TO_EXIT_CLIENT_SERVER)) {
      sentPacket(message, host, port);

      receivePacket();

      System.out.println(START_CLIENT_SERVER_MESSAGE);
    }
  }

  private void sentPacket(String message, String host, int port) throws IOException {
    socket = new DatagramSocket();

    InetAddress address = InetAddress.getByName(host);

    byte[] bytes = message.getBytes(StandardCharsets.UTF_8);

    DatagramPacket packetSent = new DatagramPacket(bytes, bytes.length, address, port);

    socket.send(packetSent);
  }

  private void receivePacket() throws IOException {
    byte[] receivedBuffer = new byte[BUFFER_SIZE];

    DatagramPacket packetReceived = new DatagramPacket(receivedBuffer, receivedBuffer.length);

    socket.setSoTimeout(CLIENT_SERVER_TIMEOUT);

    socket.receive(packetReceived);

    String messageReceived = new String(packetReceived.getData(), 0, packetReceived.getLength());

    System.out.println(messageReceived);
  }
}
