package org.firstinspires.ftc.teamcode.faradaycode.components;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class PurplePixel {

    public double initPos = 0.9;
    public double releasePos = 0.5;

    public Servo purplePixel;

    public PurplePixel(HardwareMap hardwareMap) {
        purplePixel = hardwareMap.servo.get("purplePixel");
    }

    public void init() {
        purplePixel.setPosition(initPos);
    }
    public void release() {
        purplePixel.setPosition(releasePos);
    }
}
