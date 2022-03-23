import frc.robot.subsystems.HangLeft;

//package frc.robot.commands.Hang;

public class ExtendLeft extends CommandBase {
    HangSubsystem m_hangSubsystem;

    public ExtendLeft(HangLeft hang) {
        m_hangSubsystem = hang;
    }

    @Override
    public void initialize() {
        m_hangSubsystem.leftHangUp();
    }

    @Override
    public void end(boolean interrupted) {
        m_hangSubsystem.leftHangStop();
    }

    @Override
    public boolean isFinished() {
        if (m_hangSubsystem.getUpperEncoder()) {
            return false;
        }
        return true;
    }
}