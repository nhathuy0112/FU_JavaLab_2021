package Lab_2;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
public class P0010 {
    public int[] generate(int[] arr){
        Random r = new Random();
        for(int i=0; i<arr.length; i++){
            arr[i] = r.nextInt((2*arr.length - (-2*arr.length))+1);
        }
        return arr;
    }

    public int linear_search(int[] arr, int s){
        for(int i=0; i<arr.length; i++){
            if(arr[i]==s)
                return i;
        }
        return -1;

    }
    public static void main(String[] args) {
        P0010 o = new P0010();
        Scanner input = new Scanner(System.in);
        System.out.println("===== Program =====");
        System.out.println("Enter the number of array: ");
        int n = input.nextInt();
        int[] arr = o.generate(new int[n]);
        System.out.println("Enter search value: ");
        int s = input.nextInt();
        System.out.println("The array: "+Arrays.toString(arr));
        System.out.println(o.linear_search(arr, s)==-1?"Not found":"Found "+s+" at index "+o.linear_search(arr, s));
    }

}
