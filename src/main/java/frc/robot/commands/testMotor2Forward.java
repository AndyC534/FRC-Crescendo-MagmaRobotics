package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Test;


public class testMotor2Forward extends Command {


    /**
     * an instance of {@link frc.robot.subsystems.Test}
     */
    private final Test testMotor2;
    

    /**
     * @param testMotor2 an instance of {@link frc.robot.subsystems.Test}
     */
    public testMotor2Forward(Test testMotor2) {
        this.testMotor2 = testMotor2;
        addRequirements(testMotor2);
    }


    @Override
    public void initialize() {
    }


    /**
     * method that's being executed
     */
    @Override
    public void execute() {
        this.testMotor2.testMotor2Forward();
    }


    @Override
    public void end(boolean interrupted) {
    }


    @Override
    public boolean isFinished() {
        return false;
    }


}