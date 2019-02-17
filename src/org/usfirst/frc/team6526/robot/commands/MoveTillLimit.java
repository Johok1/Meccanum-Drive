package org.usfirst.frc.team6526.robot.commands;

import org.usfirst.frc.team6526.robot.Robot;
import org.usfirst.frc.team6526.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.Command;

public class MoveTillLimit extends Command {

	public MoveTillLimit() {
		requires(Robot.arm);
	}
	
	public void initialize() {
	
	}
	
	public void execute() {

		Robot.arm.moveToAngle(-1);
	}
	
	@Override
	protected boolean isFinished() {
		
		return false;
	}
	

	public void end() {
		
		Robot.arm.moveToAngle(0);
	}
	
	
	public void interrupted() {
	
		end();
	}

}
