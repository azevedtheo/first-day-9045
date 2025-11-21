// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.elevator;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.OIConsts;
import frc.robot.subsys.elevator.ElevatorSubsystem;

public class ElevatorCommand extends Command {

  private final ElevatorSubsystem elevator;
  private final Joystick controller;

  /** Creates a new ElevatorCommand. */
  public ElevatorCommand(ElevatorSubsystem subsystem, Joystick joystick) {
    this.elevator = subsystem;
    this.controller = joystick;
    addRequirements(elevator);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    double    elevatorMoveUP  =
              controller.getRawAxis(
                                    OIConsts.RIGHT_TRIGGER_R2
                                    ); // Invert Y axis for up

    double    elevatorMoveDOWN =
              controller.getRawAxis(
                                    OIConsts.LEFT_TRIGGER_L2
                                   );

    if (elevatorMoveUP > 0.3) elevator.upElevator();
    if (elevatorMoveDOWN > 0.3) elevator.downElevator();
    if (elevatorMoveUP < 0.29 && elevatorMoveDOWN < 0.29) elevator.holdElevator();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted)
  {
    elevator.holdElevator();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}