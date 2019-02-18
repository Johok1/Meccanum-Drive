package org.usfirst.frc.team6526.robot.subsystems;






import org.usfirst.frc.team6526.robot.AbsoluteEncoderPID;
import org.usfirst.frc.team6526.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;




public class Arm extends Subsystem implements PIDOutput{
	public Solenoid solenoid1 = new Solenoid(RobotMap.solenoid1);
	public Spark motor2 = new Spark(7);
	//public Spark motor1 = new Spark(6);
	public Spark motor3 = new Spark(5);
	public double output; 
	public AbsoluteEncoderPID encoder = new AbsoluteEncoderPID();
	public DigitalInput limit = new DigitalInput(1);
	public PIDController controller;
	
	public Arm() {
	   controller = new PIDController(.25,0,0,encoder,this);
	   controller.setOutputRange(-1.0, 1.0);
	   controller.setInputRange(0, 100);
	   controller.setAbsoluteTolerance(0.15);
	   controller.setContinuous(true);
	   
	 }
	
	@Override
	protected void initDefaultCommand() {
	}
	
	public void moveToAngle(double speed) {
		
		motor2.setSpeed(speed*.5);
	}
	public void testToMotor(double speed) {
		motor3.setSpeed(speed);
	}

	
	@Override
	public void pidWrite(double output) {
		this.output = output; 
	}
	public void solenoidControl(boolean open) {
		solenoid1.set(open);
	}

}
