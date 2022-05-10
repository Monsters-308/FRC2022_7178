package frc.robot.commands.Hang;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.HangRight;

//package frc.robot.commands.Hang;

public class StopRight extends CommandBase {
    HangRight m_hangSubsystem;
    //boolean state;

    public StopRight(HangRight hang) {
        m_hangSubsystem = hang;
        //this.state = state;
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