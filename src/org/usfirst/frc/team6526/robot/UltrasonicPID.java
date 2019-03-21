package org.usfirst.frc.team6526.robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

public class UltrasonicPID implements PIDSource {
	
	@Override
	public void setPIDSourceType(PIDSourceType pidSource) {
		pidSource = PIDSourceType.kDisplacement;
	}

	@Override
	public PIDSourceType getPIDSourceType() {
		
		return PIDSourceType.kDisplacement;
	}

	@Override
	public double pidGet() {
		// TODO Auto-generated method stub
		return Robot.drivetrain.getUltrasonicInches(); 
	}

}
