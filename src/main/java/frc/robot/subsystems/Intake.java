// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Intake extends SubsystemBase {


    /**
     * an abstract representation of a physical robot arm
     */
    private CANSparkMax Intake;

  
    /**
     * subsystem base object for arm
     */
    public Intake() {
        this.Intake = new CANSparkMax(10, MotorType.kBrushless);
        this.Intake.restoreFactoryDefaults();
        this.Intake.burnFlash();
        
    }


    /**
     * arm goes up by setting power on the arm motor
     */
    public void IntakeForward() {
        this.Intake.set(Constants.Subsystems.Intake.kPOWER);
    }


     /**
     * second arm goes down by setting power on the arm motor
     */
    public void IntakeBackward() {
        this.Intake.set(-Constants.Subsystems.Intake.kPOWER);
    }


    /**
     * calls stopMotor method within {@link edu.wpi.first.wpilibj.drive.DifferentialDrive}
     * to stop second motors
     */
    public void IntakeStop() {
        this.Intake.set(0);
    }

    public void IntakeForwardAuto(double power) {
        this.Intake.set(power);
    }


     /**
     * second arm goes down by setting power on the arm motor
     */
    public void IntakeBackwardAuto(double power) {
        this.Intake.set(-power);
    }
  
}