package frc.robot;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

public final class Constants {
    public static class OperatorConstants {
        public static final int kDriverControllerPort = 0;
    }

    public static class Drivek {
        public static final int kLeftLeaderCANID = 3;
        public static final int kLeftFollowerCANID = 4;
        public static final int kRightLeaderCANID = 2;
        public static final int kRightFollowerCANID = 1;
        public static final int kIntakeLeaderCANID = 5;
        public static final int kIntakeFollowerCANID = 6;

        public static SparkMaxConfig kGlobalConfigs = new SparkMaxConfig();

        public static SparkMaxConfig kLeftLeaderConfigs = new SparkMaxConfig();
        public static SparkMaxConfig kLeftFollowerConfigs = new SparkMaxConfig();
        public static SparkMaxConfig kRightLeaderConfigs = new SparkMaxConfig();
        public static SparkMaxConfig kRightFollowerConfigs = new SparkMaxConfig();
        public static SparkMaxConfig kIntakeConfigs = new SparkMaxConfig();
        public static SparkMaxConfig kFeedConfigs = new SparkMaxConfig();

        public static void kdriveConfigurator(SparkMax rightMotor, SparkMax leftMotor) {
            kGlobalConfigs
                .idleMode(IdleMode.kBrake);

            kLeftLeaderConfigs
                .apply(kGlobalConfigs)
                .inverted(false);

            kLeftFollowerConfigs
                .apply(kGlobalConfigs)
                .inverted(false)
                .follow(leftMotor);

            kRightLeaderConfigs
                .apply(kGlobalConfigs)
                .inverted(false);

            kRightFollowerConfigs
                .apply(kGlobalConfigs)
                .inverted(false)
                .follow(rightMotor);
        }

        public static void kdriveConfigurator(SparkMax upMotor) {
            kFeedConfigs
                .apply(kGlobalConfigs)
                .inverted(false);

            kIntakeConfigs
                .apply(kGlobalConfigs)
                .inverted(false);
        }
    }
}
