package org.usfirst.frc.team6526.robot.commands;

import org.usfirst.frc.team6526.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class EjectCargo extends Command {

	public EjectCargo(){
		requires(Robot.catcher);
	}
	
 	protected void initialize() {
 		
    }

    protected void execute() {
    	//how to determine when to stop.... timer?
    	Robot.catcher.outtake();
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