package org.firstinspires.ftc.teamcode.faradaycode.components.DriveTrain;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.hardware.DcMotor;

public class DriveTrainConstants {
    public DcMotor fL;
    public DcMotor fR;
    public DcMotor bL;
    public DcMotor bR;
    public double powerRange = 1;

    public static final int tpi = 50; //length ratio, these is a value from last year, so it'll prob need to be tweaked
    public static final double lr = 0.8535; //length ratio, these is a value from last year, so it'll prob need to be tweaked
    public static final double dr = 4; //degree ratio, value needs to be tested & tweaked

}
