import frc.robot.subsystems.HangLeft;

//package frc.robot.commands.Hang;

public class RetractLeft extends CommandBase {
    HangSubsystem m_hangSubsystem;

    public RetractLeft(HangLeft hang) {
        m_hangSubsystem = hang;
    }

    @Override
    public void initialize() {
        m_hangSubsystem.leftHangDown();
    }

    @Override
    public void end(boolean interrupted) {
        m_hangSubsystem.leftHangStop();
    }

    @Override
    public boolean isFinished() {
        if (m_hangSubsystem.getLowerEncoder()) {
            return false;
        }
        return true;
    }
}