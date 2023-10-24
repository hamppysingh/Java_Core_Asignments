import java.util.Scanner;
public class Calculatesal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Salary : ");
		double sal=sc.nextDouble();
		if(sal<150000)
		{
			System.out.println(" Income tax is : "+sal);
		}
		else if(sal>=150000&&sal<=300000)
		{
			System.out.println(" Income tax is : "+(sal*0.20));
		}
		else
		{
			System.out.println(" Income tax is : "+(sal*0.30));
		}
		sc.close();
	}

}
