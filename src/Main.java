import SortAlg.ArrayGenerator;
import SortAlg.SelectionSort;
import Time.Time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static SortAlg.BubbleSort.run;

public class Main {
    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
        LocalDateTime startBenchmark = LocalDateTime.now();
        String logString = "Start benchmark! at: " + startBenchmark + "!\n";
        System.out.println(dtf.format(startBenchmark));

        arrayGenerator.fillHundredNumbers();
        arrayGenerator.fillThousandNumbers();
        arrayGenerator.fillTenThousandNumbers();
        arrayGenerator.fillHundredThousandNumbers();

        logString = runSelectBS(logString, arrayGenerator, dtf);
        logString = runBubbleBS(logString, arrayGenerator, dtf);

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