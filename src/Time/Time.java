package Time;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Time {
    public static ArrayList<Integer> integers = new ArrayList<>();

    public static String getAverageTime() {
        float total = 0;

        System.out.println(integers);
        integers.remove(integers.size() - 1);
        System.out.println(integers);

        for (int integer : integers) {
            System.out.printf("Value of second in the bench mark is as follows: %s\n", integer);
            total = total + integer;
            System.out.println(total);
        }

        float avg = total / (integers.size());

        System.out.println("Average time is as follows: " + avg);
        return String.valueOf(avg);
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
