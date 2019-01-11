package org.usfirst.frc.team6526.robot.commands;


import org.usfirst.frc.team6526.robot.OI;
import org.usfirst.frc.team6526.robot.Robot;


import org.usfirst.frc.team6526.robot.subsystems.DriveTrain;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import javafx.application.Application;

/**
 *
 */
public class FeildOreintatedDriveJoystick extends Command {
	MecanumDrive m_robotDrive;
	OI m_oi = Robot.m_oi;
	
	
	
    public FeildOreintatedDriveJoystick() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//Application.launch(application.MainApp.class);
    	
    	 
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    
    	Robot.drivetrain.mecannumDriveGyro(m_oi.leftX(),m_oi.leftY(),m_oi.rightX(),Robot.ahrs.getAngle());
    	
    	
    }

    // Make this return true when this Command no longer needs to run execute
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
