public class Main {
    public static void main(String[] args) {
        ArrayGenerator arrayGenerator = new ArrayGenerator();
        System.out.println(arrayGenerator.hundredNumbersLongList);

        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(arrayGenerator.hundredNumbersLongList);
        selectionSort.printArray(arrayGenerator.hundredNumbersLongList);

        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSortWithSwapCounter(arrayGenerator.hundredNumbersLongList);
        bubbleSort.printArray(arrayGenerator.hundredNumbersLongList);
    }
}