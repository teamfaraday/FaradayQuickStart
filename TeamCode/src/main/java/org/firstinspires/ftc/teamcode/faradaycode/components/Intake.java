package org.firstinspires.ftc.teamcode.faradaycode.components;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.faradaycode.OpModes;

public class Intake {

    public double intakeAPower = 0.744;
    public double intakeBPower = 1;

    public DcMotor intakeA;
    public CRServo intakeB1;
    public CRServo intakeB2;

    public Intake(HardwareMap hardwareMap) {
        intakeA = hardwareMap.dcMotor.get("intakeA");
        intakeB1 = hardwareMap.crservo.get("intakeB1");
        intakeB2 = hardwareMap.crservo.get("intakeB2");
        intakeA.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        intakeB2.setDirection(CRServo.Direction.REVERSE);
    }

    public void iterate(boolean forward, boolean reverse) {
        if (forward) {
            activate(OpModes.isSlow, OpModes.nerf);
        } else if (reverse) {
            reverse(OpModes.isSlow, OpModes.nerf);
        } else{
            deactivate();
        }
    }

    public void iterate (boolean memorySaver) {}

    public void activate(boolean isSlow, double nerf) {
        intakeA.setPower(intakeAPower);
        intakeB1.setPower(intakeBPower);
        intakeB2.setPower(intakeBPower);
    }
    public void deactivate() {
        intakeA.setPower(0);
        intakeB1.setPower(0);
        intakeB2.setPower(0);
    }
    public void reverse(boolean isSlow, double nerf) {
        intakeA.setPower(-intakeAPower);
        intakeB1.setPower(-intakeBPower);
        intakeB2.setPower(-intakeBPower);
    }
}
