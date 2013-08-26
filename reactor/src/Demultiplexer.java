import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class Demultiplexer {

	public HashMap<String, String> select(String xmlname) {
		
		HashMap<String, String> index = new HashMap<String, String>();
		Serializer serializer = new Persister();
		
		File source = new File(xmlname);
		
		ParseList list = null;
		try {
			list = serializer.read(ParseList.class, source);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Iterator<ParseVO> iterator = list.getParseList().iterator();
		
		while(iterator.hasNext()) {
			ParseVO parseObj = iterator.next();
			index.put(parseObj.getCode(),parseObj.getClassName());
		}
		
		return index;
	}
	
	
}
