package P0077;

import java.util.Scanner;

public class Validate {
    Scanner sc = new Scanner(System.in);

    public int checkInputLimit(String input) {
        int result = 0;
        while (true) {
            try {
                result = Integer.parseInt(input);
                if (result < 1 || result > 3) {
                    System.out.println("Please enter a number 1 to 3");
                    System.out.print("Your choice: ");
                    input = sc.next();
                    continue;
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number from 1 to 3");
                System.out.print("Your choice: ");
                input = sc.next();
            }
        }
    }

    public String checkInputString(String information) {
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.out.println("Cannot be empty");
                System.out.print("Enter " + information + ": ");
            } else
                return result;
        }
    }
}
