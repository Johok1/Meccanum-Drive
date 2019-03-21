package org.usfirst.frc.team6526.robot.subsystems;

import org.usfirst.frc.team6526.robot.NavXOutput;
import org.usfirst.frc.team6526.robot.NavXPID;
import org.usfirst.frc.team6526.robot.RobotMap;
import org.usfirst.frc.team6526.robot.UltrasonicPID;
import org.usfirst.frc.team6526.robot.commands.FeildOreintatedDriveJoystick;
import org.usfirst.frc.team6526.robot.commands.MeccanumDrive;

import com.kauailabs.navx.frc.AHRS;


import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.SPI;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;




public class DriveTrain extends Subsystem implements PIDOutput {
	//Set all sensors and even drive methods and stuff to public so we can have easier access 
	
	//Motors	
	private Spark frontRight = new Spark(RobotMap.fright);
	 private Spark frontLeft = new Spark(RobotMap.fleft);
	 private Spark rearRight = new Spark(RobotMap.rright);
	 private Spark rearLeft = new Spark(RobotMap.rleft);
	 public double output; 
	
	 
	 //Manipulators
	 public AnalogInput ultrasonic = new AnalogInput(RobotMap.ultrasonic);
	 public  AHRS ahrs = new AHRS(SPI.Port.kMXP); 
	 public UltrasonicPID ultrasonicPID= new UltrasonicPID(); 
	 public NavXPID navXPID = new NavXPID();
	 public NavXOutput navOutput = new NavXOutput();
	 //Misc
	 public static final double ultraToInches = 0.02431373;
	 public MecanumDrive drive = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);
	 public PIDController control;
	 public PIDController navX; 
	 
	 
	 public DriveTrain() {
		 control = new PIDController(.3, 0, 0, ultrasonicPID, this);
		 control.setInputRange(18, 60);
		 control.setOutputRange(-1,1);
		 control.setAbsoluteTolerance(0.05);
		 control.setContinuous(false);
		 
		 navX = new PIDController(.3,0,0,navXPID,navOutput);
		 navX.setInputRange(0, 180);
		 navX.setOutputRange(-1, 1);
		 navX.setAbsoluteTolerance(0.05);
		 navX.setContinuous(false);	
	 }

	 public void initDefaultCommand(){
		setDefaultCommand(new MeccanumDrive());
		
	 }
    
    
	 //figure out commands for driving straight forwards and backwards
    public void mecannumDriveOreintated(double leftx, double lefty,double rightx){
		drive.driveCartesian(lefty, leftx,rightx,0);
    }
    public void mecannumDrive(double leftx, double lefty,double rightx){
    	drive.driveCartesian(leftx*.7, -lefty*.7,rightx*.7);
    }

   
	public double getUltrasonicInches() {
		return ultrasonic.getVoltage()/ultraToInches;
	}

	@Override
	public void pidWrite(double output) {
		this.output = output;
	}
}