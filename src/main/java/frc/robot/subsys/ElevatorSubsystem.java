// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsys;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ElevatorConsts;

public class ElevatorSubsystem extends SubsystemBase {
  private final SparkMax ElevatorLeft =  new SparkMax(ElevatorConsts.ELEVATOR_LEFT_MOTOR_ID, MotorType.kBrushless);
  private final SparkMax ElevatorRight = new SparkMax(ElevatorConsts.ELEVATOR_RIGHT_MOTOR_ID, MotorType.kBrushless);
  /** Creates a new ElevatorSubsystem. */
  public ElevatorSubsystem() {}

  public void upElevator() {
    ElevatorLeft.set(-ElevatorConsts.ELEVATOR_SPEED);
    ElevatorRight.set(-ElevatorConsts.ELEVATOR_SPEED);
  }
  public void downElevator() {
    ElevatorLeft.set(ElevatorConsts.ELEVATOR_SPEED);
    ElevatorRight.set(ElevatorConsts.ELEVATOR_SPEED);
  }
  public void holdElevator() {
    ElevatorLeft.set(-0.01); // Hold position
    ElevatorRight.set(-0.01); // Hold position
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
