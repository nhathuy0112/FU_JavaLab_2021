package Lab_1;

import java.util.Scanner;

public class P0084{
    static Scanner input = new Scanner(System.in);
    static int i,j,t;
    public static void main(String[] arg){
        System.out.println("===== Calculate 2 big digit numbers =====");
        System.out.print("Enter A: ");
        String str_a = input.next();
        System.out.print("Enter B: ");
        String str_b = input.next();
        System.out.println("-----------------------------------------");
        System.out.print("Result A*B = ");
        int[] r = multiply(str_a, str_b);
        for(;i >= 0;i--)
            System.out.print(r[i]);  
        
    }

    public static int[] multiply(String str_a, String str_b){
        int[] a = new int[100]; int[] b = new int[100];
        char[] s1 = str_a.toCharArray(); char[] s2 = str_b.toCharArray();
        int[] ans = new int[200];
        int l1 = str_a.length();
        int l2 = str_b.length();

        for(i = l1-1,j=0;i>=0;i--,j++)
            a[j] = s1[i]-'0';

        for(i = l2-1,j=0;i>=0;i--,j++)
            b[j] = s2[i]-'0';

        for(i = 0;i < l2;i++)
            for(j = 0;j < l1;j++)
                ans[i+j] += b[i]*a[j];

        for(i = 0;i < l1+l2;i++){
            t = ans[i]/10;
            ans[i] = ans[i]%10;
            ans[i+1] = ans[i+1] + t;
        }

        for(i = l1+l2; i>= 0;i--)
            if(ans[i] > 0)
                break;
        return ans;
    }
}
