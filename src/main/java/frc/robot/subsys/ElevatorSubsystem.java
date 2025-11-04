// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsys;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ElevatorConsts;

public class ElevatorSubsystem extends SubsystemBase {
  
  private final SparkMax ElevatorMaster = 
          new   SparkMax(
                        ElevatorConsts.ELEVATOR_LEFT_MOTOR_ID,
                        MotorType.kBrushless);

  private final SparkMax ElevatorFollower =
          new SparkMax(
                        ElevatorConsts.ELEVATOR_RIGHT_MOTOR_ID,
                        MotorType.kBrushless);

  /** Creates a new ElevatorSubsystem. */
  public ElevatorSubsystem() {}

  public void upElevator() {
    ElevatorMaster.set(
      -ElevatorConsts.ELEVATOR_SPEED
      );
    ElevatorFollower.set(
      -ElevatorConsts.ELEVATOR_SPEED
      );
  }
  public void downElevator() {
    ElevatorMaster.set(
      ElevatorConsts.ELEVATOR_SPEED
      );
    ElevatorFollower.set(
      ElevatorConsts.ELEVATOR_SPEED
      );
  }
  public void holdElevator() {
    ElevatorMaster.set(
      ElevatorConsts.HOLD_ELEVATOR_SPEED
      ); // Hold position
    ElevatorFollower.set(
      ElevatorConsts.HOLD_ELEVATOR_SPEED
      ); // Hold position
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
