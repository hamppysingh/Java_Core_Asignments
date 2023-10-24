import java.util.Scanner;
public class Prime{
	public static boolean isprime(int num)
	{	
		if(num==2||num==3)
			return true;
		if(num%2==0||num%3==0)
			return false;
		for(int i=5;i*i<=num;i=i+6)
		{
			if(num%i==0||num%(i+2)==0)
				return false;
		}
		return true;
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(" Enter the Number : ");
		int num=sc.nextInt();
		System.out.println(" Prime numbers are as follows : ");
		for(int i=2;i<=num;i++)
		{
			if(isprime(i))
				System.out.println(" "+i);
		}
		sc.close();
	}
}
