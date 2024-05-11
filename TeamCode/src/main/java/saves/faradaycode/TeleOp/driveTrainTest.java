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

        while (opModeIsActive() && !stopped){
            isSlow = gamepad1.right_trigger > 0.6;
            driveTrainTeleOp.iterate(gamepad1.left_stick_y, -gamepad1.right_stick_x, -gamepad1.left_stick_x);
        }
    }
}