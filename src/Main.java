import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
        LocalDateTime startBenchmark = LocalDateTime.now();
        String logString = "Start benchmark! at: " + startBenchmark + "!\n";
        System.out.println(dtf.format(startBenchmark));

        ArrayGenerator arrayGenerator = new ArrayGenerator();

        LocalDateTime startSelectionSortBenchmark = LocalDateTime.now();
        logString = logString + "Start SelectionSort Benchmark!  "+startSelectionSortBenchmark+"!\n";
        System.out.println(dtf.format(startSelectionSortBenchmark));
        runSelectionSort(arrayGenerator);


        LocalDateTime startBubbleSort = LocalDateTime.now();
        logString = logString + "Start BubbleSort Benchmark!  "+startBubbleSort+"!\n";
        System.out.println(dtf.format(startBubbleSort));
        runBubbleSort(arrayGenerator);

        LocalDateTime endBenchmark = LocalDateTime.now();
        System.out.println(dtf.format(endBenchmark));

        logString = logString + "Total time of benchmark is: " + compareTime(startBenchmark,endBenchmark) +"!\n";

        LogFile.fileWriter(logString);
    }

    public static String compareTime(LocalDateTime start, LocalDateTime end){
        int startHour = start.getHour();
        int endHour = end.getHour();
        int benchHour = endHour-startHour;


        int startMin = start.getMinute();
        int endMin = end.getMinute();
        int benchMin = endMin-startMin;
        if (benchMin < 0) benchMin = (endMin+60) - startMin;

        int startSec = start.getSecond();
        int endSec = end.getSecond();
        int benchSec = endSec - startSec;
        if (benchSec < 0) benchSec = (endSec+60) - startSec;

        String totalTime = benchHour + " uur, " + benchMin + " min, " + benchSec + "sec";
        System.out.println(totalTime);
        return totalTime;
    }

    public static void runSelectionSort(ArrayGenerator arrayGenerator){
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(arrayGenerator.hundredNumbersLongList);
        selectionSort.sort(arrayGenerator.thousandNumbersLongList);
        selectionSort.sort(arrayGenerator.tenThousandNumbersLongList);
        selectionSort.sort(arrayGenerator.hundredThousandNumbersLongList);
    }

    public static void runBubbleSort(ArrayGenerator arrayGenerator){
        BubbleSort bubbleSort = new BubbleSort();

        bubbleSort.bubbleSortWithSwapCounter(arrayGenerator.hundredNumbersLongList);

        bubbleSort.bubbleSortWithSwapCounter(arrayGenerator.thousandNumbersLongList);

        bubbleSort.bubbleSortWithSwapCounter(arrayGenerator.tenThousandNumbersLongList);

        bubbleSort.bubbleSortWithSwapCounter(arrayGenerator.hundredThousandNumbersLongList);

    }

}