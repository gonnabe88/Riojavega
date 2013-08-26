import java.io.InputStream;


public interface EventHandler {
	public boolean handle_event(InputStream payload_stream);
	public boolean get_handle();
}
