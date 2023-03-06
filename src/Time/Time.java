package Time;

import java.time.LocalDateTime;

public class Time {

//    public static totalTime(int[] values) {
//
//    }

    public static int getTotalTime(int[] values) {
        int value = 0;

        for (int actualValue : values) {
            value = value + actualValue;
        }

        return value;
    }

    public static String getAverageTime(LocalDateTime start, LocalDateTime end) {
//        int totalTime = getTotalTime(start, end);

        return "Total time is returned";
    }

    public static String getTotalTimeNow(LocalDateTime start, LocalDateTime end){
        int startHour = start.getHour();
        int endHour = end.getHour();
        int benchHour = endHour - startHour;

        int startMin = start.getMinute();
        int endMin = end.getMinute();
        int benchMin = endMin - startMin;
        if (benchMin < 0) benchMin = (endMin + 60) - startMin;

        int startSec = start.getSecond();
        int endSec = end.getSecond();
        int benchSec = endSec - startSec;
        if (benchSec < 0) benchSec = (endSec + 60) - startSec;

        String totalTime = benchHour + " uur, " + benchMin + " min, " + benchSec + "sec";
        System.out.println(totalTime);
        return totalTime;
    }

//    public static String getTotalTime(LocalDateTime start, LocalDateTime end){
//        int startHour = start.getHour();
//        int endHour = end.getHour();
//        int benchHour = endHour - startHour;
//
//        int startMin = start.getMinute();
//        int endMin = end.getMinute();
//        int benchMin = endMin - startMin;
//        if (benchMin < 0) benchMin = (endMin + 60) - startMin;
//
//        int startSec = start.getSecond();
//        int endSec = end.getSecond();
//        int benchSec = endSec - startSec;
////        if (benchSec < 0) benchSec = (endSec + 60) - startSec;
//
//        String totalTime = benchHour + " uur, " + benchMin + " min, " + benchSec + "sec";
//        System.out.println(totalTime);
//        return totalTime;
//    }
}
