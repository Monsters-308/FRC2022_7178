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

public class AutonomousBackAndShoot extends SequentialCommandGroup  {

    public AutonomousBackAndShoot(Chassis chassis, Intake intake, Shooter shooter, Indexer indexer, Traverse traverse, LED led){
        addCommands(
            new SequentialCommandGroup(
                new ParallelCommandGroup(
                    new AutoIndexer(intake,indexer,traverse),
                    new DriveDistance(-10, -.2, chassis)
                ),
                new ParallelCommandGroup(
                    new AutoShooter(indexer,shooter)
                )
            )
        );
        
    }
}