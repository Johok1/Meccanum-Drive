package org.usfirst.frc.team6526.robot.commands;

import org.usfirst.frc.team6526.robot.Robot;
import org.usfirst.frc.team6526.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class MoveToAngle extends Command{

	public MoveToAngle() {
		requires(Robot.arm);
	}
	
	public void initialize() {
		Robot.arm.controller.setSetpoint(10);
		
	}
	
	public void execute() {
		
		SmartDashboard.putNumber("Setpoint: ", Robot.arm.controller.getSetpoint());
		SmartDashboard.putNumber("Voltage value ", Robot.arm.encoder.absoluteEncoder.getVoltage());
		SmartDashboard.putNumber("PID output: ", Robot.arm.output);
		Robot.arm.moveToAngle(Robot.arm.output);
		Robot.arm.controller.enable();
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}
	
	public void end () {
		//Robot.arm.controller.disable();
		Robot.arm.motor2.setSpeed(0);
	}
	
	public void interrupted() {
		end();
	}
	

}
