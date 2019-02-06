package org.usfirst.frc.team6526.robot.subsystems;

import org.usfirst.frc.team6526.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Catch extends Subsystem{

	public Spark catch1 = new Spark(RobotMap.catch1);
	public Spark catch2 = new Spark(RobotMap.catch2);
	public Spark catch3 = new Spark(RobotMap.catch3);
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	//check for inverse 
	//configure speed values
	public void intake() {
		catch1.set(1);
		catch2.set(1);
		catch3.set(1);
	}
	//necessary for testing 
	public void outtake() {
		catch1.set(1);
		catch2.set(1);
		catch3.set(1);
	}
	
	
	

}
