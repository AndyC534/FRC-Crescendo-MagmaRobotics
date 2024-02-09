package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Test;


public class testMotor3Stop extends Command {


    /**
     * an instance of {@link frc.robot.subsystems.Test}
     */
    private final Test testMotor3;

    /**
     * @param testMotor1 an instance of {@link frc.robot.subsystems.Test}
     */
    public testMotor3Stop(Test testMotor3) {
        this.testMotor3 = testMotor3;
        addRequirements(testMotor3);
    }


    @Override
    public void initialize() {
    }


    /**
     * method that's being executed
     */
    @Override
    public void execute() {
        this.testMotor3.testMotor3Stop();
    }


    @Override
    public void end(boolean interrupted) {
    }


    @Override
    public boolean isFinished() {
        return false;
    }


}