import java.io.InputStream;
import java.util.HashMap;
// for IOException
// for ServerSocket

public class Reactor {

	HashMap<String, String> index = new HashMap<String, String>();
	
	public Reactor(String header, InputStream payload_stream) throws Exception {
		
		//핸들러설정을 xml로부터 읽어들인 다음에 index에 저장한다(등록)
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
