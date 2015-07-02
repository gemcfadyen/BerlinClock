package berlinclock;

import static berlinclock.ClockStatus.OFF;
import static berlinclock.ClockStatus.YELLOW;

public class YellowLamp {

    public String display(int seconds) {
        if (even(seconds)) {
            return YELLOW.toString();
        }
        return OFF.toString();
    }

    private boolean even(int seconds) {
        return seconds % 2 == 0;
    }
}
