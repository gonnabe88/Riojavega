import java.io.InputStream;


public class Handles {

	public Handles(String handler, InputStream payload_stream) throws Exception {
		
		EventHandler eventhandler = (EventHandler)Class.forName(handler).newInstance();
		if(eventhandler.handle_event(payload_stream))
			System.out.println("Success to load EventHandler");
		else
			System.out.println("Fail to load EventHandler");
		
	}

}
