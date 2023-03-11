package Time;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Time {
    public static ArrayList<Integer> integers = new ArrayList<>();

    public static void setValuesIntoIntegerList(LocalDateTime start, LocalDateTime end) {
        int second = end.getSecond() - start.getSecond();

        if (second < 0) second = (end.getSecond() + 60) - start.getSecond();
        integers.add(second);
    }

    public static String getAverageTime() {
        float total = 0;

        for (int integer : integers) {
            total = total + integer;
        }

        float avg = total / (integers.size());

        return String.valueOf(avg);
    }

    public static String getTotalTimeNow() {
        int hour = 0;
        int minute = 0;
        float second = 0;

        for (int integer : integers) {
            second = second + integer;
        }

        if (second >= 60) {
            minute = minute + 1;
            second = second - 60;
        }
        if (minute >= 60) {
            hour = hour + 1;
            minute = minute - 60;
        }

        return String.format("%s uur, %s minuten, %s seconden", hour, minute, second);
    }
}
