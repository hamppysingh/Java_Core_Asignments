import java.util.Scanner;
import java.lang.Math;
public class Computearea {
	static double area(int a,int b,int c,double Area) {
		int s=(a+b+c)/2;
		Area=1.0*Math.sqrt(s*(s-a)*(s-b)*(s-c));
		return Area;
	}
	static double area(int radius,double Area) {
		Area=22/7.0*radius*radius;
		return Area;
	}
	static double area(int l,int br,double Area) {
		Area=1.0*l*br;
		return Area;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.print(" Enter the choice for Area calculation :\n 1 for Triangle\n 2 for Circle\n 3 for Rectangle\n 4 for Exit : ");
		int choice=sc.nextInt();
		double Area=0.0;
		switch(choice)
		{
		case 1: int a,b,c;
				System.out.println(" Enter the sides of the triangle : ");
				a=sc.nextInt();
				b=sc.nextInt();
				c=sc.nextInt();
				System.out.println("The area of the Triangle is : "+(area(a,b,c,Area)));
				break;
		case 2: int r;
				System.out.println(" Enter the radius of the Circle : ");
				r=sc.nextInt();				
				System.out.println("The area of the Circle is : "+(area(r,Area)));
				break;		
		case 3: int l,br;
				System.out.println(" Enter the sides of the Recangle : ");
				l=sc.nextInt();
				br=sc.nextInt();
				System.out.println("The area of the Recangle is : "+(area(l,br,Area)));
				break;
		case 4: System.out.println(" Exited...");
				System.exit(0);
		default:System.out.println(" Invalid input enter again ");
				break;
		}
		sc.close();
	}
}
