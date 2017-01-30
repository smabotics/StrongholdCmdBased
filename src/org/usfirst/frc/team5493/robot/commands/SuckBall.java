/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team5493.robot.commands;

import org.usfirst.frc.team5493.robot.Robot;
import org.usfirst.frc.team5493.robot.Timings;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Closes the ballIntake for one second. Real robots should use sensors,
 * stalling motors is BAD!
 */
public class SuckBall extends Command {

	public SuckBall() {
		requires(Robot.ballIntake);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.ballIntake.close();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		setTimeout(Timings.SUCK_IN_SECONDS);
		Robot.ballIntake.close();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return isTimedOut();
	}

	// Called once after isFinished returns true
	protected void end() {

		if (!Robot.isSimulation())
			Robot.ballIntake.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
