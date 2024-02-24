package frc.robot.commands.autos.simples;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Lift;


public class LiftDownAuto extends Command {


    private double power, duration;
    private Lift Lift;


    public LiftDownAuto(Lift Lift, double duration, double power) {
        this.Lift = Lift;
        this.duration = duration;
        this.power = power;
        addRequirements(Lift);
    }


    // called just before this Command runs the first time
    // calculates when to end Command
    public void initialize() {
        double currentTime = System.currentTimeMillis();
        this.duration = (currentTime + this.duration);
    }


    // called repeatedly when this Command is scheduled to run
    public void execute() {
        this.Lift.LiftDownAuto(this.power);
    }


    // make this return true when this Command no longer needs to run execute()
    // checks if the time has passed the set duration
    public boolean isFinished() {
        return System.currentTimeMillis() >= this.duration;
    }


    // called once after isFinished returns true
    // drive train is stopped
    protected void end() {
        this.Lift.LiftStop();
    }


    protected void interrupted() {
        this.end();
    }

    
}