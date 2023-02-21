import java.util.ArrayList;

public class BubbleSort {
    void bubbleSortWithSwapCounter(ArrayList<Long> arr){
        int n = arr.size();
        int i,j;
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

    /* Prints the array */
    void printArray(ArrayList<Long> arr) {
        for (Long j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
//
//    // Driver method to test above
//    public static void main(String args[])    {
//        BubbleSort bs = new BubbleSort();
//        int arr1[] = {64, 34, 25, 12, 22, 11, 90};
//        int arr2[] = {8, 4, 6, 3, 1, 7, 2};
//        System.out.println("array1 ongesorteerd = " );
//        bs.printArray(arr1);
//        bs.bubbleSortWithSwapCounter(arr1);
//        System.out.println("arr1 gesorteerd = ");
//        bs.printArray(arr1);
//
//    }

}
