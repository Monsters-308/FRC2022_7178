package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.HangLeft;
import frc.robot.subsystems.HangRight;

public class AutoHang1 extends SequentialCommandGroup  {

    public AutoHang1(HangLeft left, HangRight right){
        addCommands(
            new SequentialCommandGroup(
                //new 

                
            )
        );
        
    }
}