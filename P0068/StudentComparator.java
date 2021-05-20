package P0068;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class StudentComparator  {
    private Scanner input = new Scanner(System.in);

    public float checkFloat(String f){
        try {
            float mark = Float.parseFloat(f);
            return (mark <= 0 ? 0:mark);
        } catch (Exception e) {
            System.out.println("Please enter a number");
            System.out.print("Mark: ");
            f = input.next();
            return checkFloat(f);
        }
    }

    public List<Student> sortStudent(List<Student> students){
        String option = "Y";
        String name = "";
        String classes = "";
        float mark = 0;
        while(option.equals("Y") || option.equals("y")){
            System.out.println("Please input student information");
            System.out.print("Name: ");
            name = input.next();
            System.out.print("Classess: ");
            classes = input.next();
            System.out.print("Mark: ");
            mark = checkFloat(input.next());
            students.add(new Student(name, mark, classes));
            System.out.print("Do you want to enter more student information?(Y/N): ");
            option = input.next();
        }

        Collections.sort(students, new Comparator<Student>(){
            public int compare(Student student1, Student student2){
                return student2.getName().compareTo(student1.getName());
            }
        });
        return students;
    }

    public void display(List<Student> students){
        for(int i=0; i<students.size(); i++){
            System.out.println("-----------------"+"Student"+(i+1)+"-----------------");
            System.out.println("Name: "+students.get(i).getName());
            System.out.println("Classes: "+students.get(i).getClasses());
            System.out.println("Mark: "+students.get(i).getMark());
        }
    }
}
