import SortAlg.ArrayGenerator;
import SortAlg.SelectionSort;
import Time.Time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static SortAlg.BubbleSort.run;

public class Main {

    public static String runSelectBS(String logString, ArrayGenerator arrayGenerator, DateTimeFormatter dtf) {
        int i = 0;
        do {
            LocalDateTime begin = LocalDateTime.now();
            logString = logString + String.format("(%s: %s/%s/%s %s:%s:%S): Start SortAlg.SelectionSort Benchmark!\n",
                    ""+i+"", begin.getYear(), begin.getMonthValue(), begin.getDayOfMonth(), begin.getHour(),
                    begin.getMinute(), begin.getSecond());
            System.out.println(dtf.format(begin));
            SelectionSort.run(arrayGenerator);
            LocalDateTime eind = LocalDateTime.now();
            i++;
            System.out.println(eind + "\n");
            System.out.println("De compared tijd is als volgt: ");
            Time.getTotalTimeNow(begin, eind);
            System.out.println("===================================");
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
            System.out.println(dtf.format(begin));
            run(arrayGenerator);
            i++;
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
        logString = runBubbleBS(logString, arrayGenerator, dtf);

        LocalDateTime endBenchmark = LocalDateTime.now();
        System.out.println(dtf.format(endBenchmark));

        logString = logString + "Total time of benchmark is: " + Time.getTotalTimeNow(startBenchmark, endBenchmark) + "!\n";

        LogFile.fileWriter(logString);
    }
}