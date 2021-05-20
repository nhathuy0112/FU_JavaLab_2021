package P0068;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Student> students = new ArrayList<Student>();
        StudentComparator program = new StudentComparator();
        int option = 0;
        while(option != 3){
            menu();
            option = input.nextInt();
            switch(option){
                case 1:
                    students = program.sortStudent(students);
                    break;
                case 2:
                    program.display(students);
                    break;
                case 3: 
                    break;
                default: System.out.println("Please enter 1 to 3");
            }
        }
    }

    public static void menu(){
        System.out.println("====== Collection Sort Program ======");
        System.out.println("1. Sort student list");
        System.out.println("2. Print student list");
        System.out.println("3. Exit");
        System.out.print("Your choice: ");
    }
}
