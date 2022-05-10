package frc.robot.commands.Auto;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.Constants.ShooterConstants;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Shooter;
import frc.robot.commands.chassis.DriveDistance;
import frc.robot.subsystems.LED;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Vision;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Traverse;
import frc.robot.subsystems.Chassis;
import frc.robot.commands.indexer.AutoIndexer;
import frc.robot.commands.shooter.AutoShooter;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.HangLeft;
import frc.robot.subsystems.HangRight;
import frc.robot.commands.Hang.SetLeft;
import frc.robot.commands.Hang.SetRight;
import edu.wpi.first.wpilibj2.command.WaitCommand;

public class AutonDoNothing extends SequentialCommandGroup  {

    public AutonDoNothing(Chassis chassis, Intake intake, Shooter shooter, Indexer indexer, Traverse traverse, LED led, HangLeft lefthang, HangRight righthang){
        addCommands(
            new SequentialCommandGroup(
                new ParallelCommandGroup(
                    new SetRight(righthang, false),
                    new SetLeft(lefthang, false),
                    new DriveDistance(40, -.12, chassis),
                    new WaitCommand(4)
                ),
                new ParallelCommandGroup(
                    new AutoShooter(indexer,shooter)
                )
            )
        );
        
    }
}