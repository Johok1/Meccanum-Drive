package org.usfirst.frc.team6526.robot.commands;

import org.usfirst.frc.team6526.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TiltToDefault extends Command{

		public TiltToDefault(){
			requires(Robot.turretTilt);
		}
		
	 	protected void initialize() {
		 Robot.turretTilt.control.setSetpoint(90);
		 Robot.turretTilt.control.enable();
	    }

	    protected void execute() {
	    	Robot.turretTilt.tilt(Robot.turretTilt.output);
	    }

	    protected boolean isFinished() {
	    	if(Robot.turretTilt.control.onTarget()) {
	    		return true; 
	    	}
	        return false;
	    }
	    
	    protected void end() {
	    	Robot.turretTilt.control.disable();
	    }
	    
	    protected void interrupted() {
	    	end();
	    }
}
