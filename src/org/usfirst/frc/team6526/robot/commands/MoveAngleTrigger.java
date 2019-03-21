package org.usfirst.frc.team6526.robot.commands;

import org.usfirst.frc.team6526.robot.Robot;
import org.usfirst.frc.team6526.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class MoveAngleTrigger extends Command {

	public MoveAngleTrigger(){
		requires(Robot.turret);
	}
	
 	protected void initialize() {
    }

    protected void execute() {
        while(Robot.m_oi.getBButton()){
        Robot.turret.tiltset(1);
        }
        while(Robot.m_oi.getXButton()){
            Robot.turret.tiltset(-1);
        }
        Robot.turret.stop();

    	SmartDashboard.putNumber("Turret Angle ",Robot.turret.encoder.getAngle());
    }

    protected boolean isFinished() {
    	
        return false;
    }
    
    protected void end() {
    	Robot.turret.stop();
    }
    
    protected void interrupted() {
    	end();
    }
}
