import Controllers.AnimationController;
import Controllers.ArrayController;
import Controllers.LogController;
import SortAlg.BubbleSort;
import SortAlg.SelectionSort;
import Controllers.TimeController;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        final AtomicBoolean isSortingRunning = new AtomicBoolean(true);
        AnimationController animationController = new AnimationController();
        ArrayController arrayController = new ArrayController();
        SelectionSort selectionSort = new SelectionSort();
        BubbleSort bubbleSort = new BubbleSort();
        Scanner scanner = new Scanner(System.in);
        LocalDateTime start = LocalDateTime.now();
        String logString = TimeController.getTimeAndHour("Benchmarking starting...!", 0, start, true) + "\n";

        int value;
        do {
            System.out.print("Give a value that you want the Algorithms to run with (non-negative): ");
            value = scanner.nextInt();
            System.out.println();

            if (value < 0 ) System.out.println("\nYou gave an negative value, try again!");
        } while (value < 0);

        scanner.nextLine();

        Thread animationThread = new Thread(() -> {
            int i = 1;
            while (isSortingRunning.get()) {
                animationController.animate(i + " Seconds busy.");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
            }
        });

        animationThread.start();
        arrayController.run();

        logString = selectionSort.run(logString, arrayController, value) + "\n";
        logString = bubbleSort.run(logString, arrayController, value);

        LocalDateTime end = LocalDateTime.now();
        logString = logString + "\n" + TimeController.getTimeAndHour(( "Average time is the following: " + TimeController.getAverageTime()), 0, end, true);
        logString = logString + TimeController.getTimeAndHour(("Total time of benchmark is: " + TimeController.getTotalTimeNow()), 0, end, true);

        isSortingRunning.set(false);
        animationThread.join();

        LogController.fileWriter(logString);
        System.out.println("\n\nFinished!");
    }
}