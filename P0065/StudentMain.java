package P0065;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<Student>();
        MarkCalculation calculator = new MarkCalculation();
        System.out.println("====== Management Student Program ======");
        String option = "Y";
        while (!option.equals("N")) {
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Classes: ");
            String classes = sc.next();
            System.out.print("Maths: ");
            double maths = calculator.checkInput(sc.next(), "Maths");
            System.out.print("Physics: ");
            double physics = calculator.checkInput(sc.next(), "Physics");
            System.out.print("Chemistry: ");
            double chemistry = calculator.checkInput(sc.next(), "Chemistry");
            students.add(calculator.createStudent(name, classes, maths, chemistry, physics));
            System.out.print("Do you want to enter more student information?(Y/N): ");
            option = sc.next();
        }

        calculator.printClassifiedStudents(calculator.averageStudent(students));
        calculator.printStatistic(calculator.getPercentTypeStudent(calculator.averageStudent(students)));
    }
}
