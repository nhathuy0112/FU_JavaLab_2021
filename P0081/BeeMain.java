package P0081;

import java.util.Scanner;

public class BeeMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BeeList program = new BeeList();
        int option = 0;
        while(option != 3){
            menu();
            option = input.nextInt();
            switch(option){
                case 1:
                    program.clearBeeList();
                    program.generate();
                    program.display();
                    break;
                case 2:
                    program.attack();
                    program.display();
                    break;
                case 3: break;
                default: System.out.println("Please enter 1 to 3");
            }
        }
    }

    public static void menu(){
        System.out.println("----- BEE -----");
        System.out.println("1. Create new bee list");
        System.out.println("2. Damage bee");
        System.out.println("3. Quit");
        System.out.print("Choose an option: ");
    }
}
