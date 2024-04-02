package frc.robot.commands.autos.simples;


import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveTrain;


public class Rotate270 extends Command {
    private DriveTrain driveTrain;
    private double botSpeed;
    private double endDegrees;


    public Rotate270(DriveTrain driveTrain, double botSpeed) {
        this.botSpeed = botSpeed;
        this.driveTrain = driveTrain;
        addRequirements(driveTrain);
    }


    @Override
    public void initialize() {
      endDegrees = -0.5;
      driveTrain.resetEncoders();
    }
    @Override
    public void execute() {
      driveTrain.diffDrive(-botSpeed, botSpeed);
      SmartDashboard.putNumber("Left Encoder Pos", driveTrain.getLeftEncoderPos());
    }


    @Override
    public boolean isFinished() {
      if (botSpeed > 0) {
        return (driveTrain.getLeftEncoderPos() <= endDegrees);
      }
      else {
        return (driveTrain.getLeftEncoderPos() >= -endDegrees);
      }
    }


    @Override
    public void end(boolean interrupted) {
        driveTrain.stop();
    }
}