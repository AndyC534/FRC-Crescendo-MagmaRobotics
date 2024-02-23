package frc.robot.commands.lift;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Lift;


public class LiftStop extends Command {


    /**
     * an instance of {@link frc.robot.subsystems.Lift}
     */
    private final Lift Lift;

    /**
     * @param Lift an instance of {@link frc.robot.subsystems.Lift}
     */
    public LiftStop(Lift Lift) {
        this.Lift = Lift;
        addRequirements(Lift);
    }


    @Override
    public void initialize() {
    }


    /**
     * method that's being executed
     */
    @Override
    public void execute() {
        this.Lift.LiftStop();
    }


    @Override
    public void end(boolean interrupted) {
    }


    @Override
    public boolean isFinished() {
        return false;
    }


}