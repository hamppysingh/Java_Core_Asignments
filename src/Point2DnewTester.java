import java.util.Scanner;
public class Point2DnewTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println(" Enter the x and y coordinate of point 1 : ");
		Point2Dnew P1= new Point2Dnew(sc.nextInt(),sc.nextInt());
		System.out.println(" Enter the x and y coordinate of point 1 : ");
		Point2Dnew P2= new Point2Dnew(sc.nextInt(),sc.nextInt());
		
		System.out.println(" Details of points are : \n  "+P1.toString()+"\n  "+P2.toString());
		
		System.out.println(" The Equality of point P1 and P2 : "+(P1.isEqual(P2)));
		
		System.out.println(" The Distance between 2 points P1 and P2 is : "+P1.calculatedistance(P2));
		sc.close();
	}
}
