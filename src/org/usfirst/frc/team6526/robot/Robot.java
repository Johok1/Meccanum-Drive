/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6526.robot;

import org.usfirst.frc.team6526.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {
	
	
	//Subsystems
	public static final DriveTrain drivetrain = new DriveTrain();
	
	//Misc
	public static OI m_oi;
	
	//SmartDashboard
	
	@Override
	public void robotInit() {
		//MISC (OI ALWAYS in front !!!) 
		m_oi = new OI();
		
		//SmartDashboard
		SmartDashboard.putData(Scheduler.getInstance());
    	SmartDashboard.putData(drivetrain);
    	SmartDashboard.putData(drivetrain.getUltrasonic());
    	SmartDashboard.putData(drivetrain.getAHRS());
    	SmartDashboard.putNumber("Distance form Sensor 1 " , drivetrain.getUltrasonicInches());
   
    	//Cameras
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
	}

	
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	
	}

	@Override
	public void testPeriodic() {
	}
}