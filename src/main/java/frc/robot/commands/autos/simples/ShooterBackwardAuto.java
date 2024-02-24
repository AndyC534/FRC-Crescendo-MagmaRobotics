package frc.robot.commands.autos.simples;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;


public class ShooterBackwardAuto extends Command {


    private double power, duration;
    private final Shooter ShooterMotor1, ShooterMotor2;


    public ShooterBackwardAuto(Shooter ShooterMotor1, Shooter ShooterMotor2, double duration, double power) {
        this.ShooterMotor1 = ShooterMotor1;
        this.ShooterMotor2 = ShooterMotor2;
        this.duration = duration;
        this.power = power;
        addRequirements(ShooterMotor1);
        addRequirements(ShooterMotor2);

    }


    // called just before this Command runs the first time
    // calculates when to end Command
    public void initialize() {
        double currentTime = System.currentTimeMillis();
        this.duration = (currentTime + this.duration);
    }


    // called repeatedly when this Command is scheduled to run
    public void execute() {
        this.ShooterMotor1.ShooterMotor1BackwardAuto(this.power);
        this.ShooterMotor2.ShooterMotor2ForwardAuto(this.power);
    }


    // make this return true when this Command no longer needs to run execute()
    // checks if the time has passed the set duration
    public boolean isFinished() {
        return System.currentTimeMillis() >= this.duration;
    }


    // called once after isFinished returns true
    // drive train is stopped
    protected void end() {
        this.ShooterMotor1.ShooterMotor1Stop();
        this.ShooterMotor2.ShooterMotor2Stop();
    }


    protected void interrupted() {
        this.end();
    }

    
}