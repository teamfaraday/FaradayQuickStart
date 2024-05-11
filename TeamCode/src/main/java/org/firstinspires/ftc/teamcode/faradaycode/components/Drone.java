package org.firstinspires.ftc.teamcode.faradaycode.components;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Drone {

    public double initPos = 0;
    public double launchPos = 1;

    public Servo drone;

    public Drone(HardwareMap hardwareMap) {
        drone = hardwareMap.servo.get("drone");
    }

    public void iterate(boolean launch) {
        launch();
    }
    public void init() {drone.setPosition(initPos);}
    public void launch() {drone.setPosition(launchPos);}
}
