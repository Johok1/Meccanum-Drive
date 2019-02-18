package org.usfirst.frc.team6526.robot.commands;

import org.usfirst.frc.team6526.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TestRed extends Command{
	public TestRed() {
		requires(Robot.arm);
	}
	
	public void initialize() {
		SmartDashboard.putData(Robot.arm.motor3);
		
	}
	public void execute() {
		Robot.arm.testToMotor(.4);
	}
	public void end() { 
		Robot.arm.testToMotor(0);
	}

	@Override
	protected boolean isFinished() {
	
		return false;
	}
	public void interrupted() {
		end();
	}

}
