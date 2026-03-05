package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
// Removed unused import: MotorController
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.Drivek;
import static frc.robot.Constants.Drivek.kLeftFollowerCANID;
import static frc.robot.Constants.Drivek.kLeftLeaderCANID;
import static frc.robot.Constants.Drivek.kRightFollowerCANID;
import static frc.robot.Constants.Drivek.kRightLeaderCANID;

public class Drive extends SubsystemBase {
    private SparkMax m_leftLeader = new SparkMax(kLeftLeaderCANID, MotorType.kBrushed);
    private SparkMax m_leftFollower = new SparkMax(kLeftFollowerCANID, MotorType.kBrushed);

    private SparkMax m_rightLeader = new SparkMax(kRightLeaderCANID, MotorType.kBrushed);
    private SparkMax m_rightFollower = new SparkMax(kRightFollowerCANID, MotorType.kBrushed);

    public SparkMaxConfig kLeftFollowerConfigs = new SparkMaxConfig();
    public SparkMaxConfig kRightFollowerConfigs = new SparkMaxConfig();

    @SuppressWarnings("removal")
    public Drive() {
        Drivek.kdriveConfigurator(m_leftLeader, m_rightLeader);

    kLeftFollowerConfigs.follow(m_leftLeader, false);
    m_leftFollower.configure(kLeftFollowerConfigs, ResetMode.kNoResetSafeParameters, PersistMode.kPersistParameters);

        kRightFollowerConfigs.follow(m_rightLeader, false);
        m_rightFollower.configure(kRightFollowerConfigs, ResetMode.kNoResetSafeParameters, PersistMode.kPersistParameters);
    }

    private final DifferentialDrive m_diffDrive =
        new DifferentialDrive(m_leftLeader, m_rightLeader);


    public void TankDrive(double leftMotorSpeed, double rightMotorSpeed) {
        m_diffDrive.tankDrive(leftMotorSpeed, rightMotorSpeed);
    }
}
