package frc.robot.commands.drive;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveTrain;


public class DriveTrainCommandSlower extends Command {


    /**
     * an instance of {@link frc.robot.subsystems.DriveTrain}
     */
    private final DriveTrain driveTrain;
    private final XboxController driveController;


    /**
     * @param driveTrain an instance of {@link frc.robot.subsystems.DriveTrain}
     * @param driveController an instance of {@link edu.wpi.first.wpilibj.XboxController}
     */
    public DriveTrainCommandSlower(DriveTrain driveTrain, XboxController driveController){
        this.driveTrain = driveTrain;
        this.driveController = driveController;
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
        this.driveTrain.diffDrive(
            this.driveController.getRightY()*.5, 
            this.driveController.getLeftY()*.5);     
    }
    


    @Override
    public void end(boolean interrupted) {
    }


    @Override
    public boolean isFinished() {
        return false;
    }


}