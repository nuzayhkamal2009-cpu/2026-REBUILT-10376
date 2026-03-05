package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SpinnyBoi2 extends SubsystemBase {
    public final SparkMax m_intake = new SparkMax(5, MotorType.kBrushed);
    public final SparkMax m_feed = new SparkMax(6, MotorType.kBrushed);

    public SpinnyBoi2() {
        // SparkMaxConfig has no constructor taking an ID — use default and configure if needed
        final SparkMaxConfig kIntakeConfigs = new SparkMaxConfig();
        final SparkMaxConfig kFeedConfigs = new SparkMaxConfig();
    }
}
