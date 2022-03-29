package frc.robot.commands.Auto;



import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.HangLeft;
import frc.robot.subsystems.HangRight;
import frc.robot.commands.Hang.ExtendRight;
import frc.robot.commands.Hang.RetractRight;
import frc.robot.commands.Hang.SetLeft;
import frc.robot.commands.Hang.SetRight;

public class AutoFirstRung extends SequentialCommandGroup  {


    public AutoFirstRung(HangLeft left, HangRight right){
        addCommands(
            new SequentialCommandGroup(
                new SetRight(right, true),
                new SetLeft(left, true),
                new ExtendRight(right),
                new WaitCommand(5.0),
                new RetractRight(right)
                
            )
        );
        
    }
}