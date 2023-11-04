import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Arrayoperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr= new ArrayList<Integer>();
		while(true)
		{	Scanner sc=new Scanner(System.in);
			System.out.println(" Enter the choice of operation on arrays as follows\n 1 for Show Array Elements\n 2 for Add Element\n 3 for Search Element\n 4 for Doubling Array Elements\n 5 for Sorting Array Elements\n 6 for Exit : ");
			int choice=sc.nextInt();
				switch(choice)
				{
				case 1 :	System.out.println(" Elements of the arrays are : "); 
							if(arr.size()==0)
							{	System.out.println("No Elements Present!!");
								break;
							}
							else
								for(Integer x:arr)
								System.out.print(" "+x);
							System.out.println();
							break;
				case 2 :	System.out.println(" Enter the element you want to add : ");
							Integer c=Integer.valueOf(sc.nextInt());
							arr.add(c);
							break;
				case 3 :    if(arr.size()==0)
							{	System.out.println("No Elements Present in the Array!!");
								break;
							}
							System.out.println(" Enter the element you want to search : ");
							int a=sc.nextInt();
							for(int i=0;i<arr.size();i++)
							{	if(a==arr.get(i))
								{	System.out.println(" Element found at the "+(i+1)+" position ");
									break;
								}
							}	
							System.out.println(" Searched element not found!! ");
							break;
				case 4 :    if(arr.size()==0)
							{	System.out.println("No Elements Present!!");
								break;
							}
							for(int j=0;j<arr.size();j++)
								arr.set(j, arr.get(j) * 2);
							System.out.println(" Array elements doubled!! ");
							break;			
				case 5 :    if(arr.size()==0)
							{	System.out.println("No Elements Present!!");
								break;
							}
							Collections.sort(arr);
							System.out.println(" Array is sorted!! ");	
							break;
				case 6 :    sc.close();
							System.out.println(" Exited... ");
							System.exit(0);
							break;
				default :   System.out.println(" Invalid choice enter again !! ");
							break;
				}
				
		}
	}
}
