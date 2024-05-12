package saves.faradaycode.components;

import com.qualcomm.robotcore.hardware.*;
import saves.faradaycode.*;

public class ServoSave implements deviceNames {

    //values for servo pos
    public double upPos = 1;
    public double downPos = 0;

    //inits servo objects
    public Servo dummyServo;

    //inits object and assigns servo names
    public ServoSave(HardwareMap hardwareMap) {
        dummyServo = hardwareMap.get(Servo.class, dummyServoName);
    }

    //what gets called
    public void iterate(boolean up, boolean down) {
        if (up) moveUp();
        if (down) moveDown();
    }

    //functions
    //use 'OpModes.nerf' to grab nerf value for servo testing
    public void moveUp() {
        dummyServo.setPosition(upPos);
    }
    public void moveDown() {
        dummyServo.setPosition(downPos);
    }
}
