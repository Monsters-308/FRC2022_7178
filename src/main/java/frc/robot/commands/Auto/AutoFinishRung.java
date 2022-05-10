package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.HangLeft;
import frc.robot.subsystems.HangRight;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.Hang.ExtendRight;
import frc.robot.commands.Hang.RetractLeft;
import frc.robot.commands.Hang.RetractRight;
import frc.robot.commands.Hang.SetLeft;
import frc.robot.commands.Hang.SetRight;

public class AutoFinishRung extends SequentialCommandGroup{
    public AutoFinishRung(HangLeft left, HangRight right){
        addCommands(
            new SequentialCommandGroup(
                new ExtendRight(right),
                new WaitCommand(7),
                new SetRight(right, false),
                new RetractRight(right)
            )
        );
        
    }
}
