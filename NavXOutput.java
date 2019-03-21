package org.usfirst.frc.team6526.robot;

import edu.wpi.first.wpilibj.PIDOutput;

public class NavXOutput implements PIDOutput{
	public double output; 
	@Override
	public void pidWrite(double output) {
		this.output = output; 
	}
	

}
