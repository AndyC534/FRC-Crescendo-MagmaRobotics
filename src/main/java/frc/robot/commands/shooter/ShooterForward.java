package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;


public class ShooterForward extends Command {


    /**
     * an instance of {@link frc.robot.subsystems.ShooterMotor2}
     */
    private final Shooter ShooterMotor1;

    /**
     * @param Shooter an instance of {@link frc.robot.subsystems.ShooterMotor2}
     */
    public ShooterForward(Shooter ShooterMotor1) {
        this.ShooterMotor1 = ShooterMotor1;
        addRequirements(ShooterMotor1);
    }


    @Override
    public void initialize() {
    }


    /**
     * method that's being executed
     */
    @Override
    public void execute() {
        this.ShooterMotor1.ShooterMotor1Forward();
    }


    @Override
    public void end(boolean interrupted) {
    }


    @Override
    public boolean isFinished() {
        return false;
    }


}