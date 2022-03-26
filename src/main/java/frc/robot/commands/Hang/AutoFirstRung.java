package frc.robot.commands.Hang;



import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.HangLeft;
import frc.robot.subsystems.HangRight;
import frc.robot.commands.Hang.SetRight;

public class AutoFirstRung extends SequentialCommandGroup  {


    public AutoFirstRung(HangLeft left, HangRight right){
        addCommands(
            new SequentialCommandGroup(
                new SetRight(right, true),
                new SetLeft(left, true),
                new ExtendRight(right),
                // new
                
            )
        );
        
    }
}