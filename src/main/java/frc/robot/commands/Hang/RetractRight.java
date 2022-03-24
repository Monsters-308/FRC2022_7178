package frc.robot.commands.Hang;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.HangRight;

public class RetractRight extends CommandBase {
    HangRight m_hangSubsystem;

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
        return true;
        // if (m_hangSubsystem.getLowerEncoder()) { //this code requires encodes
        //     return false;
        // }
        // return true;
    }
}
