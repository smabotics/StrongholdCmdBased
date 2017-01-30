package org.usfirst.frc.team5493.robot.subsystems;

import org.usfirst.frc.team5493.robot.PortsButtons;
import org.usfirst.frc.team5493.robot.commands.TankDriveWithJoystick;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.livewindow.LiveWindowSendable;

/**
 * The DriveTrain subsystem incorporates the sensors and actuators attached to
 * the robots chassis. These include four drive motors, a left and right encoder
 * and a gyro.
 */
public class DriveTrain extends Subsystem {
	private SpeedController left_motor, right_motor;
	private RobotDrive drive;

	public DriveTrain() {
		super();
		left_motor = PortsButtons.SpeedController(PortsButtons.MC_DRIVE_LEFT);
		right_motor = PortsButtons.SpeedController(PortsButtons.MC_DRIVE_RIGHT);

		drive = new RobotDrive(left_motor, right_motor);

		// Let's show everything on the LiveWindow
		 LiveWindow.addActuator("Drive Train", "Left Motor", (LiveWindowSendable)
		 left_motor);
		 LiveWindow.addActuator("Drive Train", "Right Motor",
		 (LiveWindowSendable) right_motor);
	}

	/**
	 * When no other command is running let the operator drive around using the
	 * PS3 joystick.
	 */
	public void initDefaultCommand() {
		setDefaultCommand(new TankDriveWithJoystick());
	}

	/**
	 * The log method puts interesting information to the SmartDashboard.
	 */
	public void log() {
	}

	/**
	 * Tank style driving for the DriveTrain.
	 * 
	 * @param left
	 *            Speed in range [-1,1]
	 * @param right
	 *            Speed in range [-1,1]
	 */
	public void drive(double left, double right) {
		drive.tankDrive(left, right);
	}

	/**
	 * @param joy
	 *            The ps3 style joystick to use to drive tank style.
	 */
	public void drive(Joystick joy) {
		drive(joy.getRawAxis(PortsButtons.JOYAXS_LEFT_Y),
				joy.getRawAxis(PortsButtons.JOYAXS_RIGHT_Y));
	}

	/**
	 * Reset the robots sensors to the zero states.
	 */
	public void reset() {
	}

}
