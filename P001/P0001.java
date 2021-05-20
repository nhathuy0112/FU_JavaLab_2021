package Lab_2;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
public class P0001 {
    public int[] generate(int[] arr){
        Random r = new Random();
        for(int i=0; i<arr.length; i++){
            arr[i] = r.nextInt((2*arr.length - (-2*arr.length))+1);
        }
        return arr;
    }

    public void bubble_sort(int[] arr){
        for(int i=0;i<arr.length;i++)
            for(int j=i+1;j<arr.length;j++)
                if(arr[j] < arr[i]){
                    int t = arr[j];
                    arr[j] = arr[i];
                    arr[i] = t;
                }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        P0001 o = new P0001();
        System.out.println("========== Program ==========");
        System.out.println("Enter the number of array: ");
        int n = input.nextInt();
        int[] arr = o.generate(new int[n]);
        System.out.println("Unsorted array: "+Arrays.toString(arr));
        o.bubble_sort(arr);
        System.out.println("Sorted array: "+Arrays.toString(arr));
    }
}
