/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team5493.robot.subsystems;

import org.usfirst.frc.team5493.robot.PortsButtons;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.livewindow.LiveWindowSendable;

/**
 * The ballIntake subsystem is a simple system with a motor for opening and
 * closing. If using stronger motors, you should probably use a sensor so that
 * the motors don't stall.
 */
public class BallShooter extends Subsystem {
	private SpeedController leftMotor;
	private SpeedController rightMotor;
//	private DigitalInput contact;

	public BallShooter() {
		super();
		leftMotor = PortsButtons.SpeedController(PortsButtons.MC_BALL_SHOOTER_LEFT);
		rightMotor = PortsButtons.SpeedController(PortsButtons.MC_BALL_SHOOTER_RIGHT);
//		contact = new DigitalInput(4);

		// Let's show everything on the LiveWindow
		 LiveWindow.addActuator("Ball Shooter", "Left  Motor", (LiveWindowSendable)
		 leftMotor);
		 LiveWindow.addActuator("Ball Shooter", "Right Motor", (LiveWindowSendable)
		 rightMotor);
		// LiveWindow.addActuator("ballIntake", "Limit Switch", contact);
	}

	public void initDefaultCommand() {
	}

	public void log() {
	}

	/**
	 * Set the ballIntake motor to move in the open direction.
	 */
	public void shoot() {
		leftMotor.set(1);
		rightMotor.set(-1);
	}

	/**
	 * Set the ballIntake motor to move in the close direction.
	 */
	public void close() {
		leftMotor.set(-1);
		rightMotor.set(1);
	}

	/**
	 * Stops the ballIntake motor from moving.
	 */
	public void shotIt() {
		leftMotor.set(0);
		rightMotor.set(0);
	}

	/**
	 * Return true when the robot is grabbing an object hard enough to trigger
	 * the limit switch.
	 */
//	public boolean isShooting() {
////		return contact.get();
//	}
}
