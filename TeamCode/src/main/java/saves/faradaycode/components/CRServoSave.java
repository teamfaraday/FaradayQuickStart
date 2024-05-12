package saves.faradaycode.components;

import com.qualcomm.robotcore.hardware.*;

import saves.faradaycode.*;

public class CRServoSave implements  deviceNames{

    //speeds for rotation
    public double power1 = 1;
    public double power2 = -1;

    //amnt to slow smth down by
    public double slowConst = 0.5;

    //inits servo objects
    public CRServo dummyCRServo;

    //inits object and assigns servo names
    public CRServoSave(HardwareMap hardwareMap) {
        dummyCRServo = hardwareMap.crservo.get(dummyCRServoName);
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
        dummyCRServo.setPower(power1 * OpModes.nerf * ((OpModes.isSlow) ? slowConst: 1));
    }
    public void deactivate() {
        dummyCRServo.setPower(0);
    }
    public void reverse() {
        dummyCRServo.setPower(power2 * OpModes.nerf * ((OpModes.isSlow) ? slowConst: 1));
    }
}
