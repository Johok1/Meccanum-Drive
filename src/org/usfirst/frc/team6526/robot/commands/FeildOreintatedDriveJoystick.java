package org.usfirst.frc.team6526.robot.commands;


import org.usfirst.frc.team6526.robot.OI;
import org.usfirst.frc.team6526.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.drive.MecanumDrive;



public class FeildOreintatedDriveJoystick extends Command {
	MecanumDrive m_robotDrive;
	OI m_oi = Robot.m_oi;
	
    public FeildOreintatedDriveJoystick() {
    	requires(Robot.drivetrain);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.drivetrain.mecannumDriveOreintated(m_oi.leftX(),m_oi.leftY(),m_oi.rightX());
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
