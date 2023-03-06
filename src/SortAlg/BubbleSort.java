package SortAlg;

import java.util.ArrayList;

public class BubbleSort {

    public static void sort(ArrayList<Long> arr){
        int n = arr.size();
        int i, j;
        int swapCounter = -1;
        while (swapCounter != 0) {
            swapCounter = 0;
            for (i = 0; i < n - 1; i++) {
                for (j = 0; j < n - i - 1; j++) {
                    if (arr.get(j) > arr.get(j + 1)) {
                        // swap arr[j+1] and arr[j]
                        Long temp = arr.get(j);
                        arr.set(j, arr.get(j + 1));
                        arr.set(j + 1, temp);
                        swapCounter++;
                    }
                }
            }
            if (swapCounter == 0) break;
        }
    }

    public static void run(ArrayGenerator arrayGenerator) {
        ArrayList<Long> tempArray = arrayGenerator.hundredNumbers;
        sort(tempArray);
        tempArray = arrayGenerator.thousandNumbers;
        sort(tempArray);
        tempArray = arrayGenerator.tenThousandNumbers;
        sort(tempArray);
        tempArray = arrayGenerator.hundredThousandNumbers;
        sort(tempArray);
    }
}
