package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Hang.SetLeft;
import frc.robot.commands.Hang.SetRight;
import frc.robot.commands.chassis.DriveDistance;
import frc.robot.commands.indexer.AutoIndexer;
import frc.robot.commands.shooter.AutoShooter;
import frc.robot.commands.shooter.StopShooter;
import frc.robot.subsystems.Chassis;
import frc.robot.subsystems.HangLeft;
import frc.robot.subsystems.HangRight;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Traverse;

public class AutonTaxiTwoBall extends SequentialCommandGroup{

    public AutonTaxiTwoBall(Chassis chassis, Intake intake, Indexer indexer, Traverse traverse, Shooter shooter,HangLeft lefthang, HangRight righthang){
        addCommands(
            new SequentialCommandGroup(
                new ParallelCommandGroup(
                    new SetRight(righthang, false),
                    new SetLeft(lefthang, false),
                    new AutoIndexer(intake,indexer,traverse,shooter),
                    new DriveDistance(40,-0.12,chassis) 
                ),
                new AutoShooter(indexer,shooter),
                new StopShooter(shooter)
            )
        );
    }
    
}
