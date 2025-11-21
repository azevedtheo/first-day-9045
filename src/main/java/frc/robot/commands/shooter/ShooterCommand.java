// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.OIConsts;
import frc.robot.subsys.shooter.ShooterSubsystem;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class ShooterCommand extends Command {
  
  private final ShooterSubsystem shooterSub;
  private final Joystick controller;
  
  public ShooterCommand(ShooterSubsystem subsystem, Joystick joystick) {
    this.shooterSub = subsystem;
    this.controller = joystick;
    addRequirements(shooterSub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    boolean shootShooterButton   =  controller.getRawButton(
                                                            OIConsts.RIGHT_BUMPER_R1
                                                            );
    boolean retractShooterButton =  controller.getRawButton(
                                                            OIConsts.LEFT_BUMPER_L1
                                                            );
    
    if (shootShooterButton) shooterSub.shootShooter();
    if (retractShooterButton) shooterSub.retractShooter();
    if (!shootShooterButton && !retractShooterButton) shooterSub.stopShooter();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooterSub.stopShooter();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
