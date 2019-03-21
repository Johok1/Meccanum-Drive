package org.usfirst.frc.team6526.robot.commands;

import org.usfirst.frc.team6526.robot.OI;
import org.usfirst.frc.team6526.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class KeepAngle extends Command{
private OI m_oi = Robot.m_oi;
	
    public KeepAngle() {
    	requires(Robot.drivetrain);
    }

    protected void initialize() {
    	Robot.drivetrain.control.setSetpoint(Robot.drivetrain.ahrs.getAngle());
    	Robot.drivetrain.control.enable();
    }

    protected void execute() {
    	Robot.drivetrain.mecannumDriveOreintated(m_oi.leftX(),m_oi.leftY(),Robot.drivetrain.navOutput.output);
    }

    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {
    	Robot.drivetrain.mecannumDriveOreintated(0, 0, 0);
    }
    
    protected void interrupted() {
    	end();
    }
}
