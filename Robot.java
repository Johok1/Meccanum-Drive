package org.usfirst.frc.team6526.robot;

import org.usfirst.frc.team6526.robot.commands.EjectCargo;
import org.usfirst.frc.team6526.robot.commands.Fire;
import org.usfirst.frc.team6526.robot.commands.LoadCargo;
import org.usfirst.frc.team6526.robot.commands.MoveAngleTrigger;
import org.usfirst.frc.team6526.robot.subsystems.Catch;
import org.usfirst.frc.team6526.robot.subsystems.DriveTrain;
import org.usfirst.frc.team6526.robot.subsystems.TurretTilt;
import org.usfirst.frc.team6526.robot.commands.KeepAngle;
import org.usfirst.frc.team6526.robot.commands.FeildOreintatedDriveJoystick;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {
	
	
	//Subsystems
	public static final DriveTrain drivetrain = new DriveTrain();
	public static final TurretTilt turret = new TurretTilt();
	public static final Catch catcher = new Catch(); 
			
	
	
	public AHRS ahrs;
	
	//Misc
	public static OI m_oi;
	
	//SmartDashboard
	
	@Override
	public void robotInit() {
		//MISC (OI ALWAYS in front !!!) 
		
		m_oi = new OI();
		//ahrs = new AHRS(SPI.Port.kMXP);
		
		
		
		
		//SmartDashboard
	
	}


	@Override
	public void disabledInit() {
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();

	}
	
	@Override
	public void autonomousInit() {
	}

	
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {	
		//arm.moveToAngle(0);
	}
	
	
	//Max Voltage: 1.627197099; Min Voltage: 0.19775388600000002
	//Encoder Range/ Moralez's Constant: 1.434326025
	//public double maxv=0,min=1;
	
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
		/*
		if (maxv<Robot.arm.encoder.absoluteEncoder.getVoltage())maxv=Robot.arm.encoder.absoluteEncoder.getVoltage();
		if (min>Robot.arm.encoder.absoluteEncoder.getVoltage())min=Robot.arm.encoder.absoluteEncoder.getVoltage();
		SmartDashboard.putNumber("Max Voltage: " , max);
		SmartDashboard.putNumber("Min Voltage: " , min);
		SmartDashboard.putNumber("Moralez's Constant: ", max-min);
		*/
		
		
	
		SmartDashboard.putNumber("Raw Voltage: " , Robot.turret.encoder.absoluteEncoder.getVoltage());
		SmartDashboard.putNumber("Converted Value " , Robot.turret.encoder.getValue());
		SmartDashboard.putNumber("Converted Unit" , Robot.turret.encoder.pidGet());
		SmartDashboard.putNumber("Angle Of the Cannon" , Robot.turret.encoder.getAngle());
		
		
		//-------------------------------------------
		
	
	}
		
	@Override
	public void testPeriodic() {
	}
}
