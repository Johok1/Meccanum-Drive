package org.usfirst.frc.team6526.robot.commands;

import org.usfirst.frc.team6526.robot.OI;
import org.usfirst.frc.team6526.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

public class RotateDegree90 extends Command {
	MecanumDrive m_robotDrive;
	OI m_oi = Robot.m_oi;
	
    public RotateDegree90() {
    	requires(Robot.drivetrain);
    }

    protected void initialize() {
    	Robot.drivetrain.getController().setSetpoint(90);
    }

    protected void execute() {
    	Robot.drivetrain.meccanumDriveSetAngle(m_oi.leftX(), m_oi.leftY());
    }

    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {
    }
    
    protected void interrupted() {
    	isFinished();
    }
}
