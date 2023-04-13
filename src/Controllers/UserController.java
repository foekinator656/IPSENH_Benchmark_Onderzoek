package Controllers;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserController {

    private final Scanner scanner = new Scanner(System.in);

    public int userInput() {
        int value;

        do {
            System.out.print("Give a value that you want the Algorithms to run with (non-negative): ");
            try {
                if (scanner.hasNextInt()) {
                    value = scanner.nextInt();
                    if (value < 0 ) System.out.println("\nYou gave an negative value, try again!");
                } else {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                String input = scanner.next();

                if (input.contains(",") && input.contains(".")) {
                    System.out.print("\nYou gave a floating-point value, please enter an integer!");
                    System.out.println();
                } else {
                    System.out.print("\nYou gave a non-integer value, try again!");
                    System.out.println();
                }

                scanner.nextLine();
                value = -1;
            }
        } while (value < 0);

        scanner.nextLine();
        return value;
    }
}
