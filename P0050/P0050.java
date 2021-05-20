package Lab_1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P0050 {
    static Scanner input =  new Scanner(System.in);
    public static void main(String[] args) {
        int option = 0;
        while(option!=3){
            menu();
            option = input.nextInt();
            switch(option){
                case 1:
                    System.out.println("----- Calculate Equation -----");
                    float a = get_input("A");
                    float b = get_input("B");
                    display_result(calculateEquation(a, b), a, b);
                    break;
                case 2:
                    System.out.println("----- Calculate Quadratic Equation -----");
                    float a2 = get_input("A");
                    float b2 = get_input("B");
                    float c2 = get_input("C");
                    display_result(calculateQuadracticEquation(a2, b2, c2), a2, b2, c2);
            } 
        }
    }

    public static void display_result(List<Float> list, float a, float b){
        if(list == null){
            System.out.println("No Solution");
        }else if(list.isEmpty()){
            System.out.println("Solution: Infinity");
        }else{
            System.out.println("Solution: x = "+list.get(0));
        }
        
        System.out.println("Number is odd: "+(isOdd(a)?a+", ":"")+(isOdd(b)?b:""));
        System.out.println("Number is even: "+(isOdd(a)?"":a+", ")+(isOdd(b)?"":b));
        System.out.println("Number is Perfect Square: "+(isPerfectSquare(a)?a+", ":"")+(isPerfectSquare(b)?b:""));
    }

    public static void display_result(List<Float> list, float a, float b, float c){
        if(list == null){
            System.out.println("No Solution");
        }else if(list.isEmpty()){
            System.out.println("Solution: Infinity");
        }else{
            if(list.size()==2){
                System.out.println("Solution: x1 = "+list.get(0)+" and x2 = "+list.get(1));
            }else{
                System.out.println("Solution: x = "+list.get(0));
            }
        }
        
        System.out.println("Number is odd: "+(isOdd(a)?a+", ":"")+(isOdd(b)?b+", ":"")+(isOdd(c)?c:""));
        System.out.println("Number is even: "+(isOdd(a)?"":a+", ")+(isOdd(b)?"":b+", ")+(isOdd(c)?"":c));
        System.out.println("Number is Perfect Square: "+(isPerfectSquare(a)?a+", ":"")+(isPerfectSquare(b)?b+", ":"")+(isPerfectSquare(c)?c:""));
    }

    public static boolean Floatcheckin (String floatString){
        try{
            Float.parseFloat(floatString);
        }catch(NumberFormatException e){
            return false;
        } return true;
    }

    public static void menu(){
        System.out.println("========= Equation Program =========");
        System.out.println("1. Calculate Superlative Equation");
        System.out.println("2. Calculate Quadractic Equation");
        System.out.println("3. Exit");
        System.out.print("Please choose one option: ");
    }

    public static float get_input(String s){
        System.out.print("Enter "+s+": ");
        String str = input.next();
        while(Floatcheckin(str)==false){
            System.out.println("Please input a number");
            System.out.print("Enter "+s+": ");
            str = input.next();
        }
        return Float.parseFloat(str);
    }

    public static boolean isOdd(float number){
        return (number%2==0?false:true);
    }

    public static boolean isPerfectSquare(float number){
        return (Math.sqrt(number) - Math.floor(Math.sqrt(number))==0);
    }

    public static List<Float> calculateEquation(float a, float b){
        List<Float> list = new ArrayList<Float>();
        if(a==0 && b!=0){
            return null;
        }else if(a!=0){
            list.add(-b/a);
            return list;
        }else
            return list;
    }

    public static List<Float> calculateQuadracticEquation(float a, float b, float c){
        List<Float> list = new ArrayList<Float>();
        if(a==0 && b==0 && c==0){
            return list;
        }else{
            float delta = b*b - 4*a*c;
            if(delta > 0){
                list.add((float)(-b + Math.sqrt(delta)) / (2 * a));
                list.add((float)(-b - Math.sqrt(delta)) / (2 * a));
                return list;
            }else if(delta == 0){
                list.add((float)(-b/2*a));
                return list;
            }else{
                return null;
            }
        }
    }
}
