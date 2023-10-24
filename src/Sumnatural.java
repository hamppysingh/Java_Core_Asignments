import java.util.Scanner;
public class Sumnatural{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(" Enter the Number : ");
		int num=sc.nextInt();
		System.out.println(" Sum of first "+num+" natural numbers is : "+(num*(num+1)/2));
		sc.close();
	}
}
