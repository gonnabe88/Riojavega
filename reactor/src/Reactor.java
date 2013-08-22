import java.util.HashMap;
// for IOException
// for ServerSocket

public class Reactor {

	HashMap<String, String> index = new HashMap<String, String>();
	
	public Reactor(String header, String payload) throws Exception{
		
		regesterHandler("0x0001","ConcreteEventHandlerA");
		regesterHandler("0x0002","ConcreteEventHandlerB");
		
		dispatch(header, payload);
	}
	
	public void dispatch(String header, String payload) throws Exception 
	{						
	    Handles handle = new Handles(getHandler(header), payload);
	    
	}
	
	private void regesterHandler(String header, String payload){
		
		index.put(header, payload);
		
	}
	
	private void removeHandler(String header) {
		index.remove(header);
	}
	
	private String getHandler(String header) {
		return index.get(header);
	}
}
