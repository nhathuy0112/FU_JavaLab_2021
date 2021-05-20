package P0079;

import java.io.File;
import java.util.Scanner;

public class Validate {
    Scanner sc = new Scanner(System.in);

    public int checkInputLimit(String input) {
        int result = 0;
        while (true) {
            try {
                result = Integer.parseInt(input);
                if (result < 1 || result > 4) {
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
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.out.println("Cannot be empty");
                System.out.print("Enter " + information + ": ");
            } else
                return result;
        }
    }

    public boolean checkExistFolder(String pathSource) {
        File src = new File(pathSource);
        if (!src.isDirectory()) {
            System.out.println("Path does not exist. Do you want to create? (Y/N)");
            System.out.print("Enter choice: ");
            if (checkInputYN()) {
                try {
                    src.mkdirs();
                    System.out.println(src.getAbsolutePath() + " created successfully");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else
                return false;
        }
        return true;
    }

    public boolean checkEmptyFolder(String pathSource) {
        File src = new File(pathSource);
        try {
            if (src.listFiles().length == 0) {
                System.out.println("Folder is empty");
                return false;
            }

        } catch (Exception e) {
        }
        return true;
    }

    public boolean checkFile(String fileSource) {
        File src = new File(fileSource);
        if (!src.isFile()) {
            System.out.println("Cannot find this file");
            return false;
        } else {
            if (!fileSource.endsWith(".zip")) {
                System.out.println("Not support this file format");
                return false;
            }
            return true;
        }
    }

}
