package org.usfirst.frc.team6526.robot.subsystems;

import org.usfirst.frc.team6526.robot.RobotMap;
import org.usfirst.frc.team6526.robot.commands.FeildOreintatedDriveJoystick;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

/**
 *
 */
public class DriveTrain extends Subsystem {

	 public Spark frontRight = new Spark(RobotMap.fright);
	 public Spark frontLeft = new Spark(RobotMap.fleft);
	 public Spark rearRight = new Spark(RobotMap.rright);
	 public Spark rearLeft = new Spark(RobotMap.rleft);
	

	 public MecanumDrive drive = new MecanumDrive(frontLeft, frontRight, rearLeft, rearRight);
	 
	
	 
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	
    	setDefaultCommand(new FeildOreintatedDriveJoystick());
    	
      
    }
    
    public void mecannumDrive(double leftx, double lefty,double rightx,double gyro){
    	drive.driveCartesian(lefty*.5, -leftx*.5,rightx*.5,gyro);
    	
    }
    public void mecannumDrive(double leftx, double lefty,double rightx){
    	drive.driveCartesian(lefty*.5, -leftx*.5,rightx*.5);
    	
    }
    
}

