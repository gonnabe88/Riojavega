
public class Handles {

	public Handles(String handler, String payload) throws Exception {
		
		EventHandler eventhandler = (EventHandler)Class.forName(handler).newInstance();
		eventhandler.handle_event(payload);
		
	}

}
