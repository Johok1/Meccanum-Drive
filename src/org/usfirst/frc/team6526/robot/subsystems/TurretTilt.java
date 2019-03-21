package org.usfirst.frc.team6526.robot.subsystems;

import org.usfirst.frc.team6526.robot.AbsoluteEncoderPID;
import org.usfirst.frc.team6526.robot.RobotMap;
import org.usfirst.frc.team6526.robot.commands.MoveAngleTrigger;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class TurretTilt extends Subsystem implements PIDOutput{

	private Spark tilt1 = new Spark(RobotMap.tilt1); 
	
	private Spark flywheel1 = new Spark(RobotMap.flywheel);

	private DigitalOutput limitswitch = new DigitalOutput(RobotMap.limitswitch2);
	
	

 	
	
	public PIDController controlEncoder; 
	public AbsoluteEncoderPID encoder = new AbsoluteEncoderPID(); 
	public double output; 
	
	@Override
	protected void initDefaultCommand() {
	
	}
	
	public TurretTilt() {
		//configure
		controlEncoder = new PIDController(.3,0,0,encoder,this);
		controlEncoder.setInputRange(0, 180); //determine 
		controlEncoder.setOutputRange(-1, 1);
		controlEncoder.setAbsoluteTolerance(0.05);
		controlEncoder.setContinuous(false);
	}
	//check for invert need 
	public void tilt() {
		tilt1.set(output*.3);
		
	}public void tiltset(double set) {
		tilt1.set(set*.4);
		
	}

	public void stop() {
		tilt1.set(0);
	}
	public void fire(double input) {
		flywheel1.set(input);
	}
	public void dontFire() {
		flywheel1.set(0);
	}
	public boolean limitswitch() {
		return limitswitch.get(); 
	}
	@Override
	public void pidWrite(double output) {
		this.output = output; 
	}
	

}
