package CustomerManagement;
import java.util.Scanner;

public class CustomerTester{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try(Scanner sc=new Scanner(System.in)) {
			System.out.println("Enter the Customer details- First Name, Last Name, Email, Password, Registered Amount,Date Manufactured (yyyy-mm-dd), Color : ");
			Customer customer=Validationrules.validateallinputs(sc.next(),sc.next(),sc.next(),sc.next(),sc.nextDouble(),sc.next(),sc.next());
			System.out.println(customer.toString());
		}
        catch(Exception e) {
			e.printStackTrace();
		}
        // Create a Vehicle object with the input values 
	}   

}

