/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6526.robot;




import org.usfirst.frc.team6526.robot.commands.MoveTillLimit;
import org.usfirst.frc.team6526.robot.commands.MoveToAngle;
import org.usfirst.frc.team6526.robot.commands.MoveToAngle2;
import org.usfirst.frc.team6526.robot.commands.MoveToAngle3;
import org.usfirst.frc.team6526.robot.commands.MoveToAngle4;
import org.usfirst.frc.team6526.robot.subsystems.Arm;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogOutput;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {
	
	
	//Subsystems
	//public static final DriveTrain drivetrain = new DriveTrain();
	public static final Arm arm = new Arm();
			
	//public AnalogInput encoder = new AnalogInput(0);
	
	
	public AHRS ahrs;
	
	//Misc
	public static OI m_oi;
	
	//SmartDashboard
	
	@Override
	public void robotInit() {
		//MISC (OI ALWAYS in front !!!) 
		
		m_oi = new OI();
		ahrs = new AHRS(SPI.Port.kMXP);
		
		
		
		
		//SmartDashboard

		SmartDashboard.putData(new MoveTillLimit());
		SmartDashboard.putData(new MoveToAngle());
		SmartDashboard.putData(new MoveToAngle4());
		SmartDashboard.putData(new MoveToAngle2());
		SmartDashboard.putData(new MoveToAngle3());
		

		
		
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
	
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	
	}
		
	@Override
	public void testPeriodic() {
	}
}
