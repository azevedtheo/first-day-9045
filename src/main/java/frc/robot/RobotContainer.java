// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.Constants.OIConsts;
import frc.robot.commands.ElevatorCommand;
import frc.robot.commands.ShooterCommand;
import frc.robot.subsys.ElevatorSubsystem;
import frc.robot.subsys.ShooterSubsystem;


public class RobotContainer 
{
  private final ElevatorSubsystem elevatorSubsystem =
          new ElevatorSubsystem();
  private final ShooterSubsystem intakeSubsystem =
          new ShooterSubsystem();

  private final Joystick mainController =
          new Joystick(
                        OIConsts.MAIN_CONTROLLER_PORT
                      );
 
  private final ShooterCommand IntakeCommand =
          new ShooterCommand(
                            intakeSubsystem,
                            mainController
                            );

  private final ElevatorCommand elevatorCommand =
          new ElevatorCommand(
                              elevatorSubsystem,
                              mainController
                            );

  public RobotContainer() 
  {
    configureBindings();
  }

  private void configureBindings() 
  {
    intakeSubsystem.setDefaultCommand(
                                      IntakeCommand
                                      );

    elevatorSubsystem.setDefaultCommand(
                                        elevatorCommand
                                        );
  }

  public Command getAutonomousCommand() 
  {
    return Commands
                  .print(
                    "No autonomous command configured"
                        );
  }
}
