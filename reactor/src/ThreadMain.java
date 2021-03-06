import java.io.FileReader;   // for IOException
import java.net.ServerSocket;  // for ServerSocket
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class ThreadMain {

  public static void main(String[] args) throws Exception {
	  
	    HashMap<String, String> index = new HashMap<String, String>();
	    index = (new Demultiplexer()).select("thread_config"); 
	    
	    JSONParser parser = new JSONParser();
	  	//Read the configuration file, input.json
		Object obj = parser.parse(new FileReader("server_config.json"));
		JSONObject jsonObject = (JSONObject) obj;
		//Get the algorism type
		int servPort = Integer.parseInt((String)jsonObject.get("port"));
		String type = (String)jsonObject.get("thread_type");
		//Get the string lists
	    String[] transed_header = (index.get(type)).split(":");
	    String protocolName = transed_header[0];             // Protocol name
	    String dispatcherName = transed_header[1];           // Dispatcher name
	    ServerSocket servSock = new ServerSocket(servPort);
	    Logger logger = new ConsoleLogger();       // Log messages to console	    
	    
	    ProtocolFactory protoFactory = (ProtocolFactory)  // Get protocol factory
	      Class.forName(protocolName).newInstance();
	    Dispatcher dispatcher = (Dispatcher)       // Get dispatcher
	      Class.forName(dispatcherName).newInstance();

	    dispatcher.startDispatching(servSock, logger, protoFactory);
	    /* NOT REACHED */
    
  }
}
