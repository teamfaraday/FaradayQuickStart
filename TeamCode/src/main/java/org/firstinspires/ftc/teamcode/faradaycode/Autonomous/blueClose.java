package org.firstinspires.ftc.teamcode.faradaycode.Autonomous;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;

import org.firstinspires.ftc.robotcore.external.tfod.Recognition;

import saves.faradaycode.components.tFodPipeline;
import saves.roadrunner.trajectorysequence.TrajectorySequence;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.tfod.TfodProcessor;
import org.firstinspires.ftc.robotcore.external.hardware.camera.BuiltinCameraDirection;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import saves.roadrunner.drive.SampleMecanumDrive;


import java.util.List;
import saves.faradaycode.OpModes;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "blueClose")
public class blueClose extends OpModes {
    tFodPipeline tFod = new tFodPipeline();

    public boolean isLeft = false;
    public boolean isCent = false;
    public boolean isRight = false;

    public void runOpMode() {
        super.turnOn();
        super.driveTrainTeleOp.autonDirs();
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        tFod.initTfod(true);
        telemetry.addData("DS preview on/off", "3 dots, Camera Stream");
        telemetry.addData(">", "Touch Play to start OpMode");
        telemetry.update();

        /*telemetry.addData("Recs", currentRecognitions);
        telemetry.update();*/

        while (opModeInInit()) {tFod.telemetryTfod();}

        Pose2d startPose = new Pose2d(0, 0, 0);
        Vector2d testLeftPose = new Vector2d(2,5);
        Vector2d testCentPose = new Vector2d(4,-6);
        Vector2d yellowLeftPose = new Vector2d(21,35);
        Vector2d yellowCentPose = new Vector2d(28,35);
        Vector2d yellowRightPose = new Vector2d(34,35);
        Vector2d parkPose1 = new Vector2d(3,30);
        Vector2d parkPose3 = new Vector2d(3,43);
        Vector2d testAndPurpleRightPose = new Vector2d(30.5, -9);


        waitForStart();

       // purplePixel.init();
      //  slide.slowUp();
      //  bannerBox.intakePos(1);

        if (isStopRequested()) return;

        TrajectorySequence testLeft = drive.trajectorySequenceBuilder(startPose)
                .strafeTo(testLeftPose)
                .build();

        TrajectorySequence purpleLeft = drive.trajectorySequenceBuilder(testLeft.end())
                .splineTo(new Vector2d(26, 4), Math.toRadians(0))
                .build();

        TrajectorySequence yellowLeft = drive.trajectorySequenceBuilder(purpleLeft.end())
                .back(5)
                .splineTo(new Vector2d(26, 27), Math.toRadians(-92.5))
                .strafeTo(yellowLeftPose)
                .build();

        TrajectorySequence parkLeft = drive.trajectorySequenceBuilder(yellowLeft.end())
                .strafeTo(parkPose1)
                .strafeTo(parkPose3)
                .build();

        TrajectorySequence testCent = drive.trajectorySequenceBuilder(testLeft.end())
                .strafeTo(testCentPose)
                .build();

        TrajectorySequence purpleCent = drive.trajectorySequenceBuilder(testCent.end())
                .splineTo(new Vector2d(32, -7), Math.toRadians(0))
                .build();

        TrajectorySequence yellowCent = drive.trajectorySequenceBuilder(purpleCent.end())
                .back(5)
                .splineTo(new Vector2d(26, 27), Math.toRadians(-93))
                .strafeTo(yellowCentPose)
                .build();

        TrajectorySequence parkCent = drive.trajectorySequenceBuilder(yellowCent.end())
                .strafeTo(parkPose1)
                .strafeTo(parkPose3)
                .build();

        TrajectorySequence testAndPurpleRight = drive.trajectorySequenceBuilder(testCent.end())
                .strafeTo(testAndPurpleRightPose)
                .turn(Math.toRadians(-95))
                .build();

        TrajectorySequence yellowRight = drive.trajectorySequenceBuilder(testAndPurpleRight.end())
                .back(5)
                .splineTo(new Vector2d(26, 27), Math.toRadians(-93))
                .strafeTo(yellowRightPose)
                .build();

        TrajectorySequence parkRight = drive.trajectorySequenceBuilder(yellowRight.end())
                .strafeTo(parkPose1)
                .strafeTo(parkPose3)
                .build();


        drive.setPoseEstimate(startPose);

        sleep(2000);

        //actual auto

        drive.followTrajectorySequence(testLeft);

        List<Recognition> currentRecognitions;
        currentRecognitions = tFod.tfod.getRecognitions();

        if (currentRecognitions.size() != 0 && !stopped) {

            isLeft = true;
        //    slide.antiGrav();

        } else {
         //   slide.antiGrav();
            drive.followTrajectorySequence(testCent);

            currentRecognitions = tFod.tfod.getRecognitions();
            if (currentRecognitions.size() != 0 && !stopped) {
                isCent = true;
            } else {
                isRight = true;
            }
        }


        if (isLeft) {drive.followTrajectorySequence(purpleLeft);}
        if (isCent) {drive.followTrajectorySequence(purpleCent);}
        if (isRight) {drive.followTrajectorySequence(testAndPurpleRight);}
      //  purplePixel.release();
        sleep(1000);
        if (isLeft) {drive.followTrajectorySequence(yellowLeft);}
        if (isCent) {drive.followTrajectorySequence(yellowCent);}
        if (isRight) {drive.followTrajectorySequence(yellowRight);}
            isSlow = true;
     //       slide.up();
        sleep(1600);
       //     slide.antiGrav();
        //    bannerBox.dropPos(1);
        sleep(1000);
       //     bannerBox.intakePos(1);
            isSlow = true;
         //   slide.down();
        sleep(1400);
          //  slide.antiGrav();
        if (isLeft) {drive.followTrajectorySequence(parkLeft);}
        if (isCent) {drive.followTrajectorySequence(parkCent);}
        if (isRight) {drive.followTrajectorySequence(parkRight);}

        tFod.telemetryTfod();

        // Push telemetry to the Driver Station.
        telemetry.update();
    }



}