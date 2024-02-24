package frc.robot.commands.autos.simples;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveTrain;


public class DriveTrainAutoTimeBased extends Command {


    private double leftpower, rightpower, duration;
    private DriveTrain driveTrain;


    public DriveTrainAutoTimeBased(DriveTrain driveTrain, double duration, double leftpower, double rightpower) {
        this.driveTrain = driveTrain;
        this.duration = duration;
        this.leftpower = leftpower;
        this.rightpower = rightpower;
        addRequirements(driveTrain);
    }


    // called just before this Command runs the first time
    // calculates when to end Command
    public void initialize() {
        double currentTime = System.currentTimeMillis();
        this.duration = (currentTime + this.duration);
    }


    // called repeatedly when this Command is scheduled to run
    public void execute() {
        this.driveTrain.diffDrive(this.leftpower,this.rightpower);
    }


    // make this return true when this Command no longer needs to run execute()
    // checks if the time has passed the set duration
    public boolean isFinished() {
        return System.currentTimeMillis() >= this.duration;
    }


    // called once after isFinished returns true
    // drive train is stopped
    protected void end() {
        this.driveTrain.stop();
    }


    protected void interrupted() {
        this.end();
    }

    
}