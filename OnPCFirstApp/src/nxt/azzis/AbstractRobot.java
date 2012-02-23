package nxt.azzis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;


public abstract class AbstractRobot implements ActionListener {

	@SuppressWarnings("unused")
	private final Timer timer;
	
	public AbstractRobot() {
		timer = new Timer((int)(1000 / 30.0f), this);
	}
	
	public abstract void onSense();
	
	public abstract void onAct();

	@Override
	public void actionPerformed(ActionEvent e) {
		onSense();
		onAct();
	}
}
