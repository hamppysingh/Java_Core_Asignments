import java.util.Scanner; 
public class Point2DTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Scanner sc=new Scanner(System.in);
		  int j=0;
			Point2D[] p = new Point2D[5];
	        while(true)
	        {	
	        	System.out.println(" Enter the choice \n 1 for Displaying points \n 2 for Inserting points\n 3 for Exit \n Your choice : ");
	        	int choice=sc.nextInt();
	        	switch(choice)
	        	{
		        	case 1:	int i=0;
		        			for(Point2D x:p)
		        			{
		        				if(x!=null)
		        					System.out.println(x.toString(i++));
		        				else break;
		        			}
		        			break;
		        	case 2: 
		        		 	if (p[j] == null) {
		                        p[j] = new Point2D();
		                    }
		        			System.out.println("Enter the x: ");
		            		int x = sc.nextInt();

		            		System.out.println("Enter the y: ");
		            		int y = sc.nextInt();
		        			p[j].setX(x);
		        			p[j].setY(y);
		        			j++;
		        			if(j==5)
		        				j=0;
		        			break;
		        	case 3:	System.out.println(" Exited.. ");
		        			sc.close();
		        			System.exit(0);
		        	default:System.out.println(" Invalid Input!! Enter again please..");
		        			break;
	        	}
	        }	
	}
}
