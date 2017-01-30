/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team5493.robot.commands;

import org.usfirst.frc.team5493.robot.Robot;
import org.usfirst.frc.team5493.robot.Timings;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Opens the claw for one second. Real robots should use sensors, stalling
 * motors is BAD!
 */
public class SpitBall extends Command {

	public SpitBall() {
		requires(Robot.ballIntake);
		//setTimeout(Timings.SPIT_OUT_SECONDS);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		setTimeout(Timings.SPIT_OUT_SECONDS);
		Robot.ballIntake.open();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.ballIntake.open();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return isTimedOut();
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.ballIntake.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
