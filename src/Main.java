import Controllers.*;
import SortAlg.BubbleSort;
import SortAlg.SelectionSort;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {

    private static final AtomicBoolean isSortingRunning = new AtomicBoolean(true);
    private static final AnimationController animationController = new AnimationController();
    private static final ArrayController arrayController = new ArrayController();
    private static final LogController logController = new LogController();
    private static final SelectionSort selectionSort = new SelectionSort();
    private static final BubbleSort bubbleSort = new BubbleSort();
    private static final UserController userController = new UserController();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        boolean runAgain = true;
        do {
            LocalDateTime start = LocalDateTime.now();
            String logString = TimeController.getTimeAndHour("Benchmarking starting...!", 0, start, true) + "\n";
            System.out.println();
            int value = userController.userInput();

            animationController.run(isSortingRunning).start();
            arrayController.run();

            logString = selectionSort.run(logString, arrayController, value) + "\n";
            logString = bubbleSort.run(logString, arrayController, value);
            LocalDateTime end = LocalDateTime.now();
            logString = logString + "\n" + TimeController.getTimeAndHour(
                    ( "Average time is the following: " + TimeController.getAverageTime()),
                    0, end, true);
            logString = logString + TimeController.getTimeAndHour(
                    ("Total time of benchmark is: " + TimeController.getTotalTimeNow()),
                    0, end, true);

            isSortingRunning.set(false);
            animationController.run(isSortingRunning).join();
            logController.fileWriter(logString);
            System.out.println("\n\nFinished!\n");

            // Ask user if they want to perform another benchmark run or close the program
            boolean validInput = false;
            while (!validInput) {
                System.out.print("Do you want to perform another benchmark run? (yes/no): ");
                String input = scanner.next();
                if ("yes".equalsIgnoreCase(input)) {
                    TimeController.resetIntegers();
                    isSortingRunning.set(true);
                    validInput = true; // Exit the loop if valid input is provided
                } else if ("no".equalsIgnoreCase(input)) {
                    System.out.println("\nThanks for running!");
                    runAgain = false;
                    validInput = true; // Exit the loop if valid input is provided
                } else {
                    System.out.println("\nThat's not a valid option!");
                    scanner.nextLine();
                }
            }
        } while (runAgain);
    }
}