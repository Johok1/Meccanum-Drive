package org.usfirst.frc.team6526.robot.commands;

import org.usfirst.frc.team6526.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SolClose extends Command{

	public SolClose() {
		requires(Robot.pnuematicTest);
	}

	protected void initialize() {
		
    }

    protected void execute() {
    	Robot.pnuematicTest.closeMaybe();
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
