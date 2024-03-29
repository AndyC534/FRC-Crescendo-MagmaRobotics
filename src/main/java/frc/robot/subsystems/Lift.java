// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Lift extends SubsystemBase {


    /**
     * an abstract representation of a physical robot arm
     */
    private CANSparkMax Lift;


  
    /**
     * subsystem base object for arm
     */
    public Lift() {
        this.Lift = new CANSparkMax(9, MotorType.kBrushless);
        this.Lift.burnFlash();
        this.Lift.restoreFactoryDefaults();
    

        
    }

    /**
     * arm goes up by setting power on the arm motor
     */
    public void LiftUp() {
        this.Lift.set(Constants.Subsystems.Lift.kPOWER);
    }


     /**
     * second arm goes down by setting power on the arm motor
     */
    public void LiftDown() {
        this.Lift.set(-Constants.Subsystems.Lift.kPOWER);
    }


    /**
     * calls stopMotor method within {@link edu.wpi.first.wpilibj.drive.DifferentialDrive}
     * to stop second motors
     */
    public void LiftStop() {
        this.Lift.stopMotor();
    }

    public void LiftUpAuto(double power) {
        this.Lift.set(power);
    }


     /**
     * second arm goes down by setting power on the arm motor
     */
    public void LiftDownAuto(double power) {
        this.Lift.set(-power);
    }
  
}