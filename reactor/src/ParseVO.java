

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="handler")
public class ParseVO {

	@Element
	private String code;
	
	@Element(name="class")
	private String className;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
	
	
}
