package frc.robot.commands.Auto;



import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.HangLeft;
import frc.robot.subsystems.HangRight;
import frc.robot.commands.Hang.ExtendLeft;
import frc.robot.commands.Hang.ExtendRight;
import frc.robot.commands.Hang.RetractLeft;
import frc.robot.commands.Hang.RetractRight;
import frc.robot.commands.Hang.SetLeft;
import frc.robot.commands.Hang.SetRight;

public class AutoMidRung extends SequentialCommandGroup  {


    public AutoMidRung(HangLeft left, HangRight right){
        addCommands(
            new SequentialCommandGroup(
                new ExtendLeft(left),
                new WaitCommand(7.0),
                new SetLeft(left, false),
                new RetractLeft(left),
                new SetRight(right, true)
            )
        );
        
    }
}