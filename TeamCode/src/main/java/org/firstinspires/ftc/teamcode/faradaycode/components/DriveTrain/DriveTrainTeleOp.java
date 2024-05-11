package org.firstinspires.ftc.teamcode.faradaycode.components.DriveTrain;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.faradaycode.OpModes;

public class DriveTrainTeleOp extends DriveTrainConstants {

    public double slowConst = 0.45;

    public DriveTrainTeleOp(HardwareMap hardwareMap, boolean reverse) {
        fL = hardwareMap.get(DcMotor.class, "leftFront");
        fR = hardwareMap.get(DcMotor.class, "rightFront");
        bL = hardwareMap.get(DcMotor.class, "leftRear");
        bR = hardwareMap.get(DcMotor.class, "rightRear");
        fL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        fR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        bL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        bR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        if (reverse) {reverseDir();}
    }

    public void iterate(double forwardSpeed, double strafeSpeed, double turnSpeed) {
        double denominator = Math.max(Math.abs(forwardSpeed) + Math.abs(strafeSpeed) + Math.abs(turnSpeed), powerRange);
        double frontLeftPower = ((forwardSpeed - strafeSpeed - turnSpeed)) / denominator;
        double frontRightPower = ((forwardSpeed + strafeSpeed + turnSpeed)) / denominator;
        double backLeftPower = ((forwardSpeed + strafeSpeed - turnSpeed)) / denominator;
        double backRightPower = ((forwardSpeed - strafeSpeed + turnSpeed)) / denominator;
        if (!OpModes.isSlow) {
            fL.setPower(frontLeftPower * OpModes.nerf);
            bL.setPower(backLeftPower * OpModes.nerf);
            fR.setPower(frontRightPower * OpModes.nerf);
            bR.setPower(backRightPower * OpModes.nerf);
        } else {
            fL.setPower(frontLeftPower * slowConst * OpModes.nerf);
            bL.setPower(backLeftPower * slowConst * OpModes.nerf);
            fR.setPower(frontRightPower * slowConst * OpModes.nerf);
            bR.setPower(backRightPower * slowConst * OpModes.nerf);
        }
    }
    public void reverseDir() {
        fR.setDirection(DcMotor.Direction.REVERSE);
        bR.setDirection(DcMotor.Direction.REVERSE);
    }
}