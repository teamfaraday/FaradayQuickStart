package saves.faradaycode;

 /*
    Control Hub
        Motors
            0: backLeft
            1: frontLeft
            2: slide2
            3: hang
        Servos
            0: drone
            1: purplePixel
    Expansion Hub
        Motors
            0: intakeA
            1: slide
            2: frontRight
            3: backRight
        Servos
            0: release
            1: intakeB1
            2: intakeB2
            3: rotate1
            4: rotate2 */

public interface deviceNames {

    //servos
    String dummyServoName = "dummyServo"; //Expansion hub 2

    //motors
    String dummyDCMotorName = "dummyDCMotor"; //Control hub 1

    //crservos
    String dummyCRServoName = "dummyCRServo";

    // drivetrain
    String leftFrontName = "leftFront";
    String leftRearName = "leftRear";
    String rightRearName = "rightRear";
    String rightFrontName = "rightFront";

    //encoders
    String leftEncoderName = "slide2";
    String rightEncoderName = "hang";
    String frontEncoderName = "intakeA";

    //tFod
    String webCamName = "Webcam 1";
    String blueLabel = "b";
    String redLabel = "r";
    String blueAsset = "bb.tflite";
    String redAsset = "rr.tflite";

}