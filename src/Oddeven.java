import java.util.Scanner;

public class Oddeven {
     public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Number : ");
        int num=sc.nextInt();
        if(num%2==0)
            System.out.println("\nNumber "+num+" is : Even ");
        else
            System.out.println("\nNumber "+num+" is : Odd ");
        
        sc.close();
    }
}
