package org.firstinspires.ftc.teamcode.faradaycode.components;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.faradaycode.OpModes;

public class Slide {

    public double slidePower = 1;
    public double antiGravPower = 0.1;
    public double slowConst = 0.45;
    public double slowSlidePower = -0.1;
    public double posSlide;

    public DcMotor slide;
    public DcMotor slide2;



    public Slide(HardwareMap hardwareMap) {
        slide = hardwareMap.dcMotor.get("slide");
        slide2 = hardwareMap.dcMotor.get("slide2");
        slide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        slide2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        slide2.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void iterate(boolean up, boolean down, boolean intakes) {
        if (down){
            down();
        } else if (up) {
            up();
        } else {
            antiGrav();
        }
        if (intakes) {
            slowDown();
        }
    }

    public void up() {
        if (!OpModes.isSlow) {
            slide.setPower(slidePower * OpModes.nerf);
            slide2.setPower(slidePower * OpModes.nerf);
        } else {
            slide.setPower(slidePower * slowConst * OpModes.nerf);
            slide2.setPower(slidePower * slowConst * OpModes.nerf);
        }
    }
    public void down() {
        if (!OpModes.isSlow) {
            slide.setPower(-slidePower * OpModes.nerf);
            slide2.setPower(-slidePower * OpModes.nerf);
        } else {
            slide.setPower(-slidePower * slowConst * 0.6 * OpModes.nerf);
            slide2.setPower(-slidePower * slowConst * 0.6 * OpModes.nerf);
        }
    }
    public void slowDown() {
        slide.setPower(slowSlidePower);
        slide2.setPower(slowSlidePower);
    }
    public void antiGrav() {
        slide.setPower(antiGravPower);
        slide2.setPower(antiGravPower);
    }
    public void slowUp() {
        slide.setPower(0.2);
        slide2.setPower(0.2);
    }
    public void deactivate() {
        slide.setPower(0);
        slide2.setPower(0);
    }

    //clean this up later note to self
    /*public void slide(double degrees, double speed) {
        posSlide = intake1.getCurrentPosition();

        posSlide += degrees;

        .setTargetPosition((int) pos);

        intake1.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        intake1.setPower(Math.abs(speed));

        while (intake1.isBusy()) {}

            intake1.setPower(0);

            intake1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
       } */
}
