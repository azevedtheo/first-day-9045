// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsys;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConsts;

public class IntakeSubsystem extends SubsystemBase {
  private final SparkMax leftIntakeMotor = new SparkMax(IntakeConsts.LEFT_INTAKE_MOTOR_ID, MotorType.kBrushless);
  private final SparkMax rightIntakeMotor = new SparkMax(IntakeConsts.RIGHT_INTAKE_MOTOR_ID, MotorType.kBrushless);
  /** Creates a new IntakeSubsystem. */
  public IntakeSubsystem() {}

  public void intake() {
    leftIntakeMotor.set(-IntakeConsts.INTAKE_SPEED);// Invert left motor
    rightIntakeMotor.set(-IntakeConsts.INTAKE_SPEED);
  }
  public void outtake() {
    leftIntakeMotor.set(IntakeConsts.INTAKE_SPEED);
    rightIntakeMotor.set(IntakeConsts.INTAKE_SPEED); // Invert right motor
  }
  public void stopIntake() {
    leftIntakeMotor.set(0);
    rightIntakeMotor.set(0);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
