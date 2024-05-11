
package org.firstinspires.ftc.teamcode.faradaycode.Trash;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Disabled
@Autonomous(name = "servoTester")
public class servoTester extends LinearOpMode {

    Servo servoTest;

    public boolean stopped = false;

    @Override
    public void runOpMode() {

        servoTest = hardwareMap.servo.get("servo");
        waitForStart();

        while (opModeIsActive() && stopped == false) {
            servoTest.setPosition(1);

        }

    }


}








