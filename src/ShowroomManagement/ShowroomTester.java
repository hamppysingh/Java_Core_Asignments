package ShowroomManagement;
import java.util.Scanner;

public class ShowroomTester{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try(Scanner sc=new Scanner(System.in)) {
			System.out.println("Enter the vehicle details- Vehicle Id, Chasis number, Company, Vehicle price, Date Manufactured (dd-mm-yyyy), Color : ");
			Vehicle vehicle=Validation.validatingallinputs(sc.nextInt(),sc.next(),sc.next(),sc.nextDouble(),sc.next(),sc.next());
			System.out.println(vehicle.toString());
		}
        catch(Exception e) {
			System.out.println(e.getMessage());
		}
        // Create a Vehicle object with the input values 
	}

}
