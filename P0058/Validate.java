package P0058;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Validate {
    Scanner sc = new Scanner(System.in);

    public int checkInputLimit(String input) {
        int result = 0;
        while (true) {
            try {
                result = Integer.parseInt(input);
                if (result < 1 || result > 4) {
                    System.out.println("Please enter a number 1 to 4");
                    System.out.print("Your choice: ");
                    input = sc.next();
                    continue;
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number from 1 to 4");
                System.out.print("Your choice: ");
                input = sc.next();
            }
        }
    }

    public boolean checkInputYN() {
        while (true) {
            String result = checkInputString("choice");
            if (result.equalsIgnoreCase("Y"))
                return true;
            if (result.equalsIgnoreCase("N"))
                return false;
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter choice: ");
        }
    }

    public String checkInputString(String information) {
        Pattern pattern = Pattern.compile("^[a-zA-Z\s]+$");
        while (true) {
            String result = sc.nextLine().trim();
            Matcher matcher = pattern.matcher(result);
            if (result.isEmpty()) {
                System.out.println("Cannot be empty");
                System.out.print("Enter " + information + ": ");
            } else if (!matcher.find()) {
                System.out.println("Cannot contain numbers or special characters");
                System.out.print("Enter " + information + ": ");
            } else
                return result;
        }
    }

}
