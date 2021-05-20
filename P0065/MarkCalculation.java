package P0065;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MarkCalculation {

    public double checkInput(String input, String subject) {
        Scanner sc = new Scanner(System.in);
        double n = 0;
        try {
            n = Double.parseDouble(input);
            if (n < 0 || n > 10) {
                System.out.print(n < 0 ? subject + " is greater than zero" : subject + " is less than equal ten");
                System.out.print(subject + ": ");
                input = sc.next();
                checkInput(input, subject);
            }
        } catch (NumberFormatException e) {
            System.out.print(subject + " is digit");
            System.out.print(subject + ": ");
            input = sc.next();
            checkInput(input, subject);
        }
        return n;
    }

    public Student createStudent(String name, String classes, double maths, double chemistry, double physics) {
        return new Student(name, classes, maths, physics, chemistry);
    }

    public List<Student> averageStudent(List<Student> students) {
        List<Student> classifiedStudents = new ArrayList<Student>();
        for (Student student : students) {
            double average = (student.getMaths() + student.getPhysics() + student.getChemistry()) / 3;
            if (average > 7.5)
                classifiedStudents.add(new Student(student.getName(), student.getClasses(), average, 'A'));
            if (average >= 6 && average <= 7.5)
                classifiedStudents.add(new Student(student.getName(), student.getClasses(), average, 'B'));
            if (average >= 4 && average < 6)
                classifiedStudents.add(new Student(student.getName(), student.getClasses(), average, 'C'));
            if (average < 4)
                classifiedStudents.add(new Student(student.getName(), student.getClasses(), average, 'D'));
        }
        return classifiedStudents;
    }

    public void printClassifiedStudents(List<Student> students) {
        for (int i = 0; i < students.size(); i++) {
            System.out.println("------ Student" + (i + 1) + " Info ------");
            System.out.println("Name: " + students.get(i).getName());
            System.out.println("Classes: " + students.get(i).getClasses());
            System.out.printf("AVG: %.1f\n", students.get(i).getAverage());
            System.out.println("Type: " + students.get(i).getType());
        }
    }

    public HashMap<String, Double> getPercentTypeStudent(List<Student> students) {
        HashMap<String, Double> stactistic = new HashMap<String, Double>();
        double typeA = 0;
        double typeB = 0;
        double typeC = 0;
        double typeD = 0;
        for (Student student : students) {
            switch (student.getType()) {
                case 'A':
                    typeA++;
                    break;
                case 'B':
                    typeB++;
                    break;
                case 'C':
                    typeC++;
                    break;
                case 'D':
                    typeD++;
            }
        }
        stactistic.put("A", (double) (typeA / students.size() * 100));
        stactistic.put("B", (double) (typeB / students.size() * 100));
        stactistic.put("C", (double) (typeC / students.size() * 100));
        stactistic.put("D", (double) (typeD / students.size() * 100));
        return stactistic;
    }

    public void printStatistic(HashMap<String, Double> statistic) {
        System.out.println("---------Classification Info---------");
        for (Map.Entry<String, Double> entry : statistic.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + "%");
        }
    }
}
