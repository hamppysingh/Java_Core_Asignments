import java.util.Scanner;
public class Power{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Number and Power : ");
		int a=sc.nextInt();
		int b=sc.nextInt();
		System.out.println(" Power of "+a+" raised to "+b+" is : "+(Math.pow(a,b)));
		sc.close();
	}
}
