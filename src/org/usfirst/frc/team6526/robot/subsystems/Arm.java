package org.usfirst.frc.team6526.robot.subsystems;






import org.usfirst.frc.team6526.robot.AbsoluteEncoderPID;
import org.usfirst.frc.team6526.robot.commands.MoveTillLimit;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;




public class Arm extends Subsystem implements PIDOutput{

	public Spark motor2 = new Spark(3);
	public double output; 
	public AbsoluteEncoderPID encoder = new AbsoluteEncoderPID();
	
	//public AnalogGyro gyro = new AnalogGyro(1);
	public DigitalInput limit = new DigitalInput(1);
	public PIDController controller;
	public Arm() {
	   controller = new PIDController(.4,0,0,encoder,this);
	   controller.setOutputRange(-1.0, 1.0);
	   controller.setInputRange(.2, 180.0);
	   controller.setAbsoluteTolerance(0.05);
	   controller.setContinuous(true);
	 }
	
	@Override
	protected void initDefaultCommand() {
	 //setDefaultCommand(new MoveTillLimit());	
	}
	
	public void moveToAngle(double speed) {
		motor2.setSpeed(-speed);
	}

	
	@Override
	public void pidWrite(double output) {
		this.output = output; 
	}

}
