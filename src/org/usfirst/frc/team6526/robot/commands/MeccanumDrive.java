/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6526.robot.commands;

import org.usfirst.frc.team6526.robot.Robot;
import org.usfirst.frc.team6526.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.command.Command;

public class MeccanumDrive extends Command {
  public MeccanumDrive() {
   requires(Robot.drivetrain);
  }
  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    Robot.drivetrain.mecannumDrive(Robot.m_oi.leftX(), Robot.m_oi.leftY(), Robot.m_oi.rightX());
  }
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
