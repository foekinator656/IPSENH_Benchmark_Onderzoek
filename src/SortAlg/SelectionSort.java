package SortAlg;

import Controllers.ArrayController;
import Controllers.TimeController;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class SelectionSort {

    private void SS_sort(ArrayList<Long> arr){
        int n = arr.size();

        for (int i = 0; i < n-1; i++) {
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr.get(j) < arr.get(min_idx))
                    min_idx = j;

            Long temp = arr.get(min_idx);
            arr.set(min_idx, arr.get(i));
            arr.set(i, temp);
        }
    }

    private void runSort(ArrayController arrayController) {
        ArrayList<Long> tempArray = arrayController.hundredNumbers;
        SS_sort(tempArray);
        tempArray = arrayController.thousandNumbers;
        SS_sort(tempArray);
        tempArray = arrayController.tenThousandNumbers;
        SS_sort(tempArray);
        tempArray = arrayController.hundredThousandNumbers;
        SS_sort(tempArray);
    }

    public String run(String logString, ArrayController arrayController, int value) {
        int i = 0;

        do {
            LocalDateTime start = LocalDateTime.now();
            logString = logString + TimeController.getTimeAndHour("Start SortAlg.SelectionSort Benchmark!", value, start, false);

            runSort(arrayController);

            LocalDateTime end = LocalDateTime.now();
            TimeController.setValuesIntoIntegerList(start, end);
            i++;
        } while (i <= value);

        return logString;
    }
}
