package P0077;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileReader {

    public int countWordInFile(String fileSource, String word) throws Exception {
        int count = 0;
        Pattern pattern = Pattern.compile(Pattern.quote(word));
        Scanner sc = new Scanner(new File(fileSource));
        String empty = "";
        while (sc.hasNext()) {
            empty += sc.next();
        }
        Matcher m = pattern.matcher(empty);
        while (m.find()) {
            count++;
        }
        return count;
    }

    public List<String> getFileNameContainsWordInDirectory(String source, String word) throws Exception {
        List<String> fileList = new ArrayList<String>();
        Pattern pattern = Pattern.compile(Pattern.quote(word));
        File folder = new File(source);
        File[] fileArr = folder.listFiles();
        for (File file : fileArr) {
            Scanner sc = new Scanner(file);
            String empty = "";
            while (sc.hasNext()) {
                empty += sc.next();
            }
            Matcher m = pattern.matcher(empty);
            if (m.find())
                fileList.add(file.getName());
        }
        return fileList;
    }

    public void displayFileList(List<String> fileList) {
        if (fileList.isEmpty()) {
            System.out.println("Not found");
            return;
        }
        System.out.println("---------- File Name ----------");
        for (String fileName : fileList) {
            System.out.println(fileName);
        }

    }

    public boolean checkFile(String fileSource) {
        File file = new File(fileSource);
        return file.exists();
    }

    public boolean checkFolder(String source) {
        File folder = new File(source);
        File[] fileArr = folder.listFiles();
        return (fileArr.length == 0 ? false : true);
    }

    public static void main(String[] args) {
        FileReader program = new FileReader();
        Validate validator = new Validate();
        Scanner sc = new Scanner(System.in);
        int option = 0;
        while (option != 3) {
            menu();
            option = validator.checkInputLimit(sc.next());
            switch (option) {
                case 1:
                    System.out.println("---------- Count Word ----------");
                    System.out.print("Enter Path: ");
                    String path = validator.checkInputString("Path");
                    System.out.print("Enter Word: ");
                    String word = validator.checkInputString("Word");
                    try {
                        if (program.checkFile(path))
                            System.out.println(program.countWordInFile(path, word));
                        else
                            System.out.println("File does not exist");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("---------- Find File By Word ----------");
                    System.out.print("Enter Path: ");
                    path = validator.checkInputString("Path");
                    System.out.print("Enter Word: ");
                    word = validator.checkInputString("Word");
                    try {
                        if (program.checkFolder(path))
                            program.displayFileList(program.getFileNameContainsWordInDirectory(path, word));
                        else
                            System.out.println("Folder is empty");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
            }
        }
    }

    public static void menu() {
        System.out.println("========== Word Program =========");
        System.out.println("1. Count Word In File");
        System.out.println("2. Find File By Word");
        System.out.println("3. Exit");
        System.out.print("Your option: ");
    }
}
