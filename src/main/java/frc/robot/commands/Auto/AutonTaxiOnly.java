package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.chassis.DriveDistance;
import frc.robot.subsystems.Chassis;

public class AutonTaxiOnly extends SequentialCommandGroup{
    public AutonTaxiOnly(Chassis chassis){
        addCommands(
            new DriveDistance(40,-0.12,chassis)
        );
    }
}
