import frc.robot.subsystems.HangRight;

public class ExtendRight extends CommandBase {
    HangSubsystem m_hangSubsystem;

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
        if (m_hangSubsystem.getUpperEncoder()) {
            return false;
        }
        return true;
    }
}
