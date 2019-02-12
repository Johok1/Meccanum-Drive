package org.usfirst.frc.team6526.robot.commands;
//not even sure if this code is decent so I'm sorry

import org.usfirst.frc.team6526.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
public class Compressor extends Command{

	public void Compressor(){
		requires(Robot.Pneumatics);
	}
	
	protected void execute() {
		Pneumatics.compStart;
	}
	
	protected void checkStatus() {
		enabled();
	}
	protected boolean getPressureValue() {
		getPressureSwitchValue()
	}
	
	protected void isFinished() {
		Pneumatics.compStop;
	}
	
	protected void interrupted() {
		Pneumatics.compStop;
	}
    
}
