package nxt.azzis;

import java.awt.*;
import java.awt.event.*;

import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.nxt.NXT;
import lejos.nxt.Sound;

//public class HelloWorld {
//
//	/**
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		System.out.println("Hello World!");
//		//Motor.A.forward();
//
//		
//	}
//
//}

public class HelloWorld extends Frame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4375191520869419340L;
	
	private static HelloWorld hw = null;
	
	TextField t1;
	Label l1;

	public HelloWorld(String s) {
		super(s);
		Panel p = new Panel();
		
		l1 = new Label("Key Listener!");
		p.add(l1);
		add(p);
		addKeyListener(
				new TimedKeyListener() {
			  public void KeyPressed(KeyEvent evt) {
				    System.out.println("- " + evt.getKeyCode());
				    hw.keyPressed(evt);
				  }
				  public void KeyReleased(KeyEvent evt) {
				    System.out.println("+ " + evt.getKeyCode());
				    hw.keyReleased(evt);
				  }
				});
		
		setSize(400, 200);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public void keyPressed(KeyEvent e) {
		l1.setText("Key Pressed");
		
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_UP)
		{
			Motor.A.forward();
			Motor.C.forward();
		} else if (key == KeyEvent.VK_DOWN)	{
			Motor.A.backward();
			Motor.C.backward();
		} else if (key == KeyEvent.VK_SPACE) {
			Sound.beep();
		}
	}

	public void keyReleased(KeyEvent e) {
		l1.setText("Key Released");
		
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_UP)
		{
			Motor.A.stop();
			Motor.C.stop();
		} else if (key == KeyEvent.VK_DOWN)	{
			Motor.A.stop();
			Motor.C.stop();
		}
	}

	public static void main(String[] args) {
		
		Motor.A.stop();
		
		HelloWorld.hw = new HelloWorld("Key Listeneeer Tester");
	}

}
