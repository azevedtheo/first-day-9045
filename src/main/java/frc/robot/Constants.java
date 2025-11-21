package frc.robot;

public class Constants {
    public static class DriveConsts {
        public static final int     FRONT_LEFT_MOTOR_ID = 1;
        public static final int     FRONT_RIGHT_MOTOR_ID = 2;
        public static final int     BACK_LEFT_MOTOR_ID = 3;
        public static final int     BACK_RIGHT_MOTOR_ID = 4;
        public static final double  MAX_SPEED = 0.35; // Max speed as a fraction of full speed

    }
    public static class OIConsts {
        // Controller Ports
        public static final int     SUB_CONTROLLER_PORT = 1;
        public static final int     MAIN_CONTROLLER_PORT = 0;
        // Controller Axis
        public static final int     LEFT_X_AXIS = 0;
        public static final int     LEFT_Y_AXIS = 1;
        public static final int     RIGHT_Y_AXIS = 5;
        public static final int     RIGHT_X_AXIS = 4;
        public static final double  DEADBAND = 0.2;
        // Controller Trigger
        public static final int     LEFT_BUMPER_L1 = 5;
        public static final int     RIGHT_BUMPER_R1 = 6;
        public static final int     LEFT_TRIGGER_L2 = 2;
        public static final int     RIGHT_TRIGGER_R2 = 3;
        //Controller Buttons
        public static final int     A_BUTTON = 1;
        public static final int     B_BUTTON = 2;
    }
}
