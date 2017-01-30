package org.usfirst.frc.team5493.robot;

import org.usfirst.frc.team5493.robot.commands.ShootBall;
import org.usfirst.frc.team5493.robot.commands.SpitBall;
import org.usfirst.frc.team5493.robot.commands.SuckBall;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	private Joystick joy = new Joystick(0);

	public Joystick getJoystick() {
		return joy;
	}

	public OI() {
		/*
		 * Joy Button A = 0 
		 * Joy Button B = 1 
		 * Joy Button X = 2 
		 * Joy Button Y = 3
		 * Joy Button LB = 4 
		 * Joy Button RB = 5
		 * 
		 * Joy Axes LX = 0 
		 * Joy Axes LY = 1 
		 * Joy Axes LT = 2 
		 * Joy Axes RT = 3 
		 * Joy Axes RX = 4
		 * Joy Axes RY = 5
		 */

		// Create some buttons
		JoystickButton shooterShoot = new JoystickButton(joy, PortsButtons.JOYBTN_A);
		JoystickButton shooterLoad = new JoystickButton(joy, PortsButtons.JOYBTN_B);
		JoystickButton intakeSuck = new JoystickButton(joy, PortsButtons.JOYBTN_X);
		JoystickButton intakeSpit = new JoystickButton(joy, PortsButtons.JOYBTN_Y);

		SmartDashboard.putData("Intake Ball", new SuckBall());
		SmartDashboard.putData("Spit Out Ball", new SpitBall());
		SmartDashboard.putData("Shoot Ball", new ShootBall());

		shooterShoot.whenPressed(new ShootBall());
		shooterLoad.whenPressed(new SuckBall());

		intakeSuck.whenPressed(new SuckBall());
		intakeSpit.whenPressed(new SpitBall());

	}
}
