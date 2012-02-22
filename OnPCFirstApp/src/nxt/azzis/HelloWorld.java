package nxt.azzis;

import java.awt.*;
import java.awt.event.*;


public class HelloWorld extends Frame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4375191520869419340L;
	
	private Label l1;
	
	private RobotLogic robot;

	
	public HelloWorld(String s) {
		super(s);
		
		Panel p = new Panel();
		l1 = new Label("NXT is Alive!");
		p.add(l1);
		
		add(p);
		
		addKeyListener(
				new TimedKeyListener() {
			  public void KeyPressed(KeyEvent e) {
				  	l1.setText("Key Pressed");
				  	System.out.println("- " + e.getKeyCode());
				  }
				  public void KeyReleased(KeyEvent e) {
					l1.setText("Key Released");
					System.out.println("+ " + e.getKeyCode());
				  }
				});
		
		LegoOSCListener listener = new LegoOSCListener();
		listener.init();
		
		robot = new RobotLogic();
		addKeyListener(robot);
		
		setSize(400, 200);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
				
		new HelloWorld("Key Listeneeer Tester");
	}

}
