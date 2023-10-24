import java.util.Scanner;
public class Triangle{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Angles : ");
		int a=sc.nextInt();
		int b=sc.nextInt();
		int c=sc.nextInt();
		if(a+b+c==180)
		{
			System.out.println(" It is a triangle ");
		}
		else
		{
			System.out.println(" It is not a triangle ");
		}
		sc.close();
	}
}
