package nxt.azzis;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.illposed.osc.OSCListener;
import com.illposed.osc.OSCMessage;

import lejos.nxt.Sound;

import nxt.azzis.TimedKeyListener;


public class RobotLogic extends AbstractRobot {

	MotobotController controller = null;
	
	public RobotLogic() {
		controller = new MotobotController();
	}
	
	public void registerAsKeyListener(Component c) {
		KeyListener l = new TimedKeyListener() {
			public void KeyPressed(KeyEvent e) {
				System.out.println("- " + e.getKeyCode());
		  		
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_UP) {
					controller.moveForward();
				} else if (key == KeyEvent.VK_DOWN)	{
					controller.moveBackwards();
				} else if (key == KeyEvent.VK_LEFT)	{
					controller.steerLeft(0.2f);
				} else if (key == KeyEvent.VK_RIGHT) {
					controller.steerRight(0.2f);
				} else if (key == KeyEvent.VK_SPACE) {
					//Sound.beep();
					int rand = (int)(Math.random() * 12);
					double a = Math.pow(2, 1.0f/12.0f); 
					double freq = 440 * Math.pow(a, rand);
					
					System.out.println("rand = " + rand);
					
					Sound.playTone((int)freq, 125);
				}
			}
			public void KeyReleased(KeyEvent e) {
				System.out.println("+ " + e.getKeyCode());
				
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_UP) {
					controller.movementStop();
				} else if (key == KeyEvent.VK_DOWN)	{
					controller.movementStop();
				} else if (key == KeyEvent.VK_LEFT)	{
					controller.steeringStop();
				} else if (key == KeyEvent.VK_RIGHT) {
					controller.steeringStop();
				}
			}
		};
			
		c.addKeyListener(l);
	}

	public void registerAsOSCListener() {
		
		OSCListener listener = new OSCListener() {
			public void acceptMessage(java.util.Date time, OSCMessage message) {
				float x = (float)message.getArguments()[0];
				float xNorm = x / 9.8f;
				
				if (Math.abs(xNorm - 0) > 0.1f) {
					if (xNorm < 0)
						controller.steerRight(Math.abs(xNorm) * 0.2f);
					else if (xNorm > 0)
						controller.steerLeft(Math.abs(xNorm) * 0.2f);
				}
				else
					controller.steeringStop();
				
				float y = (float)message.getArguments()[1];
				float yNorm = y / 9.8f;
				
				if (Math.abs(yNorm - 0) > 0.1f) {
					if (yNorm < 0)
						controller.moveForward(Math.abs(yNorm) * 2 - 0.1f);
					else if (yNorm > 0)
						controller.moveBackwards(Math.abs(yNorm) * 2 - 0.1f);
				}
				else
					controller.movementStop();
				
				System.out.println("Message received: " + xNorm);
			}
		};
		
		LegoOSCListener legoListener = new LegoOSCListener();
		legoListener.init(listener);
	}
	
	@Override
	public void onSense() {
		
		
	}

	@Override
	public void onAct() {
		
		
	}
}
