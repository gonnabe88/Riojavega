import java.net.*;   // for Socket
import java.io.*;    // for IOException and Input/OutputStream
import java.util.*;  // for ArrayList

class ReceiveProtocol implements Runnable {
  static public final int BUFSIZE = 32;   // Size (in bytes) of I/O buffer

  private Socket clntSock;  // Connection socket
  private Logger logger;    // Logging facility

  public ReceiveProtocol(Socket clntSock, Logger logger) {
    this.clntSock = clntSock;
    this.logger = logger;
  }

  public void run() {
    ArrayList entry = new ArrayList();
    entry.add("Client address and port = " +
      clntSock.getInetAddress().getHostAddress() + ":" +
      clntSock.getPort());
    entry.add("Thread = " + Thread.currentThread().getName());

    try {
      // Get the input and output I/O streams from socket
      InputStream in = clntSock.getInputStream();
      //OutputStream out = clntSock.getOutputStream();

      int recvMsgSize;                        // Size of received message
      int totalBytesEchoed = 0;               // Bytes received from client
      byte[] echoBuffer = new byte[BUFSIZE];  // Receive Buffer
      // Receive until client closes connection, indicated by -1
      while ((recvMsgSize = in.read(echoBuffer)) != -1) {
        totalBytesEchoed += recvMsgSize;
      }
      
      String echoString = new String(echoBuffer);
      String header = echoString.substring(0,6);
      String payload = echoString.substring(6, echoString.length());
      System.out.println(echoString);
      
	try {
		Reactor reactor = new Reactor(header,payload);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	      
      System.out.println("Client said; " + new String(echoBuffer) );
      System.out.println("Client finished; received " + totalBytesEchoed + " bytes.");
    } catch (IOException e) {
    	System.out.println("Exception = " +  e.getMessage());
    }

    try {  // Close socket
      clntSock.close();
    } catch (IOException e) {
    	System.out.println("Exception = " +  e.getMessage());
    }

    logger.writeEntry(entry);
  }
}