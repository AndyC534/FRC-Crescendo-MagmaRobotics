package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;


public class ShooterStop extends Command {


    /**
     * an instance of {@link frc.robot.subsystems.Shooter}
     */
    private final Shooter ShooterMotor1, ShooterMotor2;

    /**
     * @param ShooterMotor1 an instance of {@link frc.robot.subsystems.Shooter}
     */
    public ShooterStop(Shooter ShooterMotor1, Shooter ShooterMotor2) {
        this.ShooterMotor1 = ShooterMotor1;
        this.ShooterMotor2 = ShooterMotor2;
        addRequirements(ShooterMotor1);
        addRequirements(ShooterMotor2);
    }


    @Override
    public void initialize() {
    }


    /**
     * method that's being executed
     */
    @Override
    public void execute() {
        this.ShooterMotor1.ShooterMotor1Stop();
        this.ShooterMotor2.ShooterMotor2Stop();
    }


    @Override
    public void end(boolean interrupted) {
    }


    @Override
    public boolean isFinished() {
        return false;
    }


}