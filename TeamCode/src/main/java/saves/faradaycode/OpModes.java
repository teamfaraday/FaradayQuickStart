package saves.faradaycode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import saves.faradaycode.components.*;

public abstract class OpModes extends LinearOpMode{

    public ServoSave servoSave;
    public CRServoSave crServoSave;
    public DCMotorSave dcMotorSave;
    public DriveTrainTeleOp driveTrainTeleOp;

    public NerfSlow NerfSlow = new NerfSlow();
    public ElapsedTime timer = new ElapsedTime();

    public boolean stopped = false;
    public static double nerf = 1;
    public static boolean isSlow = false;
    public static double slowAmnt = 1.0;

    public void turnOn() {
        driveTrainTeleOp = new DriveTrainTeleOp(hardwareMap);
        servoSave = new ServoSave(hardwareMap);
        crServoSave = new CRServoSave(hardwareMap);
        dcMotorSave = new DCMotorSave(hardwareMap);



    }

}
