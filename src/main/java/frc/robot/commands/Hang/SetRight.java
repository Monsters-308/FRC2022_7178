package frc.robot.commands.Hang;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.HangRight;

//package frc.robot.commands.Hang;

public class SetRight extends CommandBase {
    HangRight m_hangSubsystem;
    boolean state;

    public SetRight(HangRight hang, boolean state) {
        m_hangSubsystem = hang;
        this.state = state;
    }

    @Override
    public void initialize() {
        m_hangSubsystem.setDeployed(state);
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}