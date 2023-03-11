package SortAlg;

import java.util.ArrayList;

public class SelectionSort {

    public static void sort(ArrayList<Long> arr){
        int n = arr.size();
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++){
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr.get(j) < arr.get(min_idx))
                    min_idx = j;
            // Swap the found minimum element with the first
            // element
            Long temp = arr.get(min_idx);
            arr.set(min_idx, arr.get(i));
            arr.set(i, temp);
        }
    }

    public static void runSort(ArrayGenerator arrayGenerator) {
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
