package berlinclock;


import java.util.List;

public class Display {
    private static final String SEPARATOR = " ";

    public static String display(List<ClockStatus> lamps) {
        StringBuffer presentation = new StringBuffer();
        for (ClockStatus status : lamps) {
            presentation.append(status);
            presentation.append(SEPARATOR);
        }
        return presentation.toString();
    }
}