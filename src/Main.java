import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
        LocalDateTime startBenchmark = LocalDateTime.now();
        String logString = "Start benchmark! at: " + startBenchmark + "!\n";
        System.out.println(dtf.format(startBenchmark));

        ArrayGenerator arrayGenerator = new ArrayGenerator();
        int i= 0;
        do {
            LocalDateTime startSelectionSortBenchmark = LocalDateTime.now();
            logString = logString + "Start SelectionSort Benchmark!"+"("+i+") "+startSelectionSortBenchmark+"!\n";
            System.out.println(dtf.format(startSelectionSortBenchmark));
            runSelectionSort(arrayGenerator);
            i++;
        } while (i <= 1000);

        i=0;
        do {
            LocalDateTime startBubbleSort = LocalDateTime.now();
            logString = logString + "Start BubbleSort Benchmark!"+"("+i+") "+startBubbleSort+"!\n";
            System.out.println(dtf.format(startBubbleSort));
            runBubbleSort(arrayGenerator);
            i++;
        } while (i <= 1000);


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
        ArrayList<Long> tempArray = arrayGenerator.hundredNumbersLongList;
        selectionSort.sort(tempArray);
        tempArray = arrayGenerator.thousandNumbersLongList;
        selectionSort.sort(tempArray);
        tempArray = arrayGenerator.tenThousandNumbersLongList;
        selectionSort.sort(tempArray);
        tempArray = arrayGenerator.hundredThousandNumbersLongList;
        selectionSort.sort(tempArray);
    }

    public static void runBubbleSort(ArrayGenerator arrayGenerator){
        BubbleSort bubbleSort = new BubbleSort();
        ArrayList<Long> tempArray = arrayGenerator.hundredNumbersLongList;
        bubbleSort.bubbleSortWithSwapCounter(tempArray);
        tempArray = arrayGenerator.thousandNumbersLongList;
        bubbleSort.bubbleSortWithSwapCounter(tempArray);
        tempArray = arrayGenerator.tenThousandNumbersLongList;
        bubbleSort.bubbleSortWithSwapCounter(tempArray);
        tempArray = arrayGenerator.hundredThousandNumbersLongList;
        bubbleSort.bubbleSortWithSwapCounter(tempArray);

    }

}