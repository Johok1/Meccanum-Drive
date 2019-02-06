/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6526.robot;

import org.usfirst.frc.team6526.robot.commands.EjectCargo;
import org.usfirst.frc.team6526.robot.commands.Fire;
import org.usfirst.frc.team6526.robot.commands.LoadCargo;
import org.usfirst.frc.team6526.robot.commands.TiltToCargo;
import org.usfirst.frc.team6526.robot.commands.TiltToPointOne;
import org.usfirst.frc.team6526.robot.commands.TiltToPointThree;
import org.usfirst.frc.team6526.robot.commands.TiltToPointTwo;
import org.usfirst.frc.team6526.robot.subsystems.Catch;
import org.usfirst.frc.team6526.robot.subsystems.DriveTrain;
import org.usfirst.frc.team6526.robot.subsystems.TurretTilt;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {
	
	
	//Subsystems
	public static final DriveTrain drivetrain = new DriveTrain();
	public static final TurretTilt turretTilt = new TurretTilt();
	public static final Catch catchSub = new Catch();
	
	//Misc
	public static OI m_oi;
	
	//SmartDashboard
	
	@Override
	public void robotInit() {
		//MISC (OI ALWAYS in front !!!) 
		m_oi = new OI();
		
		//SmartDashboard
		SmartDashboard.putData(Scheduler.getInstance());
		
		SmartDashboard.putData(this.turretTilt);
		SmartDashboard.putData(drivetrain.ahrs);
		
		//test data 
		SmartDashboard.putData(new Fire());
		SmartDashboard.putData(new TiltToCargo());
		SmartDashboard.putData(new TiltToPointOne());
		SmartDashboard.putData(new TiltToPointTwo());
		SmartDashboard.putData(new TiltToPointThree());
    
		SmartDashboard.putData(new EjectCargo());
		SmartDashboard.putData(new LoadCargo());
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
