import java.util.Scanner;

public class Divbyfifteen {

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Number : ");
        int num=sc.nextInt();
        if(num%5==0&&num%3==0)
            System.out.println("\nNumber "+num+" is divisible by 15 ");
        else
            System.out.println("\nNumber "+num+" is not divisible by 15 ");
        
        sc.close();
    }
}
