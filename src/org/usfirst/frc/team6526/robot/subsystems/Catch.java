package org.usfirst.frc.team6526.robot.subsystems;

import org.usfirst.frc.team6526.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Catch extends Subsystem{

	public Spark catch1 = new Spark(RobotMap.intake);
	public Spark hatch = new Spark(RobotMap.hatch);
	
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	//check for inverse 
	//configure speed values
	public void intake() {
		catch1.set(.4);
	}
	//necessary for testing 
	public void outtake() {
		catch1.set(-.2);	
	}
	public void stop() {
		catch1.set(0);
	}
	public void hatchRaise() {
		hatch.set(.3);
	}
	public void hatchLower() {
		hatch.set(-.3);
	}
	public void hatchStop() {
		hatch.set(0);
	}

	

}
