package org.usfirst.frc.team6526.robot.commands;

import org.usfirst.frc.team6526.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class EjectCargo extends Command {

	public EjectCargo(){
		requires(Robot.catchSub);
	}
	
 	protected void initialize() {
 		
    }

    protected void execute() {
    	//how to determine when to stop.... timer?
    	Robot.catchSub.outtake();
    	
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