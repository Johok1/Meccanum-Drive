package org.usfirst.frc.team6526.robot.subsystems;

import org.usfirst.frc.team6526.robot.RobotMap;
import org.usfirst.frc.team6526.robot.commands.FeildOreintatedDriveJoystick;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.SPI;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;




public class DriveTrain extends Subsystem {
	//Set all sensors and even drive methods and stuff to public so we can have easier access 
	
	//Motors	
	 private Spark frontRight = new Spark(RobotMap.fright);
	 private Spark frontLeft = new Spark(RobotMap.fleft);
	 private Spark rearRight = new Spark(RobotMap.rright);
	 private Spark rearLeft = new Spark(RobotMap.rleft);
	 
	 //Manipulators
	 public AnalogInput ultrasonic = new AnalogInput(RobotMap.ultrasonic);
	 public  AHRS ahrs = new AHRS(SPI.Port.kMXP); 
	 
	 //Misc
	 public static final double ultraToInches = 0.02431373;
	 public MecanumDrive drive = new MecanumDrive(frontLeft, frontRight, rearLeft, rearRight);


	 public void initDefaultCommand() {
    	setDefaultCommand(new FeildOreintatedDriveJoystick());
    }
    
	 
    public void mecannumDriveOreintated(double leftx, double lefty,double rightx){
    	drive.driveCartesian(lefty*.5, -leftx*.5,rightx*.5,ahrs.getAngle());
    }
    public void mecannumDrive(double leftx, double lefty,double rightx){
    	drive.driveCartesian(lefty*.5, -leftx*.5,rightx*.5);
    }

   
	public double getUltrasonicInches() {
		return ultrasonic.getVoltage()/ultraToInches;
	}

}