package org.usfirst.frc.team6526.robot.commands;

import org.usfirst.frc.team6526.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class Fire extends Command {

	public Fire(){
		requires(Robot.turret);
	}
	
 	protected void initialize() {
 		//How should we confirm that the firing sequence is complete? Limit switch? 
 		//Do we want to center the robot automatically? this is where to implement it.
    }

    protected void execute() {
    	Robot.turret.fire(1);
    }

    protected boolean isFinished() {
   
        return false;
    }
    
    protected void end() {
    	Robot.turret.dontFire();
    }
    
    protected void interrupted() {
    	end();
    }
}