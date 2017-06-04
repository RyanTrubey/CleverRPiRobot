package org.jointheleague.ecolban.cleverrobot;

/*********************************************************************************************
 * Vic's ultrasonic sensor running with Erik's Clever Robot for Pi
 * version 0.9, 170227
 **********************************************************************************************/
import java.io.IOException;

import org.jointheleague.ecolban.rpirobot.IRobotAdapter;
import org.jointheleague.ecolban.rpirobot.IRobotInterface;
import org.jointheleague.ecolban.rpirobot.SimpleIRobot;

public class CleverRobot extends IRobotAdapter {
	Sonar sonar = new Sonar();
	private boolean tailLight;

	public CleverRobot(IRobotInterface iRobot) {
		super(iRobot);
	}

	public static void main(String[] args) throws Exception {
		System.out.println("Try event listner, rev Monday 2030");
		IRobotInterface base = new SimpleIRobot();
		CleverRobot rob = new CleverRobot(base);
		rob.setup();
		while (rob.loop()) {
		}
		rob.shutDown();

	}

	private void setup() throws Exception {
		driveDirect(100, 100);
	}

	private boolean loop() throws Exception {
		driveDirect(100, 100);
		readSensors(100);
		int[]lightSensor = getLightBumps();
		if(lightSensor[0]>1000){
			driveDirect(100, -100);
			Thread.sleep(500);
			driveDirect(100, 100);
			Thread.sleep(300);
			driveDirect(-100, 100);
			Thread.sleep(200);
		}
		if(lightSensor[1]>1000){
			driveDirect(100, -100);
			Thread.sleep(500);
			driveDirect(100, 100);
			Thread.sleep(300);
			driveDirect(-100, 100);
			Thread.sleep(200);
		}
		if(lightSensor[2]>1000){
			driveDirect(100, -100);
			Thread.sleep(500);
			driveDirect(100, 100);
			Thread.sleep(300);
			driveDirect(-100, 100);
			Thread.sleep(500);
		}
		if(lightSensor[3]>1000){
			driveDirect(-100, 100);
			Thread.sleep(500);
			driveDirect(100, 100);
			Thread.sleep(300);
			driveDirect(100, -100);
			Thread.sleep(200);
		}
		if(lightSensor[4]>1000){
			driveDirect(100, -100);
			Thread.sleep(500);
			driveDirect(100, 100);
			Thread.sleep(300);
			driveDirect(-100, 100);
			Thread.sleep(200);
		}
		if(lightSensor[5]>1000){
			driveDirect(100, -100);
			Thread.sleep(500);
			driveDirect(100, 100);
			Thread.sleep(300);
			driveDirect(-100, 100);
			Thread.sleep(200);
		}
		
		
		
		
		
		/*if(isBumpLeft()){
			driveDirect(-100, -100);
			Thread.sleep(75);
			driveDirect(-100, 100);
			Thread.sleep(100);
			driveDirect(100, 100);
		} else if(isBumpRight()){
			driveDirect(-100, -100);
			Thread.sleep(75);
			driveDirect(100, -100);
			Thread.sleep(100);
			driveDirect(100, 100);
		} else if(isBumpRight() && isBumpLeft()){
			driveDirect(-100, -100);
			Thread.sleep(100);
			driveDirect(100, -100);
			Thread.sleep(100);
			driveDirect(100, 100);
		}
		*/
		
		
		
		System.out.println("LEFT SONAR: " + sonar.readSonar("left"));
		//Thread.sleep(1000);
		//setTailLight(tailLight = !tailLight);
		System.out.println("RIGHT SONAR: " + sonar.readSonar("right"));
		System.out.println("CENTER SONAR: " + sonar.readSonar("center"));

		return true;
	}

	private void shutDown() throws IOException {
		reset();
		stop();
		closeConnection();
	}
}
