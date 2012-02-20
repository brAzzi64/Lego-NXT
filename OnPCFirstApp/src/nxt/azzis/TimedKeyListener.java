package nxt.azzis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.TreeSet;
import javax.swing.Timer;

public class TimedKeyListener implements KeyListener, ActionListener {

	private final TreeSet<Integer> set = new TreeSet<Integer>();
	private final Timer timer;

	private KeyEvent releaseEvent;

	private void fireKeyReleased(KeyEvent e) {
		if (set.remove(new Integer(e.getKeyCode()))) {
			KeyReleased(e);
		}
	}

	public TimedKeyListener() {
		timer = new Timer(5, this);
	}

	public void KeyPressed(KeyEvent e) { }

	public void KeyReleased(KeyEvent e) { }

	public int getPressedCount() {
		return set.size();
	}

	public void keyPressed(KeyEvent e) {
		if (timer.isRunning()) {
			timer.stop();
		} else {
			if (set.add(new Integer(e.getKeyCode()))) {
				KeyPressed(e);
			}
		}
	}

	public void keyReleased(KeyEvent e) {
		if (timer.isRunning()) {
			timer.stop();
			fireKeyReleased(e);
		} else {
			releaseEvent = e;
			timer.restart();
		}
	}

	public void keyTyped(KeyEvent e) { }

	public void actionPerformed(ActionEvent e) {
		timer.stop();
		fireKeyReleased(releaseEvent);
	}
}