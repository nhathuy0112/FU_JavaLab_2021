package P0063;

import java.util.Scanner;

public class Person {
    private String name;
    private String address;
    private double salary;

    public Person() {

    }

    public Person(String name, String address, double salary) {
        this.name = name;
        this.address = address;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void addPerSon() {

    }

    public Person inputPersonInfo(String name, String address, String salary) throws Exception {
        Scanner input = new Scanner(System.in);
        double s = 0;
        try {
            s = Double.parseDouble(salary);
            if (s < 0) {
                System.out.println("Salary is greater than zero");
                System.out.print("Please input salary: ");
                salary = input.next();
                inputPersonInfo(name, address, salary);
            }
        } catch (NumberFormatException e) {
            System.out.println("Your must input digit");
            System.out.print("Please input salary: ");
            salary = input.next();
            inputPersonInfo(name, address, salary);
        }
        return new Person(name, address, s);
    }

    public void displayPersonInfo(Person person) {
        System.out.println("Information of Person you have entered");
        System.out.println("Name: " + person.getName());
        System.out.println("Address: " + person.getAddress());
        System.out.println("Salary: " + person.getSalary());

    }

    public Person[] sortBySalary(Person[] person) throws Exception {
        if (person == null)
            throw new Exception("Can't sort person");
        for (int i = 0; i < person.length; i++)
            for (int j = i + 1; j < person.length; j++)
                if (person[j].getSalary() < person[i].getSalary()) {
                    Person p = person[i];
                    person[i] = person[j];
                    person[j] = p;
                }
        return person;
    }
}