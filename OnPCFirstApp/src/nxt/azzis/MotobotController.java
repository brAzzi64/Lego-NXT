package nxt.azzis;

import lejos.nxt.Motor;

public class MotobotController {
	
	float maxSpeed;
	
	MotobotController() {
		maxSpeed = Motor.A.getMaxSpeed();
	}
	
	public void moveForward(float speed) {
		Motor.A.setSpeed((int)(maxSpeed * speed));
		Motor.C.setSpeed((int)(maxSpeed * speed));
		moveForward();
	}
	
	public void moveForward() {
		Motor.A.backward();
		Motor.C.backward();
	}
	
	public void moveBackwards(float speed) {
		Motor.A.setSpeed((int)(maxSpeed * speed));
		Motor.C.setSpeed((int)(maxSpeed * speed));
		moveBackwards();
	}
	
	public void moveBackwards() {
		Motor.A.forward();
		Motor.C.forward();
	}
	
	public void movementStop() {
		Motor.A.stop();
		Motor.C.stop();
	}
	
	public void steerLeft(float speed) {
		Motor.B.setSpeed((int)(maxSpeed * speed));
		steerLeft();
	}
	
	public void steerLeft() {
		Motor.B.backward();
	}

	public void steerRight(float speed) {
		Motor.B.setSpeed((int)(maxSpeed * speed));
		steerRight();
	}
	
	public void steerRight() {
		
		Motor.B.forward();
	}
	
	public void steeringStop() {
		Motor.B.stop();
	}
}
