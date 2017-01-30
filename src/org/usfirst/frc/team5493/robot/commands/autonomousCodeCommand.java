package org.usfirst.frc.team5493.robot.commands;

import org.usfirst.frc.team5493.robot.Robot;
import org.usfirst.frc.team5493.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * hi
 */
public class autonomousCodeCommand extends CommandGroup{
    
    public  autonomousCodeCommand(){
    	addSequential(new DriveCommand());
    	addSequential(new TurnLeft());
    	addParallel(new ShootBall());

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
