package org.usfirst.frc.team6526.robot.commands;

import org.usfirst.frc.team6526.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LoadCargo extends Command {

	public LoadCargo(){
		requires(Robot.catchSub);
	}
	
 	protected void initialize() {
 		
    }

    protected void execute() {
    	//how to determine when to stop.... timer?
    	Robot.catchSub.intake();
    	
    }

    protected boolean isFinished() {
    	
        return true;
    }
    
    protected void end() {
    
    }
    
    protected void interrupted() {
    	end();
    }
}