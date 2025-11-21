// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsys.elevator;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ElevatorSubsystem extends SubsystemBase {
  
  private final SparkMax ElevatorMaster   = new   SparkMax(
                                                          ElevatorConstants.ELEVATOR_LEFT_MOTOR_ID,
                                                          MotorType.kBrushless);

  private final SparkMax ElevatorFollower = new SparkMax(
                                                        ElevatorConstants.ELEVATOR_RIGHT_MOTOR_ID,
                                                        MotorType.kBrushless);


  /** Creates a new ElevatorSubsystem. */
  public ElevatorSubsystem() {}

  public void upElevator()
  {
    ElevatorMaster.set(-ElevatorConstants.ELEVATOR_SPEED);
    ElevatorFollower.set(-ElevatorConstants.ELEVATOR_SPEED);
  }
  public void downElevator()
  {
    ElevatorMaster.set(ElevatorConstants.ELEVATOR_SPEED);
    ElevatorFollower.set(ElevatorConstants.ELEVATOR_SPEED);
  }
  public void holdElevator()
  {
    ElevatorMaster.set(ElevatorConstants.HOLD_ELEVATOR_SPEED); // Hold position
    ElevatorFollower.set(ElevatorConstants.HOLD_ELEVATOR_SPEED); // Hold position
  }
  @Override
  public void periodic() {}
}
