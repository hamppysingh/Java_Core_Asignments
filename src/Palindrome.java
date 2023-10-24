import java.util.Scanner;
public class Palindrome{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(" Enter the Number : ");
		int num=sc.nextInt();
		int num1=num;
		int rem=0;
		int rev=0;
		while(num>0)
		{
			rem=num%10;
			num=num/10;
			rev=rev*10+rem;
		}
		if(rev==num1)
		System.out.println(" The number is a palindrome ");
		else
		System.out.println(" The number is not a palindrome ");
		sc.close();
	}
}
