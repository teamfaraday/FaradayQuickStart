package org.firstinspires.ftc.teamcode.faradaycode.TeleOp;
import org.firstinspires.ftc.teamcode.faradaycode.OpModes;
import org.firstinspires.ftc.teamcode.faradaycode.components.DriveTrain.DriveTrainTeleOp;


@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "driveTrainTest")
public class driveTrainTest extends OpModes {
    public DriveTrainTeleOp driveTrainTeleOp;


    public void runOpMode(){
        driveTrainTeleOp = new DriveTrainTeleOp(hardwareMap, true);

        waitForStart();

        while (opModeIsActive() && !stopped){
            isSlow = gamepad1.right_trigger > 0.6;
            driveTrainTeleOp.iterate(gamepad1.left_stick_y, -gamepad1.right_stick_x, -gamepad1.left_stick_x);
        }
    }
}