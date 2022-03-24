package frc.robot.commands.Hang;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.HangLeft;

//package frc.robot.commands.Hang;

public class StopLeft extends CommandBase {
    HangLeft m_hangSubsystem;
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