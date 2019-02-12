package org.usfirst.frc.team6526.robot.subsystems;
//still not 100% sure about this code just yet

import org.usfirst.frc.team6526.robot.RobotMap;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pneumatics extends Subsystem{
	
	public Solenoid piston = new Solenoid(Robot.solenoid);
	public Compressor compressor = new Compressor();
	
	public void out(){
		piston.set(true);
	}
	
	public void in(){
		piston.set(false);
	}
	
	protected void compStart() {
		compressor.start;
	}
	
	protected void compStop() {
		compressor.stop;
	}
}
