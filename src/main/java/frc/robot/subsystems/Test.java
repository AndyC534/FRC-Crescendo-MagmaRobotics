// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Test extends SubsystemBase {


    /**
     * an abstract representation of a physical robot arm
     */
    private CANSparkMax testMotor1, testMotor2;

  
    /**
     * subsystem base object for arm
     */
    public Test() {
        this.testMotor1 = new CANSparkMax(56, MotorType.kBrushless);
        this.testMotor2 = new CANSparkMax(42, MotorType.kBrushless);
        
    }


    /**
     * arm goes up by setting power on the arm motor
     */
    public void testMotor1Forward() {
        this.testMotor1.set(Constants.Subsystems.kPOWER);
    }

    /**
     * arm goes down by setting power on the arm motor
     */
    public void testMotor1Backward() {
        this.testMotor1.set(-Constants.Subsystems.kPOWER);
    }


    /**
     * calls stopMotor method within {@link edu.wpi.first.wpilibj.drive.DifferentialDrive}
     * to stop motors
     */
    public void testMotor1Stop() {
        this.testMotor1.stopMotor();
    }


    /**
     * second arm goes up by setting power on the arm motor
     */
    public void testMotor2Forward() {
        this.testMotor2.set(Constants.Subsystems.kPOWER);
    }


     /**
     * second arm goes down by setting power on the arm motor
     */
    public void testMotor2Backward() {
        this.testMotor2.set(-Constants.Subsystems.kPOWER);
    }


    /**
     * calls stopMotor method within {@link edu.wpi.first.wpilibj.drive.DifferentialDrive}
     * to stop second motors
     */
    public void testMotor2Stop() {
        this.testMotor2.stopMotor();
    }

    public void stopAll(){
        this.testMotor2.stopMotor();
        this.testMotor1.stopMotor();
    }

  
}