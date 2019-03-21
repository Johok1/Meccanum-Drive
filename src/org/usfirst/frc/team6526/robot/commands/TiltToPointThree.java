package org.usfirst.frc.team6526.robot.commands;

import org.usfirst.frc.team6526.robot.Robot;
import org.usfirst.frc.team6526.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TiltToPointThree extends Command {

	public TiltToPointThree(){
		requires(Robot.turret);
	}
	
 	protected void initialize() {
 		//This angle point must be determined !!!! 
 		//We have to determine a constant based on the test data that we receive from the ultrasonic sensor 
	 Robot.turret.controlEncoder.setSetpoint(RobotMap.setpointThree);
	 Robot.turret.controlEncoder.enable();
    }

    protected void execute() {
    	Robot.turret.tilt();
    	SmartDashboard.putNumber("Turret Angle ",Robot.turret.encoder.getAngle());
    }

    protected boolean isFinished() {
    	if(Robot.turret.controlEncoder.onTarget()) {
    		return true; 
    	}
        return false;
    }
    
    protected void end() {
    	Robot.turret.stop();
    	Robot.turret.controlEncoder.disable();
    }
    
    protected void interrupted() {
    	end();
    }
}
