package org.usfirst.frc.team6526.robot.commands;

import org.usfirst.frc.team6526.robot.Robot;
import org.usfirst.frc.team6526.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
public class MoveToPointOne extends Command{

    
    protected void initialize() {
        Robot.drivetrain.control.enable();
        Robot.drivetrain.control.setSetpoint(RobotMap.setpointOne);
    }

    protected void execute() { 	
        Robot.drivetrain.mecannumDriveOreintated(Robot.drivetrain.output, Robot.drivetrain.output, 0);
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
