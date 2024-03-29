// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.autos.complex.Complex;
import frc.robot.commands.autos.simples.DriveTrainAutoTimeBased;
import frc.robot.commands.autos.simples.IntakeBackwardAuto;
import frc.robot.commands.autos.simples.IntakeForwardAuto;
import frc.robot.commands.autos.simples.ShooterForwardAuto;
import frc.robot.commands.drive.DriveTrainCommand;
import frc.robot.commands.drive.DriveTrainCommandSlower;
import frc.robot.commands.intake.IntakeBackward;
import frc.robot.commands.intake.IntakeForward;
import frc.robot.commands.intake.IntakeStop;
import frc.robot.commands.lift.LiftDown;
import frc.robot.commands.lift.LiftStop;
import frc.robot.commands.lift.LiftUp;
import frc.robot.commands.shooter.ShooterBackward;
import frc.robot.commands.shooter.ShooterForward;
import frc.robot.commands.shooter.ShooterMid;
import frc.robot.commands.shooter.ShooterWeak;
import frc.robot.commands.shooter.ShooterStop;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Lift;
import frc.robot.subsystems.Shooter;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
    
    // The robot's subsystems and commands are defined here... 
    DriveTrain driveTrain = new DriveTrain();
    Shooter Shooter = new Shooter();
    Intake Intake = new Intake();
    Lift Lift = new Lift();
    ArmSubsystem m_robotArm = new ArmSubsystem();

    
    SendableChooser<Command> m_auto_chooser = new SendableChooser<>();

    XboxController driverController, driverPartnerController;
    JoystickButton buttonA, buttonB, buttonX, buttonY, rightBumper, leftBumper, driverRightBumper, driverButtonA, driverButtonB;
    POVButton upPOV, downPOV, leftPOV, rightPOV;
    
    /** The container for the robot. Contains subsystems, OI devices, and commands. */
    public RobotContainer() {
        this.driverController = new XboxController(Constants.Control.ControllerPort.kDRIVER);
        this.driverPartnerController = new XboxController(Constants.Control.ControllerPort.kPARTNER);
        
        this.driverRightBumper = new JoystickButton(driverController, Constants.Control.Button.kRIGHT_BUMPER);
        this.driverButtonA = new JoystickButton(driverController, Constants.Control.Button.kA);
        this.driverButtonB = new JoystickButton(driverController, Constants.Control.Button.kB);
        

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

        SmartDashboard.putData(m_auto_chooser);
        
        // buildShuffleboard();
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
        this.buttonY.onTrue(new ShooterForward(this.Shooter,this.Shooter)).onFalse(new ShooterStop(this.Shooter, this.Shooter));
        this.buttonX.onTrue(new ShooterBackward(this.Shooter, this.Shooter)).onFalse(new ShooterStop(this.Shooter, this.Shooter));
        this.rightBumper.onTrue(new IntakeForward(this.Intake)).onFalse(new IntakeStop(this.Intake));
        this.leftBumper.onTrue(new IntakeBackward(this.Intake)).onFalse(new IntakeStop(this.Intake));
        // this.buttonA.onTrue(new IntakeForwardAuto(this.Intake, 1000, 0.5).andThen(new IntakeBackwardAuto(this.Intake, 1000, 0.5).andThen(new ShooterForwardAuto(this.Shooter, this.Shooter, 1000, 0.5)))).onFalse(new ParallelCommandGroup(new IntakeStop(this.Intake),new ShooterStop(this.Shooter)));
        this.upPOV.onTrue(new LiftUp(this.Lift)).onFalse(new LiftStop(this.Lift));
        this.downPOV.onTrue(new LiftDown(this.Lift)).onFalse(new LiftStop(this.Lift));
        this.buttonA.onTrue(new ShooterWeak(this.Shooter, this.Shooter)).onFalse(new ShooterStop(this.Shooter, this.Shooter));
        this.buttonB.onTrue(new ShooterMid(this.Shooter, this.Shooter)).onFalse(new ShooterStop(this.Shooter, this.Shooter));
        this.driverRightBumper.onTrue(new DriveTrainCommandSlower(this.driveTrain, this.driverController)).onFalse(new DriveTrainCommand(this.driveTrain, this.driverController));
        driverButtonA.onTrue(m_robotArm.setArmGoalCommand(Constants.ArmConstants.kHome));

        // Move the arm to neutral position when the 'B' button is pressed.
        driverButtonB.onTrue(m_robotArm.setArmGoalCommand(Constants.ArmConstants.kSpeaker));
    

    }


    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {
        return new SequentialCommandGroup(
            new ShooterForwardAuto(this.Shooter, this.Shooter, 3000, 0.5 ), 
            new ParallelRaceGroup(new IntakeBackwardAuto(this.Intake, 2000, 0.5), 
            new ShooterStop(this.Shooter, this.Shooter)), 
            new ParallelCommandGroup(new IntakeStop(this.Intake), 
            new DriveTrainAutoTimeBased(this.driveTrain, 1500, 0.5, 0.5))
            );

        // new SequentialCommandGroup(new ShooterForwardAuto(this.Shooter, this.Shooter, 3000, 0.5), new ParallelRaceGroup(new IntakeBackwardAuto(this.Intake, 1000, 0.5), new ShooterStop(this.Shooter, this.Shooter)), new ParallelCommandGroup(new IntakeStop(this.Intake), new DriveTrainAutoTimeBased(this.driveTrain, 1500, 0.5, 0.5)));
    }
    
    // private void buildShuffleboard(){
    //     buildDriverTab();
    // }
    
    // private void buildDriverTab(){
    //     ShuffleboardTab driveTab = Shuffleboard.getTab("Autos");
    //     m_auto_chooser = new SendableChooser<Command>();

    //     m_auto_chooser.setDefaultOption("Drive Past Line", new SequentialCommandGroup(
    //         new DriveTrainAutoTimeBased(this.driveTrain, 1500, 0.5,0.5)));

    //     m_auto_chooser.addOption("test- Side Shooter", 
    //     new SequentialCommandGroup(
    //         new ShooterForwardAuto(this.Shooter, this.Shooter, 1000, 0.5), 
    //         new ParallelRaceGroup(new IntakeBackwardAuto(this.Intake, 400, 0.5), 
    //         new ShooterStop(this.Shooter, this.Shooter)), 
    //         new ParallelCommandGroup(new IntakeStop(this.Intake), 
    //         new DriveTrainAutoTimeBased(this.driveTrain, 1000, 0.5, 0.5))
    //         ));
    //     // new ParallelCommandGroup(
    //      //   new IntakeForwardAuto(this.Intake, 1000, 0.5), 
    //        // new ShooterForwardAuto(this.Shooter, this.Shooter, 1000, 0.5)));

    //     m_auto_chooser.addOption("Only Use This One Unless You Feel Adventurous", 
    //     new SequentialCommandGroup(
    //         new ShooterForwardAuto(this.Shooter, this.Shooter, 3000, 0.6 ), 
    //         new ParallelRaceGroup(new IntakeBackwardAuto(this.Intake, 1000, 0.5), 
    //         new ShooterStop(this.Shooter, this.Shooter)), 
    //         new ParallelCommandGroup(new IntakeStop(this.Intake), 
    //         new DriveTrainAutoTimeBased(this.driveTrain, 1500, 0.5, 0.5))
    //         ));

    //     m_auto_chooser.addOption("Intesting left shoot", 
    //     new SequentialCommandGroup(
    //         new ShooterForwardAuto(this.Shooter, this.Shooter, 3000, 0.6), 
    //         new ParallelRaceGroup(new IntakeBackwardAuto(this.Intake, 1000, 0.5), 
    //         new ShooterStop(this.Shooter, this.Shooter).withTimeout(10),
    //         new WaitCommand(10)),
    //         new ParallelRaceGroup (new DriveTrainAutoTimeBased(this.driveTrain, 1500, 0.5, 0.5).withTimeout(2),
    //         new WaitCommand(2)),
    //         new WaitCommand(0.5), 
    //         new ParallelRaceGroup (new DriveTrainAutoTimeBased(this.driveTrain, 1500, 0, 0.5).withTimeout(2),
    //         new WaitCommand(2)),
    //         new WaitCommand(0.5),
    //         new ParallelCommandGroup(new IntakeStop(this.Intake), 
    //         new DriveTrainAutoTimeBased(this.driveTrain, 1500, 0.5, 0.5))
    //         ));
    
    //     m_auto_chooser.addOption("Center Shoot, Move, Pickup, Move, Shoot", 
    //     new SequentialCommandGroup(
    //         new ParallelCommandGroup(
    //         new IntakeForwardAuto(this.Intake, 1000, 0.5), 
    //         new ShooterForwardAuto(this.Shooter, this.Shooter, 1000, 0.5))
    //         ,
    //         new DriveTrainAutoTimeBased(this.driveTrain, 5000, 0.5, 0.5),
    //         new IntakeForwardAuto(this.Intake, 1000, 0.5), 
    //         new IntakeBackwardAuto(this.Intake, 1000, 0.5), 
    //         new ShooterForwardAuto(this.Shooter, this.Shooter, 1000, 0.5),
    //         new DriveTrainAutoTimeBased(this.driveTrain, 5000, 0.5,0.5),
    //         new ShooterForwardAuto(this.Shooter, this.Shooter, 1000, 0.5)));

    //     m_auto_chooser.addOption("Pickup Sequence", 
    //     new SequentialCommandGroup(
    //         new IntakeForwardAuto(this.Intake, 1000, 0.5), 
    //         new IntakeBackwardAuto(this.Intake, 1000, 0.5), 
    //         new ShooterForwardAuto(this.Shooter, this.Shooter, 1000, 0.5)));
    //     driveTab.add("Autonomous Chooser", m_auto_chooser).withWidget(BuiltInWidgets.kComboBoxChooser).withPosition(0, 0).withSize(2, 1);
    // }

}