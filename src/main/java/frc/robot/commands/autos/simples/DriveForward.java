package frc.robot.commands.autos.simples;


import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveTrain;


public class DriveForward extends Command {
    private DriveTrain driveTrain;
    private double distanceMultiplier, endDistance, botSpeed;


    public DriveForward(DriveTrain driveTrain, double distanceMultiplier, double botSpeed) {
        this.distanceMultiplier = distanceMultiplier;
        this.driveTrain = driveTrain;
        this.botSpeed = botSpeed;
        addRequirements(driveTrain);
    }


    @Override
    public void initialize() {
      endDistance = .295;
      driveTrain.resetEncoders();
    }
    @Override
    public void execute() {
      driveTrain.diffDrive(botSpeed, botSpeed);
      SmartDashboard.putNumber("Left Encoder Pos", driveTrain.getLeftEncoderPos());
    }


    @Override
    public boolean isFinished() {
      if (botSpeed > 0) {
        return (driveTrain.getLeftEncoderPos() >= endDistance *distanceMultiplier);
      }
      else {
        return (driveTrain.getLeftEncoderPos() <= -endDistance *distanceMultiplier);
      }
    }


    @Override
    public void end(boolean interrupted) {
        driveTrain.stop();
    }
}