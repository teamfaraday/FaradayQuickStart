package saves.faradaycode.components;

public class Nerf {

    //constants
    double nerfVal = 1;
    double nerfInc = 0.001;

    //iterates
    public double iterate(boolean increase, boolean decrease) {
        if (increase) nerfVal += nerfInc;
        if (decrease) nerfVal -= nerfInc;
        return nerfVal;
    }

}