package frc.robot.commands.drive;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveTrain;


public class LimeLightDriveTrainCommandTEST extends Command {


    /**
     * an instance of {@link frc.robot.subsystems.DriveTrain}
     */
    private final DriveTrain driveTrain;


    /**
     * @param driveTrain an instance of {@link frc.robot.subsystems.DriveTrain}
     * @param driveController an instance of {@link edu.wpi.first.wpilibj.XboxController}
     */
    public LimeLightDriveTrainCommandTEST(DriveTrain driveTrain){
        this.driveTrain = driveTrain;
        addRequirements(driveTrain);
    }
    
    @Override
    public void initialize() {
    }


    /**
     * method that's being executed in a loop;
     * change the method being called in {@link frc.robot.subsystems.DriveTrain} to accommodate 
     * different driving styles
     */
    @Override

    public void execute() {
        double tx = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);
        double ta = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ta").getDouble(0);
        if (ta > 0){
            if(tx > 0){
                this.driveTrain.diffDrive(0.5, 0);
            }
            if(tx < 0){
                this.driveTrain.diffDrive(0, 0.5);
            }
        }
        if (ta > 25){
            if(tx > 0){
                this.driveTrain.diffDrive(0.5, 0);
            }
            if(tx < 0){
                this.driveTrain.diffDrive(0, 0.5);
            }

        }
        if (ta > 50){
            if(tx > 0){
                this.driveTrain.diffDrive(0.5, 0);
            }
            if(tx < 0){
                this.driveTrain.diffDrive(0, 0.5);
            }
        }
        if (ta > 75){
            if(tx > 0){
                this.driveTrain.diffDrive(0.5, 0);
            }
            if(tx < 0){
                this.driveTrain.diffDrive(0, 0.5);
            }
        }
    }
    


    @Override
    public void end(boolean interrupted) {
    }


    @Override
    public boolean isFinished() {
        return false;
    }


}