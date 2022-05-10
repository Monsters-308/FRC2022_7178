package frc.robot.subsystems;

import javax.swing.text.StyleContext.SmallAttributeSet;

import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxLimitSwitch;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.SparkMaxLimitSwitch.Type;

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
    // private SparkMaxLimitSwitch upperLimit;
    // private SparkMaxLimitSwitch lowerLimit;
    private RelativeEncoder m_leftEncoder = m_leftHang.getEncoder();

    private DigitalInput m_leftLimit = new DigitalInput(3);

    public HangLeft(){
        m_leftHang.restoreFactoryDefaults();
        m_leftHang.setSmartCurrentLimit(HangConstants.kCurrentLimit);
        m_leftHang.setInverted(false);
        // upperLimit=m_leftHang.getForwardLimitSwitch(Type.kNormallyOpen);
        // lowerLimit=m_leftHang.getReverseLimitSwitch(Type.kNormallyOpen);

        m_leftHang.setIdleMode(IdleMode.kBrake);
        m_leftDeploy.set(false);

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
    public boolean getMidLimit(){
        return m_leftLimit.get();
    }
    // public boolean getLowEncoder(){
    //     return ;
    // }
    public boolean isDeployed(){
        return m_leftDeploy.get();
    }


    @Override
    public void periodic(){
        SmartDashboard.putNumber("LHang Enc",getLeftHangPosition());
        SmartDashboard.putBoolean("LHang Sol",m_leftDeploy.get());
        SmartDashboard.putBoolean("LHang Limit",m_leftLimit.get());
        SmartDashboard.putNumber("LHang Current", m_leftHang.getOutputCurrent());
        if(!m_leftDeploy.get()){
            if(m_leftHang.get()>0.2){
                if(m_leftLimit.get()){
                    m_leftHang.set(0.0);
                }
                
            }
        }
        // SmartDashboard.putBoolean("LeftUP", upperLimit.isPressed()); //limit switch test, may disable the limit switches
        // SmartDashboard.putBoolean("LeftDOWN", lowerLimit.isPressed());
    }
}