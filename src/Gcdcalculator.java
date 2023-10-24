import java.util.Scanner;
public class Gcdcalculator {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print(" Enter the number A : ");	
		int a=sc.nextInt();
		System.out.print(" Enter the number B : ");	
		int b=sc.nextInt();
		int gcd=0;
		for(int i=1;i<=a&&i<=b;i++)
		{
			if(a%i==0&&b%i==0)
			{
				gcd=i;
			}
		}
		System.out.print(" GCD of the two numbers is : "+gcd);
		sc.close();
	}
}
