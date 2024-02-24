package frc.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;

public class IntakeForward extends Command {


    /**
     * an instance of {@link frc.robot.subsystems.ShooterMotor2}
     */
    private final Intake Intake;

    /**
     * @param Intake an instance of {@link frc.robot.subsystems.ShooterMotor2}
     */
    public IntakeForward(Intake Intake) {
        this.Intake = Intake;
        addRequirements(Intake);
    }


    @Override
    public void initialize() {
    }


    /**
     * method that's being executed
     */
    @Override
    public void execute() {
        this.Intake.IntakeForward();
    }


    @Override
    public void end(boolean interrupted) {
    }


    @Override
    public boolean isFinished() {
        return false;
    }


}