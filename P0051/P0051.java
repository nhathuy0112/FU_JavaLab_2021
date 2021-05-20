package Lab_1;

import java.util.Scanner;

public class P0051 {
    enum BMI{
        UNDER_STANDARD,
        STANDARD,
        OVERWEIGHT,
        FAT,
        VERY_FAT,
    }

    enum Operator{
        Addition,
        Multiplication,
        Subtraction,
        Division,
        Equal,
        Pow,
        Check,
    }
    
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int option = 0;
        while(option!=3){
            menu();
            option = input.nextInt();
            switch(option){
                case 1:
                    System.out.println("----- Normal Calculator -----");
                    double a = get_input_forNormal();
                    Operator operator = get_operator();
                    if(operator.equals(Operator.Equal)){
                        System.out.println("Result: "+a);
                    } else{
                        double b = get_input_forNormal();
                        System.out.println("Result: "+calculate(a, operator, b));
                    }
                    break;
                case 2:
                    System.out.println("----- BMI Calculator -----");
                    double w = get_input_forBMI("Weight");
                    double h = get_input_forBMI("Height");
                    System.out.println("BMI Status: "+calculateBMI(w, h));
            }
        }
    }
    public static void menu(){
        System.out.println("========= Calculator Program =========");
        System.out.println("1. Normal Calculator");
        System.out.println("2. BMI Calculator");
        System.out.println("3. Exit");
        System.out.print("Please choose one option: ");
    }

    public static boolean doubleCheckin (String doubleString){
        try{
            Double.parseDouble(doubleString);
        }catch(NumberFormatException e){
            return false;
        } return true;
    }

    public static Operator operatorCheckin_andFinding (String operatorString){
        Operator op = Operator.Check;
        switch(operatorString){
            case "+":
                op = Operator.Addition;
                break;
            case "-":
                op = Operator.Subtraction;
                 break;
            case "*":
                op = Operator.Multiplication;
                break;
            case "/":
                op = Operator.Division; 
                break;
            case "=":
                op = Operator.Equal;
                break;
            case "^":
                op = Operator.Pow;
                break;
        }
        return op;
    }
    public static double get_input_forNormal(){
        System.out.print("Enter number: ");
        String str = input.next();
        while(doubleCheckin(str)==false){
            System.out.println("Please input number");
            System.out.print("Enter number: ");
            str = input.next();
        }
        return Double.parseDouble(str);
    }

    public static Operator get_operator(){
        System.out.print("Enter Operator: ");
        String str = input.next().trim();
        while(operatorCheckin_andFinding(str).equals(Operator.Check)){
            System.out.println("Please input (+, -, *, /, ^)");
            System.out.print("Enter Operator: ");
            str = input.next();
        }
        return operatorCheckin_andFinding(str);
    }

    public static double get_input_forBMI(String s){
        if(s.equals("Weight"))
            System.out.print("Enter "+s+"(kg): ");
        else    
            System.out.print("Enter "+s+"(cm): ");

        String str = input.next();
        while(doubleCheckin(str)==false){
            System.out.println("BMI is digit");
            if(s.equals("Weight"))
                System.out.print("Enter "+s+"(kg): ");
            else    
                System.out.print("Enter "+s+"(cm): ");
            str = input.next();
        }
        return Double.parseDouble(str);
    }

    public static double calculate(double a, Operator operator, double b){
        double memory = 0;
            switch(operator){
                case Equal:
                    return a;
                case Addition:
                    memory = a+b;
                    break;
                case Subtraction:
                    memory = a-b;
                    break;
                case Multiplication:
                    memory = a*b;
                    break;
                case Division:
                    memory = a/b;    
                    break;
                case Pow:
                    memory = Math.pow(a, b);
                
            }
        
        System.out.println("Memory: "+memory);
        return calculate(memory, get_operator());
        
    }

    public static double calculate(double a, Operator operator){
        if(operator.equals(Operator.Equal)) return a;
        else{
            double b = get_input_forNormal();
            return calculate(a, operator, b);
        }
    }

    public static BMI calculateBMI(double weight, double height){
        double bmi = (weight*10000)/(height*height);
        System.out.printf("BMI Number: %.2f\n",bmi);
        BMI status = BMI.STANDARD;
        if(bmi<19) status = BMI.UNDER_STANDARD;
        if(bmi>=25 && bmi<=30) status = BMI.OVERWEIGHT;
        if(bmi>=30 && bmi<=40) status = BMI.FAT;
        if(bmi>40) status = BMI.VERY_FAT;
        return status;
        
    }
}
