import frc.robot.subsystems.HangLeft;

//package frc.robot.commands.Hang;

public class StopLeft extends CommandBase {
    HangSubsystem m_hangSubsystem;
    boolean state;

    public StopLeft(HangLeft hang, boolean state) {
        m_hangSubsystem = hang;
        this.state=state;
    }

    @Override
    public void initialize() {
        m_hangSubsystem.leftHangStop();
    }

    @Override
    public boolean isFinished() {
        
        return true;
    }
}