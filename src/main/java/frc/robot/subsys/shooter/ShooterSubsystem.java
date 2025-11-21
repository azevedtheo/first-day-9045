// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsys.shooter;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {

  private final     SparkMax      leftShooterMax      =
            new      SparkMax(
                              ShooterConstants.LEFT_SHOOTER_MOTORCONTROLLER_ID,
                              MotorType.kBrushed);

  private final     SparkMax      rightShooterMax     =
            new      SparkMax(
                              ShooterConstants.RIGHT_SHOOTER_MOTORCONTROLLER_ID,
                              MotorType.kBrushed);
                              
  /** Creates a new IntakeSubsystem. */
  public ShooterSubsystem() {}

  public void shootShooter()
  {
    leftShooterMax.set(
      -ShooterConstants.SHOOTER_SPEED
      );

    rightShooterMax.set(
      -ShooterConstants.SHOOTER_SPEED
      );
  }
  public void retractShooter()
  {
    leftShooterMax.set(
      ShooterConstants.SHOOTER_SPEED * 0.3
    );
    rightShooterMax.set(
      ShooterConstants.SHOOTER_SPEED * 0.3
    );
  }
  public void stopShooter()
  {
    leftShooterMax.set(
      0
      );
    rightShooterMax.set(
      0
      );
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
