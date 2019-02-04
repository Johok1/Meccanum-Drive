package org.usfirst.frc.team6526.robot.commands;

import org.usfirst.frc.team6526.robot.OI;
import org.usfirst.frc.team6526.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

public class Rotate90Degrees extends Command{
	
	OI m_oi = Robot.m_oi;
	
    public Rotate90Degrees() {
    	requires(Robot.drivetrain);
    }

    protected void initialize() {
    	Robot.drivetrain.controller.setSetpoint(180);
    	Robot.drivetrain.controller.enable();
    }

    protected void execute() {
    	//try without meccanumDrive 
    	Robot.drivetrain.mecannumDriveOreintated(0,0,Robot.drivetrain.output);
    }

    protected boolean isFinished() {
    	if(Robot.drivetrain.controller.onTarget()) {
    		return true; 
    	}
        return false;
    }
    
    protected void end() {
    	Robot.drivetrain.controller.disable();
    	Robot.drivetrain.mecannumDriveOreintated(0, 0, 0);
    }
    
    protected void interrupted() {
    	end();
    }
}
