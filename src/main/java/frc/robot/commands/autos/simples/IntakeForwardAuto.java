package frc.robot.commands.autos.simples;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;


public class IntakeForwardAuto extends Command {


    private double power, duration;
    private Intake Intake;


    public IntakeForwardAuto(Intake Intake, double duration, double power, double rightpower) {
        this.Intake = Intake;
        this.duration = duration;
        this.power = power;
        addRequirements(Intake);
    }


    // called just before this Command runs the first time
    // calculates when to end Command
    public void initialize() {
        double currentTime = System.currentTimeMillis();
        this.duration = (currentTime + this.duration);
    }


    // called repeatedly when this Command is scheduled to run
    public void execute() {
        this.Intake.IntakeForwardAuto(power);
    }


    // make this return true when this Command no longer needs to run execute()
    // checks if the time has passed the set duration
    public boolean isFinished() {
        return System.currentTimeMillis() >= this.duration;
    }


    // called once after isFinished returns true
    // drive train is stopped
    protected void end() {
        this.Intake.IntakeStop();
    }


    protected void interrupted() {
        this.end();
    }

    
}