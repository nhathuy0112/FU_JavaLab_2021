package P0056;

import java.util.Scanner;

public class WokerMain {
    static String code;
    static String name;
    static int age;
    static double salary;
    static String workLocation;
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Management manager = new Management();
        int option = 0;
        while (option != 5) {
            menu();
            option = input.nextInt();
            switch (option) {
                case 1:
                    System.out.println("--------- Add Worker ---------");
                    try {
                        System.out.println(manager.addWorker(getWorker()) ? "Added!" : "Failed!");
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case 2:
                    System.out.println("--------- Up Salary ----------");
                    System.out.print("Enter code: ");
                    String code = input.next();
                    System.out.print("Enter Salary: ");
                    double amount = input.nextDouble();
                    SalaryStatus status = new SalaryStatus(amount, true);
                    try {
                        System.out.println(manager.changeSalary(status, code, amount) ? "Changed!" : "Failed!");
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case 3:
                    System.out.println("--------- Down Salary ----------");
                    System.out.print("Enter code: ");
                    code = input.next();
                    System.out.print("Enter Salary: ");
                    amount = input.nextDouble();
                    status = new SalaryStatus(amount, false);
                    try {
                        System.out.println(manager.changeSalary(status, code, amount) ? "Changed!" : "Failed!");
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case 4:
                    System.out.println("------------------- Display Information Salary -------------------");
                    System.out.printf("%8s %10s %12s %14s %16s %18s \n", "Code", "Name", "Age", "Salary", "Status",
                            "Date");
                    manager.printSalaryHistory(manager.getInformationSalary());
                    break;
                default:
                    System.out.println("Please enter 1 to 4");

            }
        }
    }

    public static void menu() {
        System.out.println("====== Worker Management ======");
        System.out.println("1. Add Worker");
        System.out.println("2. Up salary");
        System.out.println("3. Down salary");
        System.out.println("4. Display Information salary");
        System.out.println("5. Exit");
        System.out.print("Your choice: ");
    }

    public static Worker getWorker() {
        System.out.print("Enter Code: ");
        code = input.next();
        System.out.print("Enter Name: ");
        name = input.next();
        System.out.print("Enter Age: ");
        age = input.nextInt();
        System.out.print("Enter Salary: ");
        salary = input.nextDouble();
        System.out.print("Enter work location: ");
        workLocation = input.next();
        return new Worker(code, name, age, salary, workLocation);
    }
}
