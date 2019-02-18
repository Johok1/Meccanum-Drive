package org.usfirst.frc.team6526.robot.commands;

import org.usfirst.frc.team6526.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SolenoidControl extends Command {
	private boolean value = false;
	
	public SolenoidControl() {
		requires(Robot.arm);
	}
	public void initialize() {
		SmartDashboard.putBoolean("Solenoid Control ", value);
	}
	public void execute() {
		Robot.arm.solenoidControl(value);
	}
	public void end() {
		
	}
	public void interrupted() {
		
	}
	@Override
	protected boolean isFinished() {
		return false;
	}

}
