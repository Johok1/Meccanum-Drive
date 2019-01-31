package org.usfirst.frc.team6526.robot.subsystems;
//not 100% sure about this code just yet

import org.usfirst.frc.team6526.robot.RobotMap;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pneumatics{
	
	mainCompressor.setClosedLoopControl(true);
	mainCompressor.setClosedLoopControl(false);
	Solenoid piston1 = new Solenoid(1);
	Solenoid piston2 = new Solenoid(2);
	mainCompressor.start;
	
	int i = 0;
	if(i = 0){
		piston1.set(true);
		piston2.set(true);
	}
	else{
		piston1.set(false);
		piston2.set(false);
	}
}