package org.firstinspires.ftc.teamcode.faradaycode.components;

public class Nerf {

    double NERF = 1;

    public double iterate(boolean increase, boolean decrease) {
        if (increase) {
            NERF += 0.0001;
        }
        if (decrease) {
            NERF -= 0.0001;
        }
        return NERF;
    }

}