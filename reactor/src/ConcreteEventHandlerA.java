import java.io.IOException;
import java.io.InputStream;


public class ConcreteEventHandlerA implements EventHandler{
	static public final int BUFSIZE = 4096;   // Size (in bytes) of I/O buffer

	public ConcreteEventHandlerA(){	}
	@Override
	public boolean handle_event(InputStream payload_stream) {
		
	      StringBuffer payload = new StringBuffer();
	      byte[] byte_payload = new byte[BUFSIZE];
	      try {
			for (int n; (n = payload_stream.read(byte_payload)) != -1;) {
				  payload.append(new String(byte_payload, 0, n));
			  }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      payload.toString();
	      	
		System.out.println("================================");
		System.out.println("A service is called");		
		System.out.println("The payload is " + payload.toString());
		System.out.println("================================");
		
		return true;
	}

	@Override
	public boolean get_handle() {
		// TODO Auto-generated method stub
		return true;
	}
}
