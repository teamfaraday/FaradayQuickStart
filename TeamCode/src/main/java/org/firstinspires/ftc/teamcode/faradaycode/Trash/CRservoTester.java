package org.firstinspires.ftc.teamcode.faradaycode.Trash;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


@Disabled
@Autonomous(name = "CRservoTester")
public class CRservoTester extends LinearOpMode {

    CRServo servoTest;

    public boolean stopped = false;

    @Override
    public void runOpMode() {

        servoTest = hardwareMap.crservo.get("servo"); //insert servo name

        waitForStart();

        while (opModeIsActive() && stopped == false) {
            servoTest.setPower(1);
        }

    }

}








