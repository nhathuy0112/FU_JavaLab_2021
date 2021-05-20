package Lab_2;

import java.util.Scanner;

public class P0053 {
    private Scanner input = new Scanner(System.in);
    private int n;
    private int[] arr = new int[50];

    public int check_interger(String n){
        try{
            int integer = Integer.parseInt(n);
            if(integer <= 0) System.out.println("Please input number and number is greater than zero");
            return integer;
        }catch(NumberFormatException e){
            System.out.println("Please input number and number is greater than zero");
            return 0;
        }
    }

    public void input_element(){
        while(n <= 0) {
            System.out.print("Enter number: ");
            String s = input.next();
            n = check_interger(s);   
        }   
        for(int i=0; i<n; i++){
            System.out.print("Enter Number "+(i+1)+": ");
            arr[i] = input.nextInt();
        }
        
    }

    public int[] sort_ascending(int[] a){
        for(int i=0; i<n; i++)
            for(int j=i+1; j<n; j++)
                if(a[j] < a[i]){
                    int t = a[j];
                    a[j] = a[i];
                    a[i] = t;
                }
        return a;
    }

    public int[] sort_descending(int[] a){
        for(int i=0; i<n; i++)
            for(int j=i+1; j<n; j++)
            if(a[j] > a[i]){
                int t = a[j];
                a[j] = a[i];
                a[i] = t;
            }
        return a;
    }

    public String toString(int[] a){
        String d = "";
        for(int i=0; i<n; i++){
            if(i == n-1){
                d = d+"["+arr[i]+"]";
                break;
            }
            d = d+"["+arr[i]+"]"+"->";
        }
        return d;
    }

    public void menu(){
        System.out.println("========= Bubble Sort Program =========");
        System.out.println("1. Input Element");
        System.out.println("2. Sort Ascending");
        System.out.println("3. Sort Descending");
        System.out.println("4. Exit");
        System.out.print("Please choose one option: ");
    }
    public static void main(String[] args) {
        P0053 o = new P0053();
        int option = 0;
        while(option!=4){
            o.menu();
            option = o.input.nextInt();
            switch(option){
                case 1:
                    System.out.println("----- Input Element -----");
                    o.input_element();
                    break;
                case 2:
                    System.out.println("----- Ascending -----");
                    System.out.println(o.toString(o.sort_ascending(o.arr)));
                    break;
                case 3:
                    System.out.println("----- Descending -----");
                    o.sort_descending(o.arr);
                    System.out.println(o.toString(o.sort_descending(o.arr)));
                    break;
                case 4: 
                    break;
                default: 
                    System.out.println("Please enter 1 to 4");
            }
        }
    }
}
