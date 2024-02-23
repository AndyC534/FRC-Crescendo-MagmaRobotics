// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Shooter extends SubsystemBase {


    /**
     * an abstract representation of a physical robot arm
     */
    private CANSparkMax ShooterMotor1, ShooterMotor2;

  
    /**
     * subsystem base object for arm
     */
    public Shooter() {
        this.ShooterMotor1 = new CANSparkMax(10, MotorType.kBrushless);
        this.ShooterMotor2 = new CANSparkMax(11, MotorType.kBrushless);
        
    }


    /**
     * arm goes up by setting power on the arm motor
     */
    public void ShooterMotor1Forward() {
        this.ShooterMotor1.set(Constants.Subsystems.kPOWER);
    }

    /**
     * arm goes down by setting power on the arm motor
     */
    public void ShooterMotor1Backward() {
        this.ShooterMotor1.set(-Constants.Subsystems.kPOWER);
    }


    /**
     * calls stopMotor method within {@link edu.wpi.first.wpilibj.drive.DifferentialDrive}
     * to stop motors
     */
    public void ShooterMotor1Stop() {
        this.ShooterMotor1.stopMotor();
    }


    /**
     * second arm goes up by setting power on the arm motor
     */
    public void ShooterMotor2Forward() {
        this.ShooterMotor2.set(Constants.Subsystems.kPOWER);
    }


     /**
     * second arm goes down by setting power on the arm motor
     */
    public void ShooterMotor2Backward() {
        this.ShooterMotor2.set(-Constants.Subsystems.kPOWER);
    }


    /**
     * calls stopMotor method within {@link edu.wpi.first.wpilibj.drive.DifferentialDrive}
     * to stop second motors
     */
    public void ShooterMotor2Stop() {
        this.ShooterMotor2.stopMotor();
    }

    public void ShooterMotor1ForwardAuto(double power) {
        this.ShooterMotor1.set(power);
    }

    public void ShooterMotor1BackwardAuto(double power) {
        this.ShooterMotor1.set(-power);
    }

    public void ShooterMotor2ForwardAuto(double power) {
        this.ShooterMotor2.set(power);
    }

    public void ShooterMotor2BackwardAuto(double power) {
        this.ShooterMotor2.set(-power);
    }


    /**
     * calls stopMotor method within {@link edu.wpi.first.wpilibj.drive.DifferentialDrive}
     * to stop second motors
     */


    public void ShooterStopAll() {
        this.ShooterMotor1.stopMotor();
        this.ShooterMotor2.stopMotor();
    }
}