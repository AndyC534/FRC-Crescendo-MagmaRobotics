package frc.robot.commands.indexer;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Indexer;


public class IndexerBackward extends Command {


    /**
     * an instance of {@link frc.robot.subsystems.Indexer}
     */
    private final Indexer indexer;

    /**
     * @param indexer an instance of {@link frc.robot.subsystems.Indexer}
     */
    public IndexerBackward(Indexer indexer) {
        this.indexer = indexer;
        addRequirements(indexer);
    }


    @Override
    public void initialize() {
    }


    /**
     * method that's being executed
     */
    @Override
    public void execute() {
        this.indexer.IntakeBackward();
    }


    @Override
    public void end(boolean interrupted) {
    }


    @Override
    public boolean isFinished() {
        return false;
    }


}