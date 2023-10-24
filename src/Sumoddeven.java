import java.util.Scanner;
public class Sumoddeven{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(" Enter the Number : ");
		int num=sc.nextInt();
			
		if(num%2==0)
		{
			System.out.println(" The sum of odd numbers between 1 and "+num+" is : "+(num*num/4));
			System.out.println(" The sum of even numbers between 1 and "+num+" is : "+(num/2*(num/2+1)));
		}
		else
		{
			System.out.println(" The sum of odd numbers between 1 and "+num+" is : "+((num/2+1)*(num/2+1)));
			System.out.println(" The sum of even numbers between 1 and "+num+" is : "+(num/2*(num/2+1)));
		}
		sc.close();
	}
}
