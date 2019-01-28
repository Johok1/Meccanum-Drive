package org.usfirst.frc.team6526.robot.subsystems;

import org.usfirst.frc.team6526.robot.RobotMap;
import org.usfirst.frc.team6526.robot.commands.FeildOreintatedDriveJoystick;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
//import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;


//TODO: figure out how the returned PID data responds to the angle data and how we can use that to manipulate motors

public class DriveTrain extends PIDSubsystem {
	

	//Motors	
	 private Spark frontRight = new Spark(RobotMap.fright);
	 private Spark frontLeft = new Spark(RobotMap.fleft);
	 private Spark rearRight = new Spark(RobotMap.rright);
	 private Spark rearLeft = new Spark(RobotMap.rleft);
	 
	 //Manipulators
	 private AnalogInput ultrasonic = new AnalogInput(0);
	 private static  AHRS ahrs = new AHRS(SPI.Port.kMXP); 
	 
	 //Misc
	 private double ultraToInches = 0.02431373;
	 private double pidResult;
	 private MecanumDrive drive = new MecanumDrive(frontLeft, frontRight, rearLeft, rearRight);
	 
	 public DriveTrain() {
			super(2,0,0);
			this.setSetpoint(0);
			
			//TODO: look into other methods to implement 
		}

	 public void initDefaultCommand() {
    	setDefaultCommand(new FeildOreintatedDriveJoystick());
    }
    
	 //Function methods 
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
	
	public double getPIDResult() {
		return pidResult;
	}
	
	public double getAngleARHS() {
		return ahrs.getAngle();
	}


	//PIDSubsystem method overrides
	@Override
	public double returnPIDInput() {
		//TODO: test what type of data getAngle() returns
		return ahrs.getAngle();
	}


	@Override
	protected void usePIDOutput(double arg0) {
		this.pidResult = arg0;
	}	
}