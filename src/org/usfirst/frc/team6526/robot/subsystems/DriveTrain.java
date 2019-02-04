package org.usfirst.frc.team6526.robot.subsystems;

import org.usfirst.frc.team6526.robot.RobotMap;
import org.usfirst.frc.team6526.robot.commands.FeildOreintatedDriveJoystick;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;




public class DriveTrain extends Subsystem implements PIDOutput{
	//Motors	
	 private Spark frontRight = new Spark(RobotMap.fright);
	 private Spark frontLeft = new Spark(RobotMap.fleft);
	 private Spark rearRight = new Spark(RobotMap.rright);
	 private Spark rearLeft = new Spark(RobotMap.rleft);
	 
	 //constants 
	 public double p = 0; 
	 public double i = 0; 
	 public double d = 0; 
	 
	 //Manipulators
	 public AnalogInput ultrasonic = new AnalogInput(0);
	 public  AHRS ahrs = new AHRS(SPI.Port.kMXP); 
	 
	 //Misc
	 private double ultraToInches = 0.02431373;
	 public MecanumDrive drive = new MecanumDrive(frontLeft, frontRight, rearLeft, rearRight);
	 public PIDController controller; 
	 public double output;
	 public DriveTrain() {
		 controller = new PIDController(0.03,0,0,ahrs,this);
		 controller.setInputRange(-180, 180);
		 controller.setOutputRange(-1, 1);
		 controller.setAbsoluteTolerance(0.05);
		 controller.setContinuous(true);
		
	 }


	 public void initDefaultCommand() {
    	setDefaultCommand(new FeildOreintatedDriveJoystick());
    }
    
	 
    public void mecannumDriveOreintated(double leftx, double lefty,double rightx){
    	drive.driveCartesian(lefty*.5, -leftx*.5,rightx*.5,ahrs.getAngle());
    }
    public void mecannumDrive(double leftx, double lefty,double rightx){
    	drive.driveCartesian(lefty*.5, -leftx*.5,rightx*.3);
    }

   

	public double getUltrasonicInches() {
		return ultrasonic.getVoltage()/ultraToInches;
	}

	@Override
	public void pidWrite(double output) {
		this.output = output; 
		
	}

}