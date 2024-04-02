package frc.robot.commands.autos.simples;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Indexer;


public class IndexerBackwardAuto extends Command {


    private double power, duration;
    private Indexer Indexer;


    public IndexerBackwardAuto(Indexer Indexer, double duration, double power) {
        this.Indexer = Indexer;
        this.duration = duration;
        this.power = power;
        addRequirements(Indexer);
    }


    // called just before this Command runs the first time
    // calculates when to end Command
    public void initialize() {
        double currentTime = System.currentTimeMillis();
        this.duration = (currentTime + this.duration);
    }


    // called repeatedly when this Command is scheduled to run
    public void execute() {
        this.Indexer.IndexerBackwardAuto(this.power);
    }


    // make this return true when this Command no longer needs to run execute()
    // checks if the time has passed the set duration
    public boolean isFinished() {
        return System.currentTimeMillis() >= this.duration;
    }


    // called once after isFinished returns true
    // drive train is stopped
    protected void end() {
        this.Indexer.IndexerStop();
    }


    protected void interrupted() {
        this.end();
    }

    
}