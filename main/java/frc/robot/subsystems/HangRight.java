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

public class HangRight extends SubsystemBase{
    private final CANSparkMax m_rightHang = new CANSparkMax(HangConstants.kRightHangMotorPort, MotorType.kBrushless);
    private final Solenoid m_rightDeploy = new Solenoid(CompressorConstants.kModuleID,PneumaticsModuleType.CTREPCM,HangConstants.kRightDeployPort);

    private RelativeEncoder m_rightHangEncoder = m_rightHang.getEncoder();

    private DigitalInput m_rightLimit = new DigitalInput(3);

    public HangRight(){
        m_rightHang.restoreFactoryDefaults();
        m_rightHang.setSmartCurrentLimit(HangConstants.kCurrentLimit);

        m_rightHang.setIdleMode(IdleMode.kBrake);

    }


    public void rightHangUp(){
        m_rightHang.set(HangConstants.kHangMotorSpeed);
    }
    public void rightHangDown(){
        m_rightHang.set(-HangConstants.kHangMotorSpeed);
    }
    public void rightHangStop(){
        m_rightHang.set(0.0);
    }

    public void rightHangDeploy(){
        if(m_rightDeploy.get()){
            m_rightDeploy.set(false);
        }else{
            m_rightDeploy.set(true);
        }
    }
    public void rightHangRetract(){
        m_rightDeploy.set(false);
    }

    public double getRightHangPosition(){
        return m_rightHangEncoder.getPosition();
    }

    public void resetRightHangPosition(){
        m_rightHangEncoder.setPosition(0.0);
    }

    @Override
    public void periodic(){
        SmartDashboard.putNumber("RHang Enc",getRightHangPosition());
        SmartDashboard.putBoolean("RHang Sol",m_rightDeploy.get());
        SmartDashboard.putBoolean("RHang Limit",m_rightLimit.get());
    }
    
}
