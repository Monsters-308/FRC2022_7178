import frc.robot.subsystems.HangRight;

public class RetractRight extends CommandBase {
    HangSubsystem m_hangSubsystem;

    public RetractRight(HangRight hang) {
        m_hangSubsystem = hang;
    }

    @Override
    public void initialize() {
        m_hangSubsystem.rightHangDown();
    }

    @Override
    public void end(boolean interrupted) {
        m_hangSubsystem.rightHangStop();
    }

    @Override
    public boolean isFinished() {
        if (m_hangSubsystem.getLowerEncoder()) {
            return false;
        }
        return true;
    }
}
