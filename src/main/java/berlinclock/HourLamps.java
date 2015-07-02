package berlinclock;

import java.util.ArrayList;
import java.util.List;

import static berlinclock.ClockStatus.RED;

public class HourLamps { private List topLamps; private List bottomLamps;

    public HourLamps(int numberOfTopLamps, int numberOfBottomLamps) {
        this.topLamps = new ArrayList<>(numberOfTopLamps);
        this.bottomLamps = new ArrayList<>(numberOfBottomLamps);
    }

    public String display(int hours) {
        configureLampsToShow(hours);
        return display();
    }

    private String display() {
        StringBuffer lampDisplay = new StringBuffer();

        lampDisplay.append("top:\n");
        lampDisplay.append(Display.display(topLamps));

        lampDisplay.append("\nbottom:\n");
        lampDisplay.append(Display.display(bottomLamps));

        return lampDisplay.toString();
    }

    private void configureLampsToShow(int hours) {
        while (hours > 0) {
            if (multipleOfFive(hours)) {
                hours = configureTopRowOfLamps(hours);
                continue;
            }
            hours = configureBottomRowOfLamps(hours);
        }
    }

    private int configureBottomRowOfLamps(int hours) {
        bottomLamps.add(RED);
        hours = hours - 1;
        return hours;
    }

    private int configureTopRowOfLamps(int hours) {
        topLamps.add(RED);
        hours = hours - 5;
        return hours;
    }

    private boolean multipleOfFive(int hours) {
        return hours % 5 == 0;
    }
}