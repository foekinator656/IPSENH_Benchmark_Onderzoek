import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        int count = 0;
        while (count <= 1000){
            ArrayGenerator arrayGenerator = new ArrayGenerator();
            runSelectionSort(arrayGenerator);
            runBubbleSort(arrayGenerator);
            count++;
        }
        System.out.println(dtf.format(now));
    }

    public static void runSelectionSort(ArrayGenerator arrayGenerator){
        SelectionSort selectionSort = new SelectionSort();

        selectionSort.sort(arrayGenerator.hundredNumbersLongList);
        selectionSort.printArray(arrayGenerator.hundredNumbersLongList);

        selectionSort.sort(arrayGenerator.thousandNumbersLongList);
        selectionSort.printArray(arrayGenerator.thousandNumbersLongList);

        selectionSort.sort(arrayGenerator.tenThousandNumbersLongList);
        selectionSort.printArray(arrayGenerator.tenThousandNumbersLongList);

        selectionSort.sort(arrayGenerator.hundredThousandNumbersLongList);
        selectionSort.printArray(arrayGenerator.hundredThousandNumbersLongList);

        selectionSort.sort(arrayGenerator.thousandNumbersLongList);
        selectionSort.printArray(arrayGenerator.thousandNumbersLongList);

        selectionSort.sort(arrayGenerator.millionNumbersLongList);
        selectionSort.printArray(arrayGenerator.millionNumbersLongList);
    }

    public static void runBubbleSort(ArrayGenerator arrayGenerator){
        BubbleSort bubbleSort = new BubbleSort();

        bubbleSort.bubbleSortWithSwapCounter(arrayGenerator.hundredNumbersLongList);
        bubbleSort.printArray(arrayGenerator.hundredNumbersLongList);

        bubbleSort.bubbleSortWithSwapCounter(arrayGenerator.thousandNumbersLongList);
        bubbleSort.printArray(arrayGenerator.thousandNumbersLongList);

        bubbleSort.bubbleSortWithSwapCounter(arrayGenerator.tenThousandNumbersLongList);
        bubbleSort.printArray(arrayGenerator.tenThousandNumbersLongList);

        bubbleSort.bubbleSortWithSwapCounter(arrayGenerator.tenThousandNumbersLongList);
        bubbleSort.printArray(arrayGenerator.tenThousandNumbersLongList);


    }

}