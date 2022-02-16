package frc.robot.subsystems;


import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;




public class Chassis extends SubsystemBase{


    private final CANSparkMax m_frontLeft = new CANSparkMax(4, MotorType.kBrushless);
    private final CANSparkMax m_frontRight = new CANSparkMax(3, MotorType.kBrushless);
    private final CANSparkMax m_backLeft = new CANSparkMax(1, MotorType.kBrushless);
    private final CANSparkMax m_backRight = new CANSparkMax(2, MotorType.kBrushless);


    //These are the encoders that are not working so we will fix them at some point in time
    private RelativeEncoder m_leftEncoder;
    private RelativeEncoder m_rightEncoder;


    
    private final MecanumDrive m_driveType;

    public Chassis(){
        m_leftEncoder = m_frontLeft.getEncoder();
        m_rightEncoder = m_frontRight.getEncoder();
    
        m_frontLeft.restoreFactoryDefaults();
        m_frontRight.restoreFactoryDefaults();        
        m_backLeft.restoreFactoryDefaults();
        m_backRight.restoreFactoryDefaults();

        //What are these
        m_frontLeft.setSmartCurrentLimit(40);
        m_frontRight.setSmartCurrentLimit(40);
        m_backLeft.setSmartCurrentLimit(40);
        m_backRight.setSmartCurrentLimit(40);


        m_backRight.follow(m_frontRight);
        m_backLeft.follow(m_frontLeft);

        m_leftEncoder.setPositionConversionFactor(1.0);
        m_rightEncoder.setPositionConversionFactor(1.0);

    }
    public void ResetEncoders()
    {
        m_leftEncoder.setPosition(0);
        m_rightEncoder.setPosition(0);
    }

    public RelativeEncoder getLeftEncoder() 
    {
        return m_leftEncoder;
    }

    public RelativeEncoder getRightEncoder() 
    {
        return m_rightEncoder;
    }

    //this code was previously commented out
   public double getLeftEncoderPosition() {
     return m_leftEncoder.getPosition();
   }

   public double getRightEncoderPosition() {
     return m_rightEncoder.getPosition();
   }
   //this code above was previously commented out

  @Override
  public void periodic()
  {
      
  }
    

}
