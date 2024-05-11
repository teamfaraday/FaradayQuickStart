package org.firstinspires.ftc.teamcode.faradaycode.components;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.faradaycode.OpModes;

public class Hang {

    public double hangPower = 1;
    public double slowConst = 0.45;

    public DcMotor hang;

    public Hang(HardwareMap hardwareMap) {
        hang = hardwareMap.dcMotor.get("hang");
        hang.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void iterate(boolean up,boolean down){
        if (up) {
            up();
        } else if (down) {
            down();
        } else {
            deactivate();
        }
    }

    public void up() {
        if (!OpModes.isSlow) {
            hang.setPower(hangPower * OpModes.nerf);
        } else {
            hang.setPower(hangPower * slowConst * OpModes.nerf);
        }
    }
    public void down() {
        if (!OpModes.isSlow) {
            hang.setPower(-hangPower * OpModes.nerf);
        } else {
            hang.setPower(-hangPower * slowConst * OpModes.nerf);
        }
    }
    public void deactivate() {
        hang.setPower(0);
    }
}