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
		
		robot = new RobotLogic();
		robot.registerAsKeyListener(this);
		robot.registerAsOSCListener();
		
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
