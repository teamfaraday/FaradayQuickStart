
package org.firstinspires.ftc.teamcode.faradaycode.Trash;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@Disabled
@Autonomous(name = "motorTester")
public class motorTester extends LinearOpMode {

    DcMotor motorTest;

    public boolean stopped = false;
    public int pos;


    @Override
    public void runOpMode() {

        motorTest = hardwareMap.get(DcMotor.class,"motorTest"); //insert name here

        motorTest.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorTest.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        waitForStart();


        while (opModeIsActive() && stopped == false) {
            rotateForward(10000,5);
            stopped = true;
        }


    }

    public void rotateForward(int inches, double speed) {

        if (opModeIsActive()) {

            // fetch motor positions
            pos = motorTest.getCurrentPosition();

            // calculate new targets
            pos += inches;

            // move robot to new position
            motorTest.setTargetPosition(pos);

            motorTest.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            while (motorTest.isBusy()) {}

            // Stop all motion;
            motorTest.setPower(0);

            // Turn off RUN_TO_POSITION
            motorTest.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        }
    }

}





