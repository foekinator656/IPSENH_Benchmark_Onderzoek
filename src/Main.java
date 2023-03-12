import Controllers.*;
import SortAlg.BubbleSort;
import SortAlg.SelectionSort;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {

    private static final AtomicBoolean isSortingRunning = new AtomicBoolean(true);
    private static final AnimationController animationController = new AnimationController();
    private static final ArrayController arrayController = new ArrayController();
    private static final LogController logController = new LogController();
    private static final SelectionSort selectionSort = new SelectionSort();
    private static final BubbleSort bubbleSort = new BubbleSort();
    private static final UserController userController = new UserController();

    //TODO: if the benchmarks done ask another run or close program
    //TODO: check for invalid values, for example: "exits" not working but "exit" working
    public static void main(String[] args) throws InterruptedException {
        LocalDateTime start = LocalDateTime.now();
        String logString = TimeController.getTimeAndHour("Benchmarking starting...!", 0, start, true) + "\n";
        int value = userController.userInput();

        animationController.run(isSortingRunning).start();
        arrayController.run();

        logString = selectionSort.run(logString, arrayController, value) + "\n";
        logString = bubbleSort.run(logString, arrayController, value);
        LocalDateTime end = LocalDateTime.now();
        logString = logString + "\n" + TimeController.getTimeAndHour(( "Average time is the following: " + TimeController.getAverageTime()), 0, end, true);
        logString = logString + TimeController.getTimeAndHour(("Total time of benchmark is: " + TimeController.getTotalTimeNow()), 0, end, true);

        isSortingRunning.set(false);
        animationController.run(isSortingRunning).join();
        logController.fileWriter(logString);
        System.out.println("\n\nFinished!");
    }
}