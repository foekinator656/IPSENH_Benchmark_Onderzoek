import java.util.ArrayList;

public class SelectionSort {
    void sort(ArrayList<Long> arr){
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

    // Prints the array
    void printArray(ArrayList<Long> arr){
        for (Long aLong : arr) {
            System.out.print(aLong + " ");
        }
        System.out.println();
    }


    // Driver code to test above
//    public static void main(String args[]){
//        SelectionSort ob = new SelectionSort();
//        ob.sort(arr);
//        ob.printArray(arr);
//    }
}
