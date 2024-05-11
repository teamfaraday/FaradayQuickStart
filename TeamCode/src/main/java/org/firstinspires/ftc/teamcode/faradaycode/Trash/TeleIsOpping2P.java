/*package org.firstinspires.ftc.teamcode.faradaycode.Trash;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.faradaycode.OpModes;

@Disabled
@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "TeleIsOpping2P")
public class TeleIsOpping2P extends OpModes {
    public void runOpMode(){
        super.turnOn(true);
        driveTrainTeleOp.reverseDir();

        waitForStart();

        drone.init();
        bannerBox.intakePos(nerf);

        /*
        p1:
            drivetrain
            intake
        p2:
            slides
            box
            hang
            drone


        while (opModeIsActive() && !stopped){

            telemetry.addData("nerf", nerf);
            telemetry.update();

            //drivetrain
            driveTrainTeleOp.iterate(isSlow1, nerf, gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);

            //intake
            if (gamepad1.b) {
                intake.activate(isSlow1, nerf);
                slide.slowDown();
            } else if (gamepad1.a) {
                intake.reverse(isSlow1, nerf);
                slide.slowDown();
            } else{
                intake.deactivate();
            }

            //slide
            if (gamepad2.left_bumper){
                slide.down(isSlow2, nerf);
                bannerBox.intakePos(nerf);
            } else if (gamepad2.right_bumper) {
                slide.up(isSlow2, nerf);
            } else {
                slide.antiGrav();
            }

            //hang
            if (gamepad2.dpad_up) {
                hang.up(isSlow2, nerf);
            } else if (gamepad2.dpad_down) {
                hang.down(isSlow2, nerf);
            } else {
                hang.deactivate();
            }

            //drone
            if (gamepad2.left_trigger > 0.6 && gamepad2.right_trigger > 0.6){
                drone.launch();
            }

            //bannerbox
            if (gamepad2.y) {
                bannerBox.dropPos(nerf);
            }
            if (gamepad2.x) {
                bannerBox.intakePos(nerf);
            }

            //nerf
            if (gamepad1.dpad_right || gamepad2.dpad_right) {
                nerf += 0.00001;
            }
            if (gamepad1.dpad_left || gamepad2.dpad_left) {
                nerf -= 0.00001;
            }

            //failsafe
            if (gamepad1.left_bumper && gamepad1.left_trigger >= 0.6 && gamepad1.right_bumper && gamepad1.right_trigger >= 0.6 || gamepad2.left_bumper && gamepad2.left_trigger >= 0.6 && gamepad2.right_bumper && gamepad2.right_trigger >= 0.6) { stopped = true;}

            //slow movement
            isSlow2 = gamepad2.right_trigger >= 0.6;
            isSlow1 = gamepad1.right_trigger >= 0.6;

        }
    }
}*/