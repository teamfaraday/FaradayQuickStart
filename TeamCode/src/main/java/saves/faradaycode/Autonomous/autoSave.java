package saves.faradaycode.Autonomous;

import com.acmerobotics.roadrunner.geometry.*;

import org.firstinspires.ftc.robotcore.external.tfod.Recognition;

import java.util.List;

import saves.faradaycode.OpModes;
import saves.faradaycode.components.DCMotorSave;
import saves.faradaycode.components.tFodPipeline;
import saves.roadrunner.drive.SampleMecanumDrive;
import saves.roadrunner.drive.StandardTrackingWheelLocalizer;
import saves.roadrunner.trajectorysequence.TrajectorySequence;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "autoSave")
public class autoSave extends OpModes {
    //instantiate camera detection
    tFodPipeline tFod = new tFodPipeline();

    //when u run the thing
    public void runOpMode() {
        //set up drivetrain stuffs (and also turn on any other hardware you might want)
        super.turnOn();
        super.driveTrainTeleOp.autonDirs();
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);
        //StandardTrackingWheelLocalizer myLocalizer = new StandardTrackingWheelLocalizer(hardwareMap); //FGURE THIS OUT
        //also figure out how to pass through odometry pos
        //figure out more advanced stuffs
        //read thru rr thingy

        //initiate tfod status
        tFod.initTfod(true);
        telemetry.addData("DS preview on/off", "3 dots, Camera Stream");
        telemetry.addData(">", "Touch Play to start OpMode");
        telemetry.update();
        while (opModeInInit()) {tFod.telemetryTfod();}

        //init stuff
        waitForStart();
        servoSave.moveUp();

        if (isStopRequested()) return;

        //create trajectories
        TrajectorySequence traj1 = drive.trajectorySequenceBuilder( new Pose2d(0, 0, 0)) //plug in coords of where the robot should be at the moment
                .lineToLinearHeading(new Pose2d(41, 34.8, Math.toRadians(0))) // just a strafe
                .splineTo(new Vector2d(10,10),Math.toRadians(90)) //a spline is a vector + a degree rotation
                .forward(1) //self explanatory
                .back(1) //also self explanatory
                .turn(Math.toRadians(90)) //also self explanatory
                .build();


        //drive.getPoseEstimate(); //gets current pos thru rr


        //initiate start coords (all coords are relative based on these start coords)
        drive.setPoseEstimate( new Pose2d(0, 0, 0));

        //sleep for camera to boot up
        sleep(2000);


        //tfod detection
        List<Recognition> currentRecognitions;
        currentRecognitions = tFod.tfod.getRecognitions();

        if (currentRecognitions.size() != 0 && !stopped) {
            dcMotorSave.activate(0.5); //you can still run normal commands in here, you can use this in conjunction with encoders to run synchronous tasks + get precision

            //actual auto, you use this to follow traj sequences
            drive.followTrajectorySequence(traj1);

            dcMotorSave.deactivate();
            dcMotorSave.encoderRun(1000);
            isSlow = true;
            sleep(1000);
        }

    }
}