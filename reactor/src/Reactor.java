import java.io.InputStream;
import java.util.HashMap;
// for IOException
// for ServerSocket

public class Reactor {

	HashMap<String, String> index = new HashMap<String, String>();
	
	public Reactor(String header, InputStream payload_stream) throws Exception {
		
		//�ڵ鷯������ xml�κ��� �о���� ������ index�� �����Ѵ�(���)
		index = (new Demultiplexer()).select("handler_config"); 
		
		dispatch(header, payload_stream);
	}
	
	public void dispatch(String header, InputStream payload_stream) throws Exception {						
	    Handles handle = new Handles(getHandler(header), payload_stream);
	    
	}
		
	private void removeHandler(String header) {
		index.remove(header);
	}
	
	private String getHandler(String header) {
		return index.get(header);
	}
}
