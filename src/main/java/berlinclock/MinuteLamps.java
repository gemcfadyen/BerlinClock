package berlinclock;

import java.util.ArrayList;
import java.util.List;

import static berlinclock.ClockStatus.RED;
import static berlinclock.ClockStatus.YELLOW;
import static com.google.common.collect.Lists.reverse;

public class MinuteLamps {
    private final List topLamps;
    private final List bottomLamps;

    public MinuteLamps(int numberOfLampsInTopRow, int numberOfLampsInBottomRow) {
        this.topLamps = new ArrayList<>(numberOfLampsInTopRow);
        this.bottomLamps = new ArrayList<>(numberOfLampsInBottomRow);
    }

    public String display(int minutes) {
        configureLampsToShow(minutes);
        return display();
    }

    private String display() {
        StringBuffer lampDisplay = new StringBuffer();
        lampDisplay.append("top:\n");
        lampDisplay.append(Display.display(reverse(topLamps)));
        lampDisplay.append("\nbottom:\n");
        lampDisplay.append(Display.display(reverse(bottomLamps)));

        return lampDisplay.toString();
    }

    private void configureLampsToShow(int minutes) {
        while (minutes > 0) {

            if (multipleOf(15, minutes)) {
                minutes = configureTopRowOfLamps(minutes, RED);
                continue;
            }

            if (multipleOf(5, minutes)) {
                minutes = configureTopRowOfLamps(minutes, YELLOW);
                continue;
            }


            minutes = configureBottomRowOfLamps(minutes);
        }
    }

    private int configureBottomRowOfLamps(int hours) {
        bottomLamps.add(YELLOW);
        hours = hours - 1;
        return hours;
    }

    private int configureTopRowOfLamps(int hours, ClockStatus status) {
        topLamps.add(status);
        hours = hours - 5;
        return hours;
    }

    private boolean multipleOf(int multiple, int minutes) {
        return (minutes % multiple == 0);
    }
}

