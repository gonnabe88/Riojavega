import java.net.Socket;  // for Socket

public class ReceiveProtocolFactory implements ProtocolFactory {
  public Runnable createProtocol(Socket clntSock, Logger logger) {
    return new ReceiveProtocol(clntSock, logger);
  }
}
