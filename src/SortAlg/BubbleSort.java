package SortAlg;

import Controllers.ArrayController;
import Controllers.TimeController;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class BubbleSort {

    public void sort(ArrayList<Long> arr){
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

    public void runSort(ArrayController arrayController) {
        ArrayList<Long> tempArray = arrayController.hundredNumbers;
        sort(tempArray);
        tempArray = arrayController.thousandNumbers;
        sort(tempArray);
        tempArray = arrayController.tenThousandNumbers;
        sort(tempArray);
        tempArray = arrayController.hundredThousandNumbers;
        sort(tempArray);
    }

    public String run(String logString, ArrayController arrayController, int value) {
        int i = 0;

        do {
            LocalDateTime start = LocalDateTime.now();
            logString = logString + TimeController.getTimeAndHour("Start SortAlg.BubbleSort Benchmark!", i, start, false);

            runSort(arrayController);

            LocalDateTime end = LocalDateTime.now();
            TimeController.setValuesIntoIntegerList(start, end);
            i++;
        } while (i <= value);

        return logString;
    }
}
