package org.usfirst.frc.team6526.robot.commands;

import org.usfirst.frc.team6526.robot.Robot;
import org.usfirst.frc.team6526.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TiltToPointOne extends Command{
		public TiltToPointOne(){
			requires(Robot.turretTilt);
		}
		
	 	protected void initialize() {
	 		//This angle point must be determined !!!! 
	 		//We have to determine a constant based on the test data that we receive from the ultrasonic sensor 
		 Robot.turretTilt.control.setSetpoint(40*RobotMap.ultraConstant);
		 Robot.turretTilt.control.enable();
	    }

	    protected void execute() {
	    	Robot.turretTilt.tilt(Robot.turretTilt.output);
	    	SmartDashboard.putNumber("Turret Angle ",Robot.turretTilt.gyro.getAngle());
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
