package P0061;

import java.util.Scanner;

public class Validation {
    static Scanner sc = new Scanner(System.in);

    public static double checkDouble(String input) {
        double result = 0;
        try {
            result = Double.parseDouble(input);
            if (result <= 0) {
                System.out.println("You must enter a number which is greater than 0");
                System.out.print("Enter again: ");
                input = sc.next();
                return checkDouble(input);
            }
            return result;
        } catch (NumberFormatException e) {
            System.out.println("You must enter a number");
            System.out.print("Enter again: ");
            input = sc.next();
            return checkDouble(input);
        }
    }

    public static boolean checkTriangle(double sideA, double sideB, double sideC) {
        if (sideA + sideB < sideC || sideA + sideC < sideB || sideB + sideC < sideA)
            return false;
        return true;
    }
}
