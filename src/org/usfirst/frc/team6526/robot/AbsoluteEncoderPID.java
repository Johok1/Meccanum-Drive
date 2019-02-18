package org.usfirst.frc.team6526.robot;


import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

public class AbsoluteEncoderPID implements PIDSource {
	public AnalogInput absoluteEncoder = new AnalogInput(1);
	private double max=.860,min=.674;
	private double scalingC=100/(max-min);
	
	@Override
	public void setPIDSourceType(PIDSourceType pidSource) {
		pidSource = PIDSourceType.kDisplacement;
		
	}

	@Override
	public PIDSourceType getPIDSourceType() {
		// TODO Auto-generated method stub
		return PIDSourceType.kDisplacement;
	}

	@Override
	public double pidGet() {
	
		return scalingC*(absoluteEncoder.getVoltage()-min);

	}

	
}
