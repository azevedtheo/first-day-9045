// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.OIConsts;
import frc.robot.subsys.IntakeSubsystem;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class IntakeCommand extends Command {
  private final IntakeSubsystem intakeSub;
  private final Joystick controller;
  
  public IntakeCommand(IntakeSubsystem subsystem, Joystick joystick) {
    this.intakeSub = subsystem;
    this.controller = joystick;
    addRequirements(intakeSub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    boolean takeIn = controller.getRawButton(OIConsts.LEFT_BUMPER_L1); // Button A for intake
    boolean takeOut = controller.getRawButton(OIConsts.RIGHT_BUMPER_R1); // Button B for outtake
    
    if ((takeIn && takeOut) || (!takeIn && !takeOut)) intakeSub.stopIntake();
    if (takeIn && !takeOut) intakeSub.outtake();
    if (!takeIn && takeOut) intakeSub.intake();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intakeSub.stopIntake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
