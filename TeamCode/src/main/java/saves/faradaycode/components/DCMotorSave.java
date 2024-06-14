package saves.faradaycode.components;

import com.qualcomm.robotcore.hardware.*;

import saves.faradaycode.*;

public class DCMotorSave implements  deviceNames{

    //speeds for rotation
    public double power1 = 1;
    public double power2 = -1;

    //amnt to slow smth down by
    public double slowConst = 0.5;

    //inits servo objects
    public DcMotor dummyDCMotor;

    //inits object and assigns servo names
    public DCMotorSave(HardwareMap hardwareMap) {
        dummyDCMotor = hardwareMap.dcMotor.get(dummyDCMotorName);
        dummyDCMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    //when called, parse through for motion
    public void iterate(boolean forward, boolean reverse) {
        if (forward) {
            activate();
        } else if (reverse) {
            reverse();
        } else{
            deactivate();
        }
    }

    //functions
    public void activate() {
        dummyDCMotor.setPower(power1 * OpModes.nerf * ((OpModes.isSlow) ? slowConst: OpModes.slowAmnt));
    }
    public void deactivate() {
        dummyDCMotor.setPower(0);
    }
    public void reverse() {
        dummyDCMotor.setPower(power2 * OpModes.nerf * ((OpModes.isSlow) ? slowConst: OpModes.slowAmnt));
    }

    //for Auto
    public void activate(double speed) {
        dummyDCMotor.setPower(speed);
    }

    public void encoderRun(int ticks) {
        int encoderPos;
        encoderPos = dummyDCMotor.getCurrentPosition();
        encoderPos -= (ticks);

        dummyDCMotor.setTargetPosition(encoderPos);
        dummyDCMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while ( dummyDCMotor.isBusy()) {
            dummyDCMotor.setPower(Math.abs(power1));
        }

        dummyDCMotor.setPower(0);
        dummyDCMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
}
