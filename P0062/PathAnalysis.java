package P0062;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PathAnalysis {
    String[] pathArr = new String[10];

    public PathAnalysis(String path) {
        pathArr = path.replaceAll(Pattern.quote("\\"), "\\\\").split("\\\\");
    }

    public String getPath() {
        String path = "";
        for (String str : pathArr) {
            if (str.equals(pathArr[pathArr.length - 2])) {
                path += str;
                break;
            }
            if (!str.contains("."))
                path += str + "\\";
        }
        return path;
    }

    public String getFileName() {
        String[] fileNameArr = pathArr[pathArr.length - 1].split("[.]");
        return fileNameArr[0];
    }

    public String getExtension() {
        String[] fileNameArr = pathArr[pathArr.length - 1].split("[.]");
        return fileNameArr[1];
    }

    public String getDisk() {
        return pathArr[0];
    }

    public String[] getFolders() {
        ArrayList<String> list = new ArrayList<>();

        for (int i = 1; i < pathArr.length - 1; i++) {
            list.add(pathArr[i]);
        }
        return list.toArray(new String[0]);
    }

    public void display() {
        System.out.println("----- Result Analysis -----");
        System.out.println("Disk: " + getDisk());
        System.out.println("Extension: " + getExtension());
        System.out.println("File Name: " + getFileName());
        System.out.println("Path " + getPath());
        System.out.println("Folder: " + Arrays.toString(getFolders()));

    }

    public String checkInputString() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else
                return result;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("===== Analysis Path Program =====");
        System.out.print("Please in put Path: ");
        PathAnalysis programn = new PathAnalysis(sc.next());
        programn.display();

    }

}
