package saves.faradaycode.components;
import saves.faradaycode.OpModes;

public class NerfSlow {

    //constants
    double nerfInc = 0.001;

    //iterates
    public void iterate(double slowVal, boolean increase, boolean decrease) {
        OpModes.nerf += (increase) ? nerfInc : ((decrease) ? -nerfInc : 0);
        OpModes.slowAmnt = 1 - slowVal;
        //OpModes.isSlow = slowVal >= 0.6;
    }

}