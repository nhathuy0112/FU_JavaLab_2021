package P0052;

import java.util.Scanner;

public class Validation {
    static Scanner sc = new Scanner(System.in);

    public static int checkInputLimit(String input) {
        int result = 0;
        try {
            result = Integer.parseInt(input);
            if (result < 1 || result > 5) {
                System.out.println("Please enter a number 1 to 5");
                System.out.print("Your choice: ");
                input = sc.next();
                return checkInputLimit(input);
            }
            return result;

        } catch (NumberFormatException e) {
            System.out.println("Please enter a number from 1 to 5");
            System.out.print("Your choice: ");
            input = sc.next();
            return checkInputLimit(input);
        }

    }

    public static float checkTotalArea(String str) {
        float totalArea = 0;
        try {
            totalArea = Float.parseFloat(str);
            if (totalArea <= 0) {
                System.out.println("Total area must be greater than 0");
                System.out.println("Enter total Area: ");
                str = sc.nextLine();
                return checkTotalArea(str);
            }
            return totalArea;
        } catch (NumberFormatException e) {
            System.out.println("Total area must be a number");
            System.out.println("Enter total Area: ");
            str = sc.nextLine();
            return checkTotalArea(str);
        }

    }

    public static String checkInputString(String information) {
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.out.println(information + " cannot be empty!!!!!!!");
                System.out.println("Enter " + information + ": ");
            } else
                return result;
        }
    }

    public static boolean isNullArray(EastAsiaCountries[] countries) {
        boolean check = true;
        for (int i = 0; i < countries.length; i++) {
            if (countries[i] != null)
                check = false;
        }
        return check;
    }

    public static boolean isDuplicated(EastAsiaCountries[] countries, EastAsiaCountries country) {
        boolean check = false;
        for (int i = 0; i < 11; i++) {
            if (country.equals(countries[i]))
                check = true;
        }
        return check;
    }
}
