// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.Constants.DriveConsts;
import frc.robot.Constants.OIConsts;

public class Robot extends TimedRobot {
  private final     WPI_VictorSPX     frontLeftMotor      =new     WPI_VictorSPX(DriveConsts.FRONT_LEFT_MOTOR_ID);
  private final     WPI_VictorSPX     frontRightMotor     =new     WPI_VictorSPX(DriveConsts.FRONT_RIGHT_MOTOR_ID);
  private final     WPI_VictorSPX     backLeftMotor       =new     WPI_VictorSPX(DriveConsts.BACK_LEFT_MOTOR_ID);
  private final     WPI_VictorSPX     backRightMotor      =new     WPI_VictorSPX(DriveConsts.BACK_RIGHT_MOTOR_ID);;

  Joystick      controller      =new      Joystick(OIConsts.MAIN_CONTROLLER_PORT);
  
  private Command m_autonomousCommand;

  private final RobotContainer m_robotContainer;

  public Robot() {
    m_robotContainer = new RobotContainer();
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void disabledExit() {}

  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void autonomousExit() {}

  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }

    frontLeftMotor.set(0);      backLeftMotor.set(0);     frontRightMotor.set(0);     backRightMotor.set(0);
  }

  @Override
  public void teleopPeriodic()
  {
    double speedDriveTrain = MathUtil.clamp(
                                            MathUtil.applyDeadband(
                                              -controller.getRawAxis(OIConsts.LEFT_Y_AXIS), OIConsts.DEADBAND),
                                              -DriveConsts.MAX_SPEED, DriveConsts.MAX_SPEED);

    double turnDriveTrain = MathUtil.clamp(
                                            MathUtil.applyDeadband(
                                              controller.getRawAxis(OIConsts.RIGHT_X_AXIS),  OIConsts.DEADBAND),
                                              -DriveConsts.MAX_SPEED * 0.6, DriveConsts.MAX_SPEED * 0.6);

    double leftSpeed = speedDriveTrain + turnDriveTrain;
    double rightSpeed = speedDriveTrain - turnDriveTrain; 
    
    frontLeftMotor.set(leftSpeed);      frontRightMotor.set(leftSpeed);     backLeftMotor.set(-rightSpeed);     backRightMotor.set(-rightSpeed);
  }

  public void stop() {
    frontLeftMotor.set(0);      backLeftMotor.set(0);     frontRightMotor.set(0);     backRightMotor.set(0);
  }

  @Override
  public void teleopExit() {}

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {}

  @Override
  public void testExit() {}
}
