package frc.robot.commands.Hang;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.HangRight;

public class ExtendRight extends CommandBase {
    HangRight m_hangSubsystem;

    public ExtendRight(HangRight hang) {
        m_hangSubsystem = hang;
    }

    @Override
    public void initialize() {
        m_hangSubsystem.rightHangUp();
    }

    @Override
    public void end(boolean interrupted) {
        m_hangSubsystem.rightHangStop();
    }

    @Override
    public boolean isFinished() {
        // if (m_hangSubsystem.getUpperEncoder()) {
        //     return false;
        // }
        return true;
    }
}
