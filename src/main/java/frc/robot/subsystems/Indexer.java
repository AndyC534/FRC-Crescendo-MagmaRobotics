// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Indexer extends SubsystemBase {


    /**
     * an abstract representation of a physical robot arm
     */
    private CANSparkMax Indexer;


  
    /**
     * subsystem base object for arm
     */
    public Indexer() {
        this.Indexer = new CANSparkMax(9, MotorType.kBrushless);
        this.Indexer.burnFlash();
        this.Indexer.restoreFactoryDefaults();
    

        
    }

    /**
     * arm goes up by setting power on the arm motor
     */
    public void IntakeForward() {
        this.Indexer.set(Constants.Subsystems.Indexer.kPOWER);
    }


     /**
     * second arm goes down by setting power on the arm motor
     */
    public void IntakeBackward() {
        this.Indexer.set(-Constants.Subsystems.Indexer.kPOWER);
    }


    /**
     * calls stopMotor method within {@link edu.wpi.first.wpilibj.drive.DifferentialDrive}
     * to stop second motors
     */
    public void IndexerStop() {
        this.Indexer.stopMotor();
    }

    public void IndexerForwardAuto(double power) {
        this.Indexer.set(power);
    }


     /**
     * second arm goes down by setting power on the arm motor
     */
    public void IndexerBackwardAuto(double power) {
        this.Indexer.set(-power);
    }
  
}