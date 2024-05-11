package org.firstinspires.ftc.teamcode.faradaycode.components;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.faradaycode.OpModes;
import org.firstinspires.ftc.teamcode.faradaycode.TeleOp.TeleIsOpping;

public class BannerBox extends TeleIsOpping {

    //y
    public double rotate1Drop = 0.2464; //right drop
    public double rotate2Drop = 0.8331; //left drop
    public double releaseClose = 0.14; //release open

    //x
    public double rotate1Intake = 0.702; //right intake
    public double rotate2Intake = 0.5325; //left intake
    public double releaseOpen = 0.72; //release close

    public Servo rotate1;
    public Servo rotate2;
    public Servo release;

    public BannerBox(HardwareMap hardwareMap) {
        rotate1 = hardwareMap.get(Servo.class, "rotate1");
        rotate2 = hardwareMap.get(Servo.class, "rotate2");
        release = hardwareMap.get(Servo.class, "release");
    }

    public void iterate(boolean intake, boolean drop, boolean slideDown) {
        if (intake) {intakePos(OpModes.nerf);}
        if (drop) {dropPos(OpModes.nerf);}
        if (slideDown) {intakePos(OpModes.nerf);}
    }

    public void intakePos(double nerf) {
        rotate1.setPosition(rotate1Intake);
        rotate2.setPosition(rotate2Intake);
        close(nerf);
    }
    public void dropPos(double nerf) {
        rotate1.setPosition(rotate1Drop);
        rotate2.setPosition(rotate2Drop);
        open(nerf);
    }
    public void close(double nerf) {
        release.setPosition(releaseClose);
    }
    public void open(double nerf) {
        release.setPosition(releaseOpen);
    }
}
