package org.usfirst.frc.team5493.robot;

import org.usfirst.frc.team5493.robot.controllers.LWTalon;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.SpeedController;

public class PortsButtons {
	public final static int MC_DRIVE_RIGHT = 2;
	public final static int MC_DRIVE_LEFT = 1;
	public final static int MC_BALL_SHOOTER_RIGHT = 4;
	public final static int MC_BALL_SHOOTER_LEFT = 5;
	public final static int MC_BALL_INTAKE = 7;
	
	public final static int JOYBTN_A = 1;
	public final static int JOYBTN_B = 2;
	public final static int JOYBTN_X = 3;
	public final static int JOYBTN_Y = 4;
	public final static int JOYBTN_LB = 5;
	public final static int JOYBTN_RB = 6;
	
	public final static int JOYAXS_LEFT_Y = 1;
	public final static int JOYAXS_RIGHT_Y = 5;
	
	public static SpeedController SpeedController( int port) {
		
		if (Timings.USE_CAN) {
			return new CANTalon(port);
		}
		else {             
			return new LWTalon(port);
		}
	}
}
