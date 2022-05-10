package frc.robot.commands.Hang;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.HangLeft;

//package frc.robot.commands.Hang;

public class ExtendLeft extends CommandBase {
    HangLeft m_hangSubsystem;

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
        return true;
    }
}