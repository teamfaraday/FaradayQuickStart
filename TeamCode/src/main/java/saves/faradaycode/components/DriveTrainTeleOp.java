package saves.faradaycode.components;

import com.qualcomm.robotcore.hardware.*;
import saves.faradaycode.*;

public class DriveTrainTeleOp implements deviceNames{

    //constants
    public double powerRange = 1;
    public double slowConst = 0.45;

    //inits motor objects
    public DcMotor fL;
    public DcMotor fR;
    public DcMotor bL;
    public DcMotor bR;


    //inits the object + names
    public DriveTrainTeleOp(HardwareMap hardwareMap) {
        fL = hardwareMap.get(DcMotor.class, leftFrontName);
        fR = hardwareMap.get(DcMotor.class, rightFrontName);
        bL = hardwareMap.get(DcMotor.class, leftRearName);
        bR = hardwareMap.get(DcMotor.class, rightRearName);
        motorInits();
    }

    //sets motors based on teleop vals given
    public void iterate(double forwardSpeed, double strafeSpeed, double turnSpeed) {
        double denominator = Math.max(Math.abs(forwardSpeed) + Math.abs(strafeSpeed) + Math.abs(turnSpeed), powerRange);
        double frontLeftPower = ((forwardSpeed - strafeSpeed - turnSpeed)) / denominator;
        double frontRightPower = ((forwardSpeed + strafeSpeed + turnSpeed)) / denominator;
        double backLeftPower = ((forwardSpeed + strafeSpeed - turnSpeed)) / denominator;
        double backRightPower = ((forwardSpeed - strafeSpeed + turnSpeed)) / denominator;
        fL.setPower(frontLeftPower * OpModes.nerf * ((OpModes.isSlow) ? slowConst: 1));
        bL.setPower(backLeftPower * OpModes.nerf * ((OpModes.isSlow) ? slowConst: 1));
        fR.setPower(frontRightPower * OpModes.nerf * ((OpModes.isSlow) ? slowConst: 1));
        bR.setPower(backRightPower * OpModes.nerf * ((OpModes.isSlow) ? slowConst: 1));
    }

    //set up motors
    public void motorInits() {
        fL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        fR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        bL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        bR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        fR.setDirection(DcMotor.Direction.REVERSE);
        bR.setDirection(DcMotor.Direction.REVERSE);
        bL.setDirection(DcMotor.Direction.FORWARD);
        fL.setDirection(DcMotor.Direction.FORWARD);
    }
    //use only for RR
    public void autonDirs() {
        fR.setDirection(DcMotor.Direction.FORWARD);
        bR.setDirection(DcMotor.Direction.FORWARD);
        bR.setDirection(DcMotor.Direction.FORWARD);
        bR.setDirection(DcMotor.Direction.FORWARD);
    }
}