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
  private final WPI_VictorSPX frontLeftMotor = new WPI_VictorSPX(1);
  private final WPI_VictorSPX frontRightMotor = new WPI_VictorSPX(2);
  private final WPI_VictorSPX backLeftMotor = new WPI_VictorSPX(3);
  private final WPI_VictorSPX backRightMotor = new WPI_VictorSPX(4);

  private final double maxSpeed = DriveConsts.MAX_SPEED;

  Joystick controller = new Joystick(OIConsts.MAIN_CONTROLLER_PORT);
  
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

    frontLeftMotor.set(0);
    backLeftMotor.set(0);
    frontRightMotor.set(0);
    backRightMotor.set(0);
  }

  @Override
  public void teleopPeriodic() {
    double speed = MathUtil.clamp(-controller.getRawAxis(1), maxSpeed * -1, maxSpeed);
    double turn = MathUtil.clamp(controller.getRawAxis(4), maxSpeed * -1, maxSpeed);

    double left = speed + turn;
    double right = speed - turn; 
    

    frontLeftMotor.set(left);
    frontRightMotor.set(left);
    backLeftMotor.set(-right);
    backRightMotor.set(-right);
  }

  public void stop() {
    frontLeftMotor.set(0);
    backLeftMotor.set(0);
    frontRightMotor.set(0);
    backRightMotor.set(0);
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
