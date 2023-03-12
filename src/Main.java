import Controllers.AnimationController;
import Controllers.ArrayController;
import Controllers.LogController;
import SortAlg.BubbleSort;
import SortAlg.SelectionSort;
import Controllers.TimeController;
import java.time.LocalDateTime;

public class Main {

    public static String runSelectionSort(String logString, ArrayGenerator arrayGenerator) {
        int i = 0;
        do {
            LocalDateTime begin = LocalDateTime.now();
            logString = logString + Time.getTimeAndHour("Start SortAlg.SelectionSort Benchmark!", i, begin, false);

            SelectionSort.runSort(arrayGenerator);
            LocalDateTime end = LocalDateTime.now();

            Time.setValuesIntoIntegerList(begin, end);
            i++;
        } while (i <= 4);

        return logString;
    }

    public static String runBubbleSort(String logString, ArrayGenerator arrayGenerator) {
        int i = 0;
        do {
            LocalDateTime begin = LocalDateTime.now();
            logString = logString + Time.getTimeAndHour("Start SortAlg.BubbleSort Benchmark!", i, begin, false);

            BubbleSort.runSort(arrayGenerator);
            LocalDateTime end = LocalDateTime.now();

            Time.setValuesIntoIntegerList(begin, end);
            i++;
        } while (i <= 4);

        return logString;
    }

    // TODO: Fix that you can have an input from user through terminal for how many runs.
    public static void main(String[] args) {
        ArrayGenerator arrayGenerator = new ArrayGenerator();
        LocalDateTime startBenchmark = LocalDateTime.now();
        String logString = Time.getTimeAndHour("Benchmarking starting...!", 0, startBenchmark, true) + "\n";

        arrayGenerator.run();

        logString = runSelectionSort(logString, arrayGenerator) + "\n";
        logString = runBubbleSort(logString, arrayGenerator);

        logString = logString + "\n" + Time.getTimeAndHour(( "Average time is the following: " + Time.getAverageTime()), 0, startBenchmark, true);
        logString = logString + Time.getTimeAndHour(("Total time of benchmark is: " + Time.getTotalTimeNow()), 0, startBenchmark, true);

        LogFile.fileWriter(logString);
    }
}