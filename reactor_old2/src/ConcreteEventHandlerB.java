
public class ConcreteEventHandlerB implements EventHandler{

	@Override
	public void handle_event(String payload) {
		System.out.println("================================");
		System.out.println("B service is called");		
		System.out.println("The payload is " + payload);
		System.out.println("================================");
	}

	@Override
	public void get_handle() {
		// TODO Auto-generated method stub
		
	}
}
