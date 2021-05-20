package P0063;

import java.util.Scanner;

public class PersonMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Person p = new Person();
        Person[] personArray = new Person[3];
        System.out.println("===== Management Person program =====");

        for (int i = 0; i < personArray.length; i++) {
            System.out.println("Input Information of Person");
            System.out.print("Please input name: ");
            String name = input.next();
            System.out.print("Please input address: ");
            String address = input.next();
            System.out.print("Please input salary: ");
            String salary = input.next();
            try {
                personArray[i] = p.inputPersonInfo(name, address, salary);
            } catch (Exception e) {
            }
            System.out.println();
        }

        try {
            personArray = p.sortBySalary(personArray);
        } catch (Exception e) {
            System.out.println(e);
        }

        for (int i = 0; i < personArray.length; i++) {
            p.displayPersonInfo(personArray[i]);
            System.out.println();
        }

    }

}
