package org.firstinspires.ftc.teamcode.faradaycode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.faradaycode.components.Hang;
import org.firstinspires.ftc.teamcode.faradaycode.components.Intake;
import org.firstinspires.ftc.teamcode.faradaycode.components.Slide;
import org.firstinspires.ftc.teamcode.faradaycode.components.Drone;
import org.firstinspires.ftc.teamcode.faradaycode.components.Nerf;
//import org.firstinspires.ftc.teamcode.faradaycode.components.DriveTrain.DriveTrainAuto;
import org.firstinspires.ftc.teamcode.faradaycode.components.DriveTrain.DriveTrainTeleOp;
import org.firstinspires.ftc.teamcode.faradaycode.components.BannerBox;
import org.firstinspires.ftc.teamcode.faradaycode.components.PurplePixel;


import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

public abstract class OpModes extends LinearOpMode{
    /*
    Control Hub
        Motors
            0: backLeft
            1: frontLeft
            2: slide2
            3: hang
        Servos
            0: drone
            1: purplePixel
    Expansion Hub
        Motors
            0: intakeA
            1: slide
            2: frontRight
            3: backRight
        Servos
            0: release
            1: intakeB1
            2: intakeB2
            3: rotate1
            4: rotate2 */

    public Hang hang;
    public Intake intake;
    public Slide slide;
    public Drone drone;
   // public DriveTrainAuto driveTrainAuto;
    public DriveTrainTeleOp driveTrainTeleOp;
    public BannerBox bannerBox;
    public PurplePixel purplePixel;
    public Nerf Nerf = new Nerf();

    public ElapsedTime timeSpent = new ElapsedTime();

    public boolean stopped = false;
    public static double nerf = 1;
    public static boolean isSlow = false;
    public boolean isSlow1 = false;
    public boolean isSlow2 = false;
    public static boolean t = true;
    public static boolean f = false;

    public void turnOn(boolean dtReverse) {
        hang = new Hang(hardwareMap);
        intake = new Intake(hardwareMap);
        slide = new Slide(hardwareMap);
        drone = new Drone(hardwareMap);
      //  driveTrainAuto = new DriveTrainAuto(hardwareMap);
        driveTrainTeleOp = new DriveTrainTeleOp(hardwareMap, dtReverse);
        bannerBox = new BannerBox(hardwareMap);
        purplePixel = new PurplePixel(hardwareMap);
    }

}
