import java.util.Scanner;
public class Armstrong{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(" Enter the Number : ");
		int num1=sc.nextInt();
		int num=num1;
		String t= Integer.toString(num);
		int len=t.length();
		int armnum=0;
		while(num>0)
		{
			int rem = num%10;
			num=num/10;
			armnum+=(int)Math.pow(rem,len);
		}
		if(armnum==num1)
			System.out.println(" Number is an armstrong number ");
		else
			System.out.println(" Number is not an armstrong number ");
		sc.close();
	}
}
