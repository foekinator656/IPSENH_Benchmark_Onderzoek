package Controllers;

import java.util.Scanner;

public class UserController {


    private final Scanner scanner = new Scanner(System.in);

    public int userInput() {
        int value;
        do {
            System.out.print("Give a value that you want the Algorithms to run with (non-negative): ");
            value = scanner.nextInt();
            System.out.println();

            if (value < 0 ) System.out.println("\nYou gave an negative value, try again!");
        } while (value < 0);

        scanner.nextLine();

        return value;
    }
}
