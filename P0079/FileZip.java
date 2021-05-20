package P0079;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

class FileZip {
    public boolean compressTo(String pathSrc, String fileName, String pathCompress) {

        File src = new File(pathSrc);
        if (src.isDirectory()) {
            // File des = new File(pathCompress);

            File[] folder = src.listFiles();
            if (folder.length == 0)
                return false;
            try {
                ZipOutputStream fileZipper = new ZipOutputStream(
                        new FileOutputStream(pathCompress + File.separator + fileName));
                for (File file : folder) {
                    FileInputStream fileReader = new FileInputStream(file);
                    ZipEntry zipEntry = new ZipEntry(file.getName());
                    fileZipper.putNextEntry(zipEntry);
                    byte[] bytes = new byte[1024];
                    int length;
                    while ((length = fileReader.read(bytes)) >= 0) {
                        fileZipper.write(bytes, 0, length);
                    }
                    fileReader.close();
                }
                fileZipper.close();

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            try {
                ZipOutputStream fileZipper = new ZipOutputStream(new FileOutputStream(fileName));
                FileInputStream fileReader = new FileInputStream(src);
                ZipEntry zipEntry = new ZipEntry(src.getName());
                fileZipper.putNextEntry(zipEntry);
                byte[] bytes = new byte[1024];
                int length;
                while ((length = fileReader.read(bytes)) >= 0) {
                    fileZipper.write(bytes, 0, length);
                }
                fileReader.close();
                fileZipper.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return true;

    }

    public boolean extractTo(String pathZipFile, String pathExtract) {
        byte[] bytes = new byte[1024];
        try {
            File src = new File(pathZipFile);
            ZipInputStream fileUnzipper = new ZipInputStream(new FileInputStream(src));
            ZipEntry zipEntry = fileUnzipper.getNextEntry();
            while (zipEntry != null) {
                File unzippedFile = new File(pathExtract + File.separator + zipEntry.getName());

                new File(unzippedFile.getParent()).mkdirs();
                FileOutputStream fileWriter = new FileOutputStream(unzippedFile);
                int length;
                while ((length = fileUnzipper.read(bytes)) >= 0) {
                    fileWriter.write(bytes, 0, length);
                }
                fileWriter.close();
                zipEntry = fileUnzipper.getNextEntry();
            }
            fileUnzipper.closeEntry();
            fileUnzipper.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public void showAllFiles(String pathSource) {
        File src = new File(pathSource);
        for (File file : src.listFiles()) {
            System.out.println(file.getName());
        }
    }

    public static void main(String[] args) {
        FileZip prog = new FileZip();
        Validate validator = new Validate();
        Scanner sc = new Scanner(System.in);
        int option = 0;
        while (option != 3) {
            menu();
            option = validator.checkInputLimit(sc.next());
            switch (option) {
            case 1:
                System.out.println("---------- Compression --------");
                System.out.print("Enter Source Folder: ");
                String pathSource = validator.checkInputString("Source Folder");
                if (!validator.checkExistFolder(pathSource))
                    break;
                System.out.print("Enter Destination Folder: ");
                String desSource = validator.checkInputString("Destination Folder");
                if (!validator.checkExistFolder(desSource))
                    break;
                System.out.print("Enter Name: ");
                String name = validator.checkInputString("Name");
                if (prog.compressTo(pathSource, name + ".zip", desSource)) {
                    prog.showAllFiles(pathSource);
                    System.out.println("Successfully");
                } else {
                    System.out.println("Source Folder is empty");
                }
                break;
            case 2:
                System.out.println("---------- Extraction ---------");
                System.out.print("Enter Source file: ");
                String fileSource = validator.checkInputString("Source file");
                if (!validator.checkFile(fileSource))
                    break;
                System.out.print("Enter Destination Folder: ");
                desSource = validator.checkInputString("Destination Folder");
                if (!validator.checkExistFolder(desSource))
                    break;
                if (prog.extractTo(fileSource, desSource)) {
                    prog.showAllFiles(desSource);
                    System.out.println("Successfully");
                } else {
                    System.out.println("Failed");
                }
                break;
            case 3:
                break;
            }
        }
    }

    public static void menu() {
        System.out.println("========= Zipper program =========");
        System.out.println("1. Compression");
        System.out.println("2. Extraction");
        System.out.println("3. Exit");
        System.out.print("Your choice: ");
    }
}