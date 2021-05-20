package P0054;

import java.util.Scanner;

import java.util.List;
import java.util.ArrayList;

public class Validation {
    static Scanner sc = new Scanner(System.in);

    public static int checkInputLimit(String input) {
        int result = 0;
        try {
            result = Integer.parseInt(input);
            if (result < 1 || result > 4) {
                System.out.println("Please enter a number 1 to 4");
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

    public static int checkID(String input) {
        int result = 0;
        try {
            result = Integer.parseInt(input);
            if (result < 0) {
                System.out.println("ID must be greater than 0");
                System.out.print("Enter ID: ");
                input = sc.next();
                return checkID(input);
            }
            return result;
        } catch (NumberFormatException e) {
            System.out.println("ID is digit");
            System.out.print("Enter ID: ");
            input = sc.next();
            return checkID(input);
        }
    }

    public static String checkInputString(String information) {
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.out.println(information + " cannot be empty");
                System.out.print("Enter " + information + ": ");
            } else
                return result;
        }
    }

    public static String checkInputPhone() {
        List<String> phoneList = getPhoneList();
        while (true) {
            String result = sc.nextLine().trim();
            if (!phoneList.contains(result)) {
                System.out.println("Please input Phone flow");
                displayPhoneList(phoneList);
                System.out.println("Enter Phone: ");
            } else
                return result;

        }
    }

    public static List<String> getPhoneList() {
        List<String> phoneList = new ArrayList<>();
        phoneList.add("123456789");
        phoneList.add("123-456-7890");
        phoneList.add("123-456-7890 x1234");
        phoneList.add("123-456-7890 ext1234");
        phoneList.add("123.456.7890");
        phoneList.add("123 456 7890");
        return phoneList;
    }

    public static void displayPhoneList(List<String> phoneList) {
        for (String phone : phoneList) {
            System.out.println("*" + phone);
        }
    }
}
