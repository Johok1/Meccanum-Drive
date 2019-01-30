package org.usfirst.frc.team6526.robot.subsystems;

import org.usfirst.frc.team6526.robot.Robot;
import org.usfirst.frc.team6526.robot.RobotMap;


import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.Spark;

import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;


//TODO: figure out how the returned PID data responds to the angle data and how we can use that to manipulate motors

public class DriveTrain extends Subsystem implements PIDOutput{
	

	//Motors	
	 private Spark frontRight = new Spark(RobotMap.fright);
	 private Spark frontLeft = new Spark(RobotMap.fleft);
	 private Spark rearRight = new Spark(RobotMap.rright);
	 private Spark rearLeft = new Spark(RobotMap.rleft);
	 
	 //Manipulators
	 private AnalogInput ultrasonic = new AnalogInput(0);
	 private static  AHRS ahrs = new AHRS(SPI.Port.kMXP); 
	 private PIDController controller; 
	 //Misc
	 private double ultraToInches = 0.02431373;
	 private double output;
	 private MecanumDrive drive = new MecanumDrive(frontLeft, frontRight, rearLeft, rearRight);
	 
	 public DriveTrain() {
		 	controller = new PIDController(0.2,0,0,ahrs,this);
	    	controller.setInputRange(-180, 180);
	    	controller.setOutputRange(-1, 1);
	    	controller.setContinuous(true);
		}

	 public void initDefaultCommand() {
    	
    }
    
	 //Function methods 
    public void mecannumDriveOreintated(double leftx, double lefty,double rightx){
    	drive.driveCartesian(lefty*.5, -leftx*.5,rightx*.5,ahrs.getAngle());
    }
    public void mecannumDrive(double leftx, double lefty,double rightx){
    	drive.driveCartesian(lefty*.5, -leftx*.5,rightx*.5);
    }
    public void meccanumDriveSetAngle(double leftx, double lefty) {
    		drive.driveCartesian(lefty*.5, -leftx*.5, output,ahrs.getAngle());
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
	public PIDController getController() {
		return controller;
	}

	//PID stuff
	@Override
	public void pidWrite(double output) {
		this.output = output; 
	}


}