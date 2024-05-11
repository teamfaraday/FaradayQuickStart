package org.firstinspires.ftc.teamcode.faradaycode.TeleOp;
import org.firstinspires.ftc.teamcode.faradaycode.OpModes;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "TeleIsOpping")
public class TeleIsOpping extends OpModes {
    public void runOpMode(){
        super.turnOn(true);

        waitForStart();

        drone.init();
        bannerBox.intakePos(nerf);
        while (opModeIsActive() && !stopped){
            telemetry.addData("nerf", nerf);
            telemetry.update();

            isSlow = gamepad1.right_trigger > 0.6;
            nerf = Nerf.iterate(gamepad1.dpad_right, gamepad1.dpad_left);

            driveTrainTeleOp.iterate(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);
            if (gamepad1.a || gamepad1.b) intake.iterate(gamepad1.a, gamepad1.b);
            if (gamepad1.left_trigger > 0.6 && gamepad1.right_trigger > 0.6) drone.iterate(true);
            if(gamepad1.x || gamepad1.y || gamepad1.right_bumper) bannerBox.iterate(gamepad1.x,gamepad1.y,gamepad1.right_bumper);
            if (gamepad1.dpad_up || gamepad1.dpad_down) hang.iterate(gamepad1.dpad_up, gamepad1.dpad_down);
            slide.iterate(gamepad1.right_bumper,gamepad1.left_bumper, (gamepad1.a || gamepad1.b));
            stopped = gamepad1.left_bumper && gamepad1.left_trigger > 0.6 && gamepad1.right_bumper && gamepad1.right_trigger > 0.6;
        }
    }
}