package P0055;

import java.util.Scanner;

public class DoctorMain {
    static String code;
    static String name;
    static String specialization;
    static int availability;
    static Scanner input = new Scanner(System.in);
    static DoctorHash program = new DoctorHash();
    
    public static void main(String[] args) {
        int option = 0;
        while(option != 5){
            menu();
            option = input.nextInt();
            switch(option){
                case 1:
                    System.out.println("--------- Add Doctor ---------");
                    Doctor doctor = getDoctor();
                    try {
                        if(program.addDoctor(doctor))
                            System.out.println("Added!");
                    } catch (Exception e) {
                    }
                    break;
                case 2:
                    System.out.println("--------- Update Doctor ---------");
                    doctor = getDoctor();
                    try {
                        if(program.updateDoctor(doctor))
                            System.out.println("Update!");
                    } catch (Exception e) {
                    }
                    break;
                case 3:
                    System.out.println("--------- Delete Doctor ---------");
                    System.out.print("Enter code: ");
                    String c = input.next();
                    try {
                        if(program.deleteDoctor(c))
                            System.out.println("Deleted!");
                    } catch (Exception e) {
                    }
                    break;
                case 4:
                    System.out.println("--------- Search Doctor ---------");
                    System.out.print("Enter name: ");
                    String n = input.next();
                    System.out.println("--------- Result ---------");
                    try {
                        System.out.println("Code           "+"     "+"Name              "+"      "+"Specialization      "+"        "+"Availability");
                        program.display(program.searchDoctor(n));
                    } catch (Exception e) {
                    }
                    break;
                    
                    
            }

        }
    }

    public static void menu(){
        System.out.println("========= Doctor Management =========");
        System.out.println("1. Add Doctor");
        System.out.println("2. Update Doctor");
        System.out.println("3. Delete Doctor");
        System.out.println("4. Search Doctor");
        System.out.println("5. Exit Doctor");
        System.out.print("Your choice: ");
    }

    public static Doctor getDoctor(){
        System.out.print("Enter code: ");
        code = input.next();
        System.out.print("Enter Name: ");
        name = input.next();
        System.out.print("Enter Specialzation: ");
        specialization = input.next();
        System.out.print("Enter Availability: ");
        availability = program.checkAvailability(input.next());
        return new Doctor(code, name, specialization, availability);
    }
}
