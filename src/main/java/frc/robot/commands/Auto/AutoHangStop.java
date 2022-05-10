package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.HangLeft;
import frc.robot.subsystems.HangRight;
import frc.robot.commands.Hang.SetLeft;
import frc.robot.commands.Hang.SetRight;
import frc.robot.commands.Hang.StopLeft;
import frc.robot.commands.Hang.StopRight;

public class AutoHangStop extends SequentialCommandGroup {
    public AutoHangStop(HangLeft left, HangRight right){
        addCommands(
            new SequentialCommandGroup(
                new SetRight(right, true),
                new SetLeft(left, true),
                new StopLeft(left),
                new StopRight(right)
                
            )
        );
        
    }
    
}
