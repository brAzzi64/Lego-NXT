package nxt.azzis;

import java.net.SocketException;

import com.illposed.osc.OSCListener;
import com.illposed.osc.OSCPortIn;
import com.illposed.osc.OSCMessage;

public class LegoOSCListener {

	OSCPortIn receiver = null;
	
	public LegoOSCListener() {
		
	}
	
	public Boolean init() {
		
		try {
			receiver = new OSCPortIn(8000);
		} catch (SocketException e) {
			e.printStackTrace();
			return false;
		}
		
		OSCListener listener = new OSCListener() {
			public void acceptMessage(java.util.Date time, OSCMessage message) {
				System.out.println("Message received: " + message.toString());
			}
		};
		
		receiver.addListener("/accxyz", listener);
		receiver.startListening();
		
		return true;
	}	
}
