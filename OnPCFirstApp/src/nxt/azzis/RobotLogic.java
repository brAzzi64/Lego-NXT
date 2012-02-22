package nxt.azzis;

import java.awt.event.KeyEvent;

import lejos.nxt.Motor;
import lejos.nxt.Sound;

import nxt.azzis.TimedKeyListener;


public class RobotLogic extends TimedKeyListener {

	public RobotLogic() {
	
//		Motor.A.stop();
//		Motor.A.rotateTo(0);
//		Motor.B.setSpeed(300);
	}
	
	public void KeyPressed(KeyEvent e) {
		
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_UP)
		{
			Motor.A.backward();
			Motor.C.backward();
		} else if (key == KeyEvent.VK_DOWN)	{
			Motor.A.forward();
			Motor.C.forward();
		} else if (key == KeyEvent.VK_LEFT)	{
			Motor.B.rotateTo(-45, true);
		} else if (key == KeyEvent.VK_RIGHT) {
			Motor.B.rotateTo(45, true);
		} else if (key == KeyEvent.VK_SPACE) {
			Sound.beep();
		}
	}

	public void KeyReleased(KeyEvent e) {
		
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_UP)
		{
			Motor.A.stop();
			Motor.C.stop();
		} else if (key == KeyEvent.VK_DOWN)	{
			Motor.A.stop();
			Motor.C.stop();
		} else if (key == KeyEvent.VK_LEFT)	{
			Motor.B.rotateTo(0, true);
		} else if (key == KeyEvent.VK_RIGHT) {
			Motor.B.rotateTo(0, true);
		}
	}
}
