
import java.util.Scanner;
public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MathOperation m=new MathOperation();
		Scanner sc=new Scanner(System.in);
		int a=10,b=10,c=30;
		double e=30.0,f=20.0,g=80.0;
		System.out.println(" Additon between int "+a+" and int "+b+" is : "+m.add(a,b));
		System.out.println(" Additon between int "+c+" and double "+e+" is : "+m.add(c,e));
		System.out.println(" Additon between double "+f+" and double "+g+" is : "+m.add(f,g));
		System.out.println(" Additon of array of int is : "+m.add(a,b,c,c,b,a,60,40));
		sc.close();
	}

}
