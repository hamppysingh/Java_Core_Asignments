import java.util.Scanner;

public class Addnum{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Number 1 : ");
        int num1=sc.nextInt();
        System.out.println("Enter the Number 2 : ");
        int num2=sc.nextInt();
        int temp=num1;
        num1=num2;
        num2=temp;
        System.out.println("After Swapping Number 1 and Number 2 are : "+num1+" "+num2);
        sc.close();
    }
}