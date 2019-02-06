package org.usfirst.frc.team6526.robot.subsystems;

import org.usfirst.frc.team6526.robot.RobotMap;


import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class TurretTilt extends Subsystem implements PIDOutput{

	private Spark tilt1 = new Spark(RobotMap.tilt1); 
	private Spark tilt2 = new Spark(RobotMap.tilt2);
	
	//Do i need to configure the compressor? Magnetic Switches? 
	private Solenoid fire = new Solenoid(RobotMap.solenoid1);
	
	public PIDController control; 
	public AnalogGyro gyro = new AnalogGyro(RobotMap.tiltGyro);
	public double output; 
	
	@Override
	protected void initDefaultCommand() {
	//	setDefaultCommand();
	}
	
	public TurretTilt() {
		//configure
		control = new PIDController(.3,0,0,gyro,this);
		control.setInputRange(0, 180);
		control.setOutputRange(-1, 1);
		control.setAbsoluteTolerance(0.05);
		control.setContinuous();
	}
	//check for invert need 
	public void tilt(double speed) {
		tilt1.set(speed);
		tilt2.set(speed);
	}
	public void extendFire() {
		fire.set(true);
	}
	public void retractFire() {
		fire.set(false);
	}

	@Override
	public void pidWrite(double output) {
		this.output = output; 
	}
	

}
