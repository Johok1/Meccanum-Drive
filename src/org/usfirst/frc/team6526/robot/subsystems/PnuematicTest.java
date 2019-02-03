package org.usfirst.frc.team6526.robot.subsystems;

import org.usfirst.frc.team6526.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class PnuematicTest extends Subsystem {
	
	public Solenoid sol = new Solenoid(RobotMap.solenoid);

	@Override
	protected void initDefaultCommand() {
	}
	
	public void open() {
		sol.set(true);
	}
	public void closeMaybe() {
		sol.set(false);
	}

}
