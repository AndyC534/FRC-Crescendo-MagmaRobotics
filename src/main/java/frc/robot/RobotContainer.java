// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.testMotor3Backward;
import frc.robot.commands.testMotor3Forward;
import frc.robot.commands.testMotor3Stop;
import frc.robot.commands.testMotorsBackward;
import frc.robot.commands.testMotorsForward;
import frc.robot.commands.testMotorsStop;
import frc.robot.commands.drive.DriveTrainCommand;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Test;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
    
    // The robot's subsystems and commands are defined here... 
    DriveTrain driveTrain;
    Test Test;

    XboxController driverController, driverPartnerController;
    JoystickButton buttonA, buttonB, buttonX, buttonY, rightBumper, leftBumper, driverRightBumper;
    POVButton upPOV, downPOV, leftPOV, rightPOV;
    
    /** The container for the robot. Contains subsystems, OI devices, and commands. */
    public RobotContainer() {
        this.driveTrain = new DriveTrain();
        this.Test = new Test();

        this.driverController = new XboxController(Constants.Control.ControllerPort.kDRIVER);
        this.driverPartnerController = new XboxController(Constants.Control.ControllerPort.kPARTNER);
        
        this.driverRightBumper = new JoystickButton(driverController, Constants.Control.Button.kRIGHT_BUMPER);

        this.buttonA = new JoystickButton(driverPartnerController, Constants.Control.Button.kA);
        this.buttonB = new JoystickButton(driverPartnerController, Constants.Control.Button.kB);
        this.buttonX = new JoystickButton(driverPartnerController, Constants.Control.Button.kX);
        this.buttonY = new JoystickButton(driverPartnerController, Constants.Control.Button.kY);
        this.rightBumper = new JoystickButton(driverPartnerController, Constants.Control.Button.kRIGHT_BUMPER);
        this.leftBumper = new JoystickButton(driverPartnerController, Constants.Control.Button.kLEFT_BUMPER);
        this.upPOV = new POVButton(driverPartnerController, Constants.Control.POVButton.kUP);
        this.downPOV = new POVButton(driverPartnerController, Constants.Control.POVButton.kDOWN);
        this.leftPOV = new POVButton(driverPartnerController, Constants.Control.POVButton.kLEFT);
        this.rightPOV = new POVButton(driverPartnerController, Constants.Control.POVButton.kRIGHT);
        
        this.driveTrain.setDefaultCommand(new DriveTrainCommand(this.driveTrain, this.driverController));

        
        // Configure the trigger bindings
        this.configureBindings();
    }


    /**
     * Use this method to define your trigger->command mappings. Triggers can be created via the
     * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
     * predicate, or via the named factories in {@link
     * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
     * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
     * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
     * joysticks}.
     */
    private void configureBindings() {
        // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
        this.upPOV.onTrue(new testMotorsForward(this.Test, this.Test)).onFalse(new testMotorsStop(this.Test, this.Test));
        this.downPOV.onTrue(new testMotorsBackward(this.Test, this.Test)).onFalse(new testMotorsStop(this.Test, this.Test));
        this.rightPOV.onTrue(new testMotor3Backward(this.Test)).onFalse(new testMotor3Stop(this.Test));
        this.rightPOV.onTrue(new testMotor3Forward(this.Test)).onFalse(new testMotor3Stop(this.Test));
    }


    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {
        return null;
        
        //Just edit the times and power
      }


}