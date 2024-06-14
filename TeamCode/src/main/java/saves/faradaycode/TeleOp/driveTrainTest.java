package saves.faradaycode.TeleOp;

import saves.faradaycode.components.*;
import saves.faradaycode.OpModes;
import com.qualcomm.robotcore.eventloop.opmode.*;

@Disabled
@TeleOp(name = "driveTrainTest")
public class driveTrainTest extends OpModes {
    public DriveTrainTeleOp driveTrainTeleOp;

    public void runOpMode(){
        driveTrainTeleOp = new DriveTrainTeleOp(hardwareMap);

        waitForStart();
        timer.reset();

        while (opModeIsActive() && !stopped){
            NerfSlow.iterate(gamepad1.left_trigger, gamepad1.dpad_right, gamepad1.dpad_left);
            driveTrainTeleOp.iterate(gamepad1.left_stick_y, -gamepad1.right_stick_x, -gamepad1.left_stick_x);
        }
    }
}