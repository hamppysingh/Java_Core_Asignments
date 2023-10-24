import java.util.Scanner;
public class Reversenum{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(" Enter the Number : ");
		int num=sc.nextInt();
		String t= Integer.toString(num);
		StringBuilder sb = new StringBuilder(t);
		sb.reverse();
		Integer numrev=Integer.valueOf(sb.toString());
		System.out.println(" The reverse of "+num+" is : "+numrev);
		sc.close();
	}
}
