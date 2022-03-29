package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CompressorConstants;
import frc.robot.Constants.HangConstants;

public class HangLeft extends SubsystemBase{
    private final CANSparkMax m_leftHang = new CANSparkMax(HangConstants.kLeftHangMotorPort, MotorType.kBrushless);
    private final Solenoid m_leftDeploy = new Solenoid(CompressorConstants.kModuleID,PneumaticsModuleType.CTREPCM,HangConstants.kLeftDeployPort);

    private RelativeEncoder m_leftEncoder = m_leftHang.getEncoder();

    private DigitalInput m_leftLimit = new DigitalInput(2);

    public HangLeft(){
        m_leftHang.restoreFactoryDefaults();
        m_leftHang.setSmartCurrentLimit(HangConstants.kCurrentLimit);

        m_leftHang.setIdleMode(IdleMode.kBrake);

    }

    public void leftHangUp(){
        m_leftHang.set(HangConstants.kHangMotorSpeed);
    }
    public void leftHangDown(){
        m_leftHang.set(-HangConstants.kHangMotorSpeed);
    }
    public void leftHangStop(){
        m_leftHang.set(0.0);
    }

    public void leftHangDeploy(){
        if(m_leftDeploy.get()){
            m_leftDeploy.set(false);
        }else{
            m_leftDeploy.set(true);
        }
        // m_leftDeploy.set(true);
    }
    public void leftHangRetract(){
        m_leftDeploy.set(false);
    }
    public void setDeployed(boolean set){
        m_leftDeploy.set(set);
    }

    public double getLeftHangPosition(){
        return m_leftEncoder.getPosition();
    }

    public void resetLeftHangPosition(){
        m_leftEncoder.setPosition(0.0);
    }
    public boolean getUpperEncoder(){
        return m_leftLimit.get();
    }
    public double getLowerEncoderVelocity(){
        return m_leftEncoder.getVelocity();// this work not at all as well
    }


    @Override
    public void periodic(){
        SmartDashboard.putNumber("LHang Enc",getLeftHangPosition());
        SmartDashboard.putBoolean("LHang Sol",m_leftDeploy.get());
        SmartDashboard.putBoolean("LHang Limit",m_leftLimit.get());
    }
    
}
