package frc.robot;

import com.thethriftybot.devices.ThriftyNova;
import com.thethriftybot.devices.ThriftyNova.CurrentType;


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

    // ThriftyNova does its own internal configuration. Keep CAN IDs here.

        // No-op configurator for ThriftyNova wiring placeholder. If you need
        // specific ThriftyNova configuration (current limits, brake mode, etc.),
        // add it here using the ThriftyNova API.
        public static void kdriveConfigurator(ThriftyNova rightMotor, ThriftyNova leftMotor) {
            // Apply sane defaults for drive motors: current limits and brake mode.
            // Assumptions: ThriftyNova exposes chainable setters named
            // setMaxCurrent(CurrentType, int) and setBrakeMode(boolean)
            // and setInverted(boolean).
            if (rightMotor != null) {
                rightMotor.setMaxCurrent(CurrentType.STATOR, 60);
                rightMotor.setBrakeMode(false);
                rightMotor.setInverted(false);
            }

            if (leftMotor != null) {
                leftMotor.setMaxCurrent(CurrentType.STATOR, 60);
                leftMotor.setBrakeMode(false);
                leftMotor.setInverted(false);
            }
        }

        public static void kdriveConfigurator(ThriftyNova upMotor) {
            // Feeder/intake: allow higher supply limit but lower stator limit.
            if (upMotor != null) {
                upMotor.setMaxCurrent(CurrentType.STATOR, 60);
                upMotor.setBrakeMode(false);
                upMotor.setInverted(false);
            }
        }
    }
}
