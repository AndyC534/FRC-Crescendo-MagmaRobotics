// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import java.lang.Math;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkLowLevel.MotorType;

public class DriveTrain extends SubsystemBase {


    /**
     * an abstract representation of a physical drive motor
     */

    private CANSparkMax frontLeftDriveMotor;
    private CANSparkMax rearLeftDriveMotor;
    private CANSparkMax frontRightDriveMotor;
    private CANSparkMax rearRightDriveMotor;
    
    private RelativeEncoder frontLeftDriveMotorEncoder;
    private RelativeEncoder frontRightDriveMotorEncoder;

    private SparkPIDController frontLeftDriveMotorPIDController;
    private SparkPIDController frontRightDriveMotorPIDController;

    private DifferentialDrive diffDrive;


    public DriveTrain() {

        this.frontLeftDriveMotor = new CANSparkMax(1, MotorType.kBrushless);
        this.rearLeftDriveMotor = new CANSparkMax(2, MotorType.kBrushless);
        this.frontRightDriveMotor = new CANSparkMax(3, MotorType.kBrushless);
        this.rearRightDriveMotor = new CANSparkMax(4, MotorType.kBrushless);


        this.frontLeftDriveMotor.restoreFactoryDefaults();
        this.rearLeftDriveMotor.restoreFactoryDefaults();
        this.frontRightDriveMotor.restoreFactoryDefaults();
        this.rearRightDriveMotor.restoreFactoryDefaults();

        rearRightDriveMotor.follow(frontRightDriveMotor);
        rearLeftDriveMotor.follow(frontLeftDriveMotor);
    
        frontLeftDriveMotorEncoder = frontLeftDriveMotor.getEncoder();
        frontRightDriveMotorEncoder = frontRightDriveMotor.getEncoder();

        frontLeftDriveMotorPIDController = frontLeftDriveMotor.getPIDController();
        frontRightDriveMotorPIDController = frontRightDriveMotor.getPIDController();

        frontLeftDriveMotorEncoder.setPositionConversionFactor(.039);
        frontRightDriveMotorEncoder.setPositionConversionFactor(.039);

        this.frontLeftDriveMotor.burnFlash();
        this.rearLeftDriveMotor.burnFlash();
        this.frontRightDriveMotor.burnFlash();
        this.rearRightDriveMotor.burnFlash();
    
        this.diffDrive = new DifferentialDrive(this.frontLeftDriveMotor, this.frontRightDriveMotor);


    }

    /**
     * scales value ranging from -1 to 1 to 0 to 1
     * @param rawValue raw value from joystick; ranging from -1 to 1
     * @return scaled value; ranging from 0 to 1
     */
    public double adjustedSpeed(double rawValue){
        if (-rawValue <= 0) {
            return 0.5 - (Math.abs(-rawValue) / 2);
        } 
        return (-rawValue / 2) + 0.5;
    }


    /**
     * calls arcadeDrive method within {@link edu.wpi.first.wpilibj.drive.DifferentialDrive}
     * to enable arcade drive with the joystick controller
     * @param position raw values of joystick used to control forward and backward movement
     * @param angle raw values of joystick used to control heading movement
     * @param speed raw values of slider used to control the speed of heading movement
     */
    public void arcadeDriveWithJoystick(double position, double angle, double speed) {
        this.diffDrive.arcadeDrive(-position, -angle * this.adjustedSpeed(speed));
    }


    /**
     * calls arcadeDrive method within {@link edu.wpi.first.wpilibj.drive.DifferentialDrive}
     * to enable arcade drive with the Xbox controller
     * @param position raw values of joystick used to control forward and backward movement
     * @param angle raw values of joystick used to control heading movement
     */
    public void arcadeDriveWithXbox(double position, double angle) {
        this.diffDrive.arcadeDrive(position, angle);
    }


    /**
     * calls diffDrive method within {@link edu.wpi.first.wpilibj.drive.DifferentialDrive}
     * to enable differential drive with the Xbox controller
     * @param leftJoystick raw values of the left joystick
     * @param rightJoystick raw values of the right joystick
     */
    public void diffDrive(double leftJoystick, double rightJoystick) {
        this.diffDrive.tankDrive(leftJoystick, -rightJoystick);
    }
    public void resetEncoders(){
        frontLeftDriveMotorEncoder.setPosition(0);
        frontRightDriveMotorEncoder.setPosition(0);
    }
      
    
    public double getLeftEncoderPos() {
        return frontLeftDriveMotorEncoder.getPosition();
    }
      
    public double getRightEncoderPos() {
        return frontRightDriveMotorEncoder.getPosition();
    }
    
    public void stop() {
        frontLeftDriveMotor.stopMotor();
        rearLeftDriveMotor.stopMotor();
        frontRightDriveMotor.stopMotor();
        rearRightDriveMotor.stopMotor();    
    }

    

}