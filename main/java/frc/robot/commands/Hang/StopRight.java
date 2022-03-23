import frc.robot.subsystems.HangLeft;

//package frc.robot.commands.Hang;

public class StopRight extends CommandBase {
    HangSubsystem m_hangSubsystem;
    boolean state;

    public StopRight(HangLeft hang, boolean state) {
        m_hangSubsystem = hang;
        this.state = state;
    }

    @Override
    public void initialize() {
        m_hangSubsystem.rightHangStop();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}