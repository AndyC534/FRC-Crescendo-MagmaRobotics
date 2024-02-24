// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.autos.complex;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.autos.simples.DriveTrainAutoTimeBased;
import frc.robot.commands.autos.simples.IntakeForwardAuto;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;

/** A complex auto command that drives forward, releases a hatch, and then drives backward. */
public class Complex extends SequentialCommandGroup {
  /**
   * Creates a new ComplexAuto.
   *
   * @param drive The drive subsystem this command will run on
   * @param hatch The hatch subsystem this command will run on
   */
  public Complex(Intake intake) {
    addCommands(
        // Drive forward the specified distance
        new IntakeForwardAuto(intake, 1000, 0.5));
  }
}