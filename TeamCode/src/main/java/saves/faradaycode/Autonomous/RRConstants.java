package saves.faradaycode.Autonomous;

public interface RRConstants{

    //DriveConstants constants
    double DRIVE_CONSTANTS_TICKS_PER_REV = 537.7;
    double MAX_RPM = 312;

    double DRIVE_CONSTANTS_WHEEL_RADIUS = 1.8898; // in
    double DRIVE_CONSTANTS_GEAR_RATIO = 19.2; // output (wheel) speed / input (motor) speed
    double TRACK_WIDTH = 15.26; // in

    double kV = 0.017948;
    double kA = 0.00245;
    double kStatic = 0.01;

    double MAX_VEL = 30;
    double MAX_ACCEL = 30;
    double MAX_ANG_VEL = 3.3763414853498652;
    double MAX_ANG_ACCEL = Math.toRadians(150);

    //StandardTrackingWheelLocalizer constants
    double STWL_TICKS_PER_REV = 2000;
    double STWL_WHEEL_RADIUS = 0.944882; // in
    double STWL_GEAR_RATIO = 1; // output (wheel) speed / input (encoder) speed

    double LATERAL_DISTANCE = 12.6232; // in; distance between the left and right wheels - STILL NEED TO TUNE
    double FORWARD_OFFSET = -3.375; // in; offset of the lateral wheel - STILL NEED TO TUNE

    double X_MULTIPLIER = 0.99156187; // Multiplier in the X direction
    double Y_MULTIPLIER = 0.99580379; // Multiplier in the Y direction

    //SampleMecanumDrive constants
    double LATERAL_MULTIPLIER = 1.3555;

}
