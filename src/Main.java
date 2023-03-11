import SortAlg.ArrayGenerator;
import SortAlg.BubbleSort;
import SortAlg.SelectionSort;
import Time.Time;
import java.time.LocalDateTime;

public class Main {

    public static String runSelectBS(String logString, ArrayGenerator arrayGenerator, DateTimeFormatter dtf) {
        int i = 0;
        do {
            LocalDateTime begin = LocalDateTime.now();
            logString = logString + String.format("(%s: %s/%s/%s %s:%s:%S): Start SortAlg.SelectionSort Benchmark!\n",
                    ""+i+"", begin.getYear(), begin.getMonthValue(), begin.getDayOfMonth(), begin.getHour(),
                    begin.getMinute(), begin.getSecond());
            SelectionSort.run(arrayGenerator);
            LocalDateTime eind = LocalDateTime.now();
            i++;
            Time.setValuesIntoIntegerList(begin, eind);
            System.out.println("SelectionSort: " + Time.getTotalTimeNow());
        } while (i <= 4);
        // TODO: Change value to <= 4
        return logString;
    }

    public static String runBubbleBS(String logString, ArrayGenerator arrayGenerator, DateTimeFormatter dtf) {
        int i = 0;
        do {
            LocalDateTime begin = LocalDateTime.now();
            logString = logString + String.format("(%s: %s/%s/%s %s:%s:%S): Start SortAlg.BubbleSort Benchmark!\n",
                    ""+i+"", begin.getYear(), begin.getMonthValue(), begin.getDayOfMonth(), begin.getHour(),
                    begin.getMinute(), begin.getSecond());
            BubbleSort.run(arrayGenerator);
            LocalDateTime eind = LocalDateTime.now();
            i++;
            Time.setValuesIntoIntegerList(begin, eind);
            System.out.println("SelectionSort: " + Time.getTotalTimeNow());
        } while (i <= 4);
        // TODO: Change value to <= 4
        return logString;
    }

    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
        ArrayGenerator arrayGenerator = new ArrayGenerator();
        LocalDateTime startBenchmark = LocalDateTime.now();
        String logString = String.format("(%s/%s/%s %s:%s:%S): Benchmarking starting...!\n\n", startBenchmark.getYear(),
                startBenchmark.getMonthValue(), startBenchmark.getDayOfMonth(), startBenchmark.getHour(),
                startBenchmark.getMinute(), startBenchmark.getSecond());

        arrayGenerator.fillHundredNumbers();
        arrayGenerator.fillThousandNumbers();
        arrayGenerator.fillTenThousandNumbers();
        arrayGenerator.fillHundredThousandNumbers();

        logString = runSelectBS(logString, arrayGenerator, dtf);
//        logString = runBubbleBS(logString, arrayGenerator, dtf);

        System.out.println("The average time of the run is: " + Time.getAverageTime() + "\n");
        System.out.println("The format of the end of the benchmark is: " + Time.getTotalTimeNow() + "\n");

        logString = logString + "Total time of benchmark is: " + Time.getTotalTimeNow() + "!\n";

        logString = logString + "Average time is the following: " + Time.getAverageTime() + "\n";

        LogFile.fileWriter(logString);

    }
}