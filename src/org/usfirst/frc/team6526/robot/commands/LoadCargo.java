package org.usfirst.frc.team6526.robot.commands;

import org.usfirst.frc.team6526.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LoadCargo extends Command {

	public LoadCargo(){
		requires(Robot.catcher);
	}
	
 	protected void initialize() {
 		
    }

    protected void execute() {
    	//how to determine when to stop.... timer?
    	Robot.catcher.intake();
    	
    }

    protected boolean isFinished() {
    	
        return false;
    }
    
    protected void end() {
    	Robot.catcher.stop();
    }
    
    protected void interrupted() {
    	end();
    }
}