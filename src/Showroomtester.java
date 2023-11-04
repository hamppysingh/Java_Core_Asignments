import java.util.Scanner;
public class Showroomtester {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Showroom S[]=new Showroom[10];
		int j=0;
		while(true){
			System.out.println(" Enter the choice \n 1 for Show all \n 2 for Add vehicle \n 3 for Edit color \n 4 for Edit price \n 5 for Remove \n 6 for Exit :");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1: for(Showroom x : S) 
					{
						if(x==null)
						{}
						else
							System.out.println(x);
					}
					break;
			case 2:	if(j>9)
					{	System.out.println(" Array is full!! Delete the elements and then enter....");
						break;
					}
					System.out.println(" Enter the vehicle id , name ,color and price : ");
					S[j++]=new Showroom(sc.nextInt(),sc.next(),sc.next(),sc.nextDouble());
					System.out.println(" Values entered!! ");
					break;
			case 3: System.out.println(" Enter the id in which you want to edit color : ");
					int id=sc.nextInt();
					for(Showroom x: S)
					{
						if(x!=null && x.getVid()==id)
						{	System.out.println(" Enter the color of your choice : ");
							x.setColor(sc.next());
							System.out.println(" Color changed!! ");
							break;
						}		
					}
					if (id >= 0 && id < S.length && S[id] == null) {
                        System.out.println(" Id not found!! ");
                    }
					break;
			case 4: System.out.println(" Enter the id in which you want to edit price : ");
					int id1=sc.nextInt();
					for(Showroom x: S)
					{
						if(x!=null && x.getVid()==id1)
						{	System.out.println(" Enter the price of the vehicle : ");
							x.setPrice(sc.nextDouble());
							System.out.println(" price updated!! ");
							break;
						}
					}	
					if (id1 >= 0 && id1 < S.length && S[id1] == null) {
                        System.out.println(" Id not found!! ");
                    }
					break;
			case 5: System.out.println(" Enter the id which you want to remove : ");
					int id2=sc.nextInt();
					for(int i=0;i<S.length;i++)
					{ 
						if(S[i]!=null && S[i].getVid()==id2)
						{
							S[i]=null;
							System.out.println("Id "+id2+" is removed");
							break;
						}
					}
					if (id2 >= 0 && id2 < S.length && S[id2] == null) {
                        System.out.println(" Id not found!! ");
                    }
					break;
			case 6:	sc.close(); 
					System.out.println(" Exited... ");
					System.exit(0);
			default:System.out.println(" Invalid input!! Enter again..");
			
			}
		}
	}
}
