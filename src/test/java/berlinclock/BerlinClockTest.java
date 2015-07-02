package berlinclock;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BerlinClockTest {
    private static final String OFF = "OFF";

    private final BerlinClock clock = new BerlinClock();

    @Test
    public void allLampsOffForNewlyCreatedClock() {
        assertThat(clock.getYellowLamp()).isEqualTo(OFF);
        assertThat(clock.displayHourLamps()).isEqualTo("top:\n\nbottom:\n");
        assertThat(clock.displayMinuteLamps()).isEqualTo("top:\n\nbottom:\n");
    }

    @Test
    public void yellowLampIsOffWhenClockHasAnOddNumberOfSeconds() {
        clock.setSeconds(1);
        assertThat(clock.getYellowLamp()).isEqualTo(OFF);
    }

    @Test
    public void yellowLampIsOnWhenClockHasAnEvenNumberOfSeconds() {
        clock.setSeconds(2);
        assertThat(clock.getYellowLamp()).isEqualTo("YELLOW");
    }

    @Test
    public void onlyLeftBottomRedLampIsOnWhenHourIsOne() {
        clock.setHours(1);
        clock.setSeconds(0);

        String hourLamps = clock.displayHourLamps();
        assertThat(hourLamps).isEqualTo("top:\n\nbottom:\nRED ");
    }

    @Test
    public void allTopRedLampsAreOnWhenHourIsTwenty() {
        clock.setHours(20);
        clock.setSeconds(0);

        String hourLamps = clock.displayHourLamps();
        assertThat(hourLamps).isEqualTo("top:\nRED RED RED RED \nbottom:\n");
    }

    @Test
    public void allBottomRedLampsAreOnWhenHourIsTwentyFour() {
        clock.setHours(24);
        clock.setSeconds(0);

        String hourLamps = clock.displayHourLamps();
        assertThat(hourLamps).isEqualTo("top:\nRED RED RED RED \nbottom:\nRED RED RED RED ");
    }

    @Test
    public void oneYellowLampShownWhenClockDisplaysFiveMinutes() {
        clock.setHours(0);
        clock.setMinutes(5);
        clock.setSeconds(0);

        String minuteLamps = clock.displayMinuteLamps();
        assertThat(minuteLamps).isEqualTo("top:\nYELLOW \nbottom:\n");
    }

    @Test
    public void redLampShownWhenClockDisplaysQuarterPastForMinutes() {
        clock.setHours(0);
        clock.setMinutes(15);
        clock.setSeconds(0);

        String minuteLamps = clock.displayMinuteLamps();
        assertThat(minuteLamps).isEqualTo("top:\nYELLOW YELLOW RED \nbottom:\n");
    }

    @Test
    public void twoRedLampsShownWhenClockDisplaysHalfPast() {
        clock.setHours(0);
        clock.setMinutes(30);
        clock.setSeconds(0);

        String minuteLamps = clock.displayMinuteLamps();
        assertThat(minuteLamps).isEqualTo("top:\nYELLOW YELLOW RED YELLOW YELLOW RED \nbottom:\n");
    }

    @Test
    public void threeRedLampsShownWhenClockDisplaysQuarterTo() {
        clock.setHours(0);
        clock.setMinutes(45);
        clock.setSeconds(0);

        String minuteLamps = clock.displayMinuteLamps();
        assertThat(minuteLamps).isEqualTo("top:\nYELLOW YELLOW RED YELLOW YELLOW RED YELLOW YELLOW RED \nbottom:\n");
    }

    @Test
    public void allLightsInTopRowForMinutesShownForFiftyFive() {
        clock.setHours(0);
        clock.setMinutes(55);
        clock.setSeconds(0);

        String minuteLamps = clock.displayMinuteLamps();
        assertThat(minuteLamps).isEqualTo("top:\nYELLOW YELLOW RED YELLOW YELLOW RED YELLOW YELLOW RED YELLOW YELLOW \nbottom:\n");
    }

    @Test
    public void allBottomLightsForMinutesShownForFiftyNine() {
        clock.setHours(0);
        clock.setMinutes(59);
        clock.setSeconds(0);

        assertThat(clock.displayMinuteLamps()).isEqualTo("top:\nYELLOW YELLOW RED YELLOW YELLOW RED YELLOW YELLOW RED YELLOW YELLOW \nbottom:\nYELLOW YELLOW YELLOW YELLOW ");
    }

    @Test
    public void fullySetClockShowsCorrectLampDisplay() {
        clock.setHours(16);
        clock.setMinutes(37);
        clock.setSeconds(16);

        assertThat(clock.getYellowLamp()).isEqualTo("YELLOW");
        assertThat(clock.displayHourLamps()).isEqualTo("top:\nRED RED RED \nbottom:\nRED ");
        assertThat(clock.displayMinuteLamps()).isEqualTo("top:\nYELLOW YELLOW RED YELLOW YELLOW RED YELLOW \nbottom:\nYELLOW YELLOW ");
    }
}
