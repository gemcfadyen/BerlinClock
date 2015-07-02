package berlinclock;

public class BerlinClock {
    private final YellowLamp yellowLamp;
    private final HourLamps hourLamps;
    private final MinuteLamps minuteLamps;

    private int seconds = -1;
    private int hours;
    private int minutes;

    public BerlinClock() {
        this.yellowLamp = new YellowLamp();
        this.hourLamps = new HourLamps(4, 4);
        this.minuteLamps = new MinuteLamps(11, 4);
    }

    public String getYellowLamp() {
        return yellowLamp.display(seconds);
    }

    public String displayHourLamps() {
        return hourLamps.display(hours);
    }

    public String displayMinuteLamps() {
        return minuteLamps.display(minutes);
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }
}
