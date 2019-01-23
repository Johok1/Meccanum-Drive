package org.usfirst.frc.team6526.robot.subsystems;

import org.usfirst.frc.team6526.robot.RobotMap;
import org.usfirst.frc.team6526.robot.commands.FeildOreintatedDriveJoystick;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;




public class DriveTrain extends Subsystem {
	//Motors	
	 private Spark frontRight = new Spark(RobotMap.fright);
	 private Spark frontLeft = new Spark(RobotMap.fleft);
	 private Spark rearRight = new Spark(RobotMap.rright);
	 private Spark rearLeft = new Spark(RobotMap.rleft);
	 
	 //Manipulators
	 private AnalogInput ultrasonic = new AnalogInput(0);
	 private  AHRS ahrs = new AHRS(SPI.Port.kMXP); 
	 
	 //Misc
	 private double ultraToInches = 0.02431373;
	 private MecanumDrive drive = new MecanumDrive(frontLeft, frontRight, rearLeft, rearRight);


	 public void initDefaultCommand() {
    	setDefaultCommand(new FeildOreintatedDriveJoystick());
    }
    
	 
    public void mecannumDriveOreintated(double leftx, double lefty,double rightx){
    	drive.driveCartesian(lefty*.5, -leftx*.5,rightx*.5,ahrs.getAngle());
    }
    public void mecannumDrive(double leftx, double lefty,double rightx){
    	drive.driveCartesian(lefty*.5, -leftx*.5,rightx*.5);
    }

    //Getters
	public Sendable getUltrasonic() {
		return ultrasonic;
	}

	public double getUltrasonicInches() {
		return ultrasonic.getVoltage()/ultraToInches;
	}

	public Sendable getAHRS() {
		return ahrs;
	}
}