// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of project.

package frc.robot.commands.autos.complex;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.autos.simples.IntakeBackwardAuto;
import frc.robot.commands.autos.simples.IntakeForwardAuto;
import frc.robot.commands.autos.simples.ShooterForwardAuto;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

/** A complex auto command that drives forward, releases a hatch, and then drives backward. */
public class Sequence extends SequentialCommandGroup {
  /**
   * Creates a new ComplexAuto.
   *
   * @param drive The drive subsystem command will run on
   * @param hatch The hatch subsystem command will run on
   */
  public Sequence(Intake Intake, Shooter Shooter) {
    addCommands(
            new IntakeForwardAuto(Intake, 1000, 0.5), 
            new IntakeBackwardAuto(Intake, 1000, 0.5), 
            new ShooterForwardAuto(Shooter, Shooter, 1000, 0.5));
}
}