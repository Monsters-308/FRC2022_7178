package frc.robot.commands.Auto;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.Constants.ShooterConstants;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Shooter;
import frc.robot.commands.chassis.AutoAim;
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

public class FourBallAuton extends SequentialCommandGroup  {

    public FourBallAuton(Chassis chassis, Intake intake, Shooter shooter, Indexer indexer, Traverse traverse, LED led, Vision vision){
        addCommands(
            new SequentialCommandGroup(
                new ParallelCommandGroup(
                    new DriveDistance(45, -.12, chassis)
                ),
                new ParallelCommandGroup(
                    new AutoShooter(indexer,shooter)
                ),
                new ParallelCommandGroup(
                    new DriveDistance(5, .12, chassis)
                ),
                new ParallelCommandGroup(
                    new AutoAim(chassis, vision) 
                ),
                new ParallelCommandGroup(
                    new AutoShooter(indexer,shooter)
                )
            )
        );
        
    }
}