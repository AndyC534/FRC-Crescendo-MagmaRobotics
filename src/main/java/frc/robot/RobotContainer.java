// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.autos.simples.DriveTrainAuto;
import frc.robot.commands.drive.DriveTrainCommand;
import frc.robot.commands.intake.IntakeBackward;
import frc.robot.commands.intake.IntakeForward;
import frc.robot.commands.intake.IntakeStop;
import frc.robot.commands.shooter.ShooterBackward;
import frc.robot.commands.shooter.ShooterForward;
import frc.robot.commands.shooter.ShooterStop;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
    
    // The robot's subsystems and commands are defined here... 
    DriveTrain driveTrain;
    Shooter Shooter;
    Intake Intake;
    private SendableChooser<Command> m_auto_chooser;


    XboxController driverController, driverPartnerController;
    JoystickButton buttonA, buttonB, buttonX, buttonY, rightBumper, leftBumper, driverRightBumper;
    POVButton upPOV, downPOV, leftPOV, rightPOV;
    
    /** The container for the robot. Contains subsystems, OI devices, and commands. */
    public RobotContainer() {
        this.driveTrain = new DriveTrain();
        this.Shooter = new Shooter();
        this.Intake = new Intake();

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

        buildShuffleboard();
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
        this.upPOV.onTrue(new ShooterForward(this.Shooter, this.Shooter)).onFalse(new ShooterStop(this.Shooter));
        this.downPOV.onTrue(new ShooterBackward(this.Shooter, this.Shooter)).onFalse(new ShooterStop(this.Shooter));
        this.rightPOV.onTrue(new IntakeForward(this.Intake)).onFalse(new IntakeStop(this.Intake));
        this.leftPOV.onTrue(new IntakeBackward(this.Intake)).onFalse(new IntakeStop(this.Intake));
    }


    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {
        return m_auto_chooser.getSelected();        
    }

    private void buildShuffleboard(){
        buildDriverTab();
    }
    
    private void buildDriverTab(){
        ShuffleboardTab driveTab = Shuffleboard.getTab("Drive");
        m_auto_chooser = new SendableChooser<Command>();
        m_auto_chooser.setDefaultOption("Drive 0.5", new SequentialCommandGroup(new DriveTrainAuto(this.driveTrain, 10000, 0.5, 0.5)));
        m_auto_chooser.setDefaultOption("Drive 1", new DriveTrainAuto(this.driveTrain, 10000, 1, 1));
        driveTab.add("Autonomous Chooser", m_auto_chooser).withWidget(BuiltInWidgets.kComboBoxChooser).withPosition(0, 0).withSize(2, 1);
    }

}