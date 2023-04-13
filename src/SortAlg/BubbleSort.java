package SortAlg;

import Controllers.ArrayController;
import Controllers.TimeController;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class BubbleSort {

    private void sort(ArrayList<Long> arr){
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

    private void fillSort(ArrayController arrayController) {
        ArrayList<Long>[] arrays = new ArrayList[] {
                arrayController.hundredNumbers,
                arrayController.thousandNumbers,
                arrayController.tenThousandNumbers,
                arrayController.hundredThousandNumbers
        };

        for (ArrayList<Long> tempArray : arrays) {
            sort(tempArray);
        }
    }

    public String run(String logString, ArrayController arrayController, int value) {
        int i = 0;

        do {
            LocalDateTime start = LocalDateTime.now();
            logString = logString + TimeController.getTimeAndHour("Start SortAlg.BubbleSort Benchmark!", i, start, false);

            fillSort(arrayController);

            LocalDateTime end = LocalDateTime.now();
            TimeController.setValuesIntoIntegerList(start, end);
            i++;
        } while (i <= value);

        return logString;
    }
}
