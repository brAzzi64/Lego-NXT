package nxt.azzis;

import java.net.SocketException;
import com.illposed.osc.OSCListener;
import com.illposed.osc.OSCPortIn;

public class LegoOSCListener {

	OSCPortIn receiver = null;
	
	public LegoOSCListener() {
		
	}
	
	public Boolean init(OSCListener listener) {
		
		try {
			receiver = new OSCPortIn(8000);
		} catch (SocketException e) {
			e.printStackTrace();
			return false;
		}
		
		receiver.addListener("/accxyz", listener);
		receiver.startListening();
		
		return true;
	}	
}
