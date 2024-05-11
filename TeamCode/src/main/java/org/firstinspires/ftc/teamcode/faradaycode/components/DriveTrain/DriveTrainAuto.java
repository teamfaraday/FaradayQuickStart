package org.firstinspires.ftc.teamcode.faradaycode.components.DriveTrain;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DriveTrainAuto extends DriveTrainConstants {

    public int lfPos;
    public int rfPos;
    public int lbPos;
    public int rbPos;

    public DriveTrainAuto(HardwareMap hardwareMap) {
        fL = hardwareMap.get(DcMotor.class, "leftFront");
        fR = hardwareMap.get(DcMotor.class, "rightFront");
        bL = hardwareMap.get(DcMotor.class, "leftRear");
        bR = hardwareMap.get(DcMotor.class, "rightRear");
        fL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fR.setDirection(DcMotor.Direction.REVERSE);
        bR.setDirection(DcMotor.Direction.REVERSE);
        fL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        fR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        bL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        bR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    public void moveBot(double moveSpeed, double moveInches, boolean lf, boolean rf, boolean lb, boolean rb) {
        //fetch pos
        lfPos = fL.getCurrentPosition();
        rfPos = fR.getCurrentPosition();
        lbPos = bL.getCurrentPosition();
        rbPos = bR.getCurrentPosition();

        //True if + power, false if - power
        if (lf) { lfPos += (int) (moveInches); } else { lfPos -= (int) (moveInches); }
        if (rf) { rfPos += (int) (moveInches); } else { rfPos -= (int) (moveInches); }
        if (lb) { lbPos += (int) (moveInches); } else { lbPos -= (int) (moveInches); }
        if (rb) { rbPos += (int) (moveInches); } else { rbPos -= (int) (moveInches); }

        //set target pos
        fL.setTargetPosition(lfPos);
        fR.setTargetPosition(rfPos);
        bL.setTargetPosition(lbPos);
        bR.setTargetPosition(rbPos);
        //run to pos
        fL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        fR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        //set speed
        fL.setPower(Math.abs(moveSpeed));
        fR.setPower(Math.abs(moveSpeed));
        bL.setPower(Math.abs(moveSpeed));
        bR.setPower(Math.abs(moveSpeed));
        //wait function
        while (fL.isBusy() && fR.isBusy() && bL.isBusy() && bR.isBusy()) {}
        // Stop all motion;
        fL.setPower(0);
        fR.setPower(0);
        bL.setPower(0);
        bR.setPower(0);
        //Set back to normal
        fL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        fR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void forward(double inches, double speed) {
            moveBot(speed,inches * tpi * lr, true, true, true, true);
    }

    public void backward(double inches, double speed) {
            moveBot(speed,inches * tpi * lr, false, false, false, false);
    }

    public void right(double inches, double speed) {
            moveBot(speed,inches * tpi * lr, true, false, false, true);
    }

    public void left(double inches, double speed) {
            moveBot(speed,inches * tpi * lr, false, true, true, false);
    }

    public void clockwise(double degrees, double speed) {
            moveBot(speed,degrees * dr, true, false, true, false);
    }

    public void counterclockwise(double degrees, double speed) {
            moveBot(speed,degrees * dr, false, true, false, true);
    }

}