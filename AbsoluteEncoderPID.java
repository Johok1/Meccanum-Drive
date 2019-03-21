package org.usfirst.frc.team6526.robot;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

public class AbsoluteEncoderPID implements PIDSource {
	public AnalogInput absoluteEncoder = new AnalogInput(RobotMap.absoluteEncoder);
	//Son--------
	//Max Voltage: 1.627197099; Min Voltage: 0.19775388600000002
		//Encoder Range/ Moralez's Constant: 1.434326025
		//public double max=0,min=1;
	private double lowExtreme=0.3, // Where the limit switch is placed to calibrate.
			value=0;// Converted unit for linear data.
	private final double encoderRange=1.627197099-0.19775388600000002,
			cannonRange=.186;
	//SOn------------
	
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
		value=Robot.turret.encoder.absoluteEncoder.getVoltage()+encoderRange/2-lowExtreme;//Shift the value
		if (value>encoderRange)value-=encoderRange; //Cut down overtuned.
		return 100*(value-(encoderRange/2-cannonRange))/cannonRange;// returned with scaled downed value

	}
	
	public double getValue() {
		return value;
	}
	public double getAngle() {
		return 180-360/encoderRange*value;
	}

	
}
