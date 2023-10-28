package CustomerManagement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerTester{

	public static void main(String[] args) {
	    
	    List<Customer> customers = new ArrayList<>();// up casting
		try (Scanner sc = new Scanner(System.in)) {
			// create suitable D.S
			
			boolean exit = false;
			while (!exit) {
				System.out.println("Options : 1 . Customer Registration \n" + "2. Login Authentication via Email \n" + "3. Change password \n "
						+ "4. Unsuscribe via email \n " + "5. Display all \n"+" 6.Exit : ");
				try {
					switch (sc.nextInt()) {
					
					case 1: // add a vehicle
							System.out.println("Enter the Customer details- First Name, Last Name, Email, Password, Registered Amount, Service Plan : ");
							Customer customer=Validationrules.validateallinputs(sc.next(),sc.next(),sc.next(),sc.next(),sc.nextDouble(),sc.next(),customers);
							// => success
							customers.add(customer);
							System.out.println("Customer registered....");
							break;
					case 2:	System.out.println("Enter Email and Password for Logging in..");
							if(CustomerUtils.authentication(sc.next(), sc.next(),customers))
							{
								System.out.println(" Authentication successful...You are logged in ");
							}
							break;
					case 3:	System.out.println("Enter Email and Password for changing password");
							String em=sc.next();
							if(CustomerUtils.authentication(em, sc.next(),customers))
							{	
								System.out.println(" Enter the new password : ");
								String pass=sc.next();
								for(Customer t:customers) {
									if(t.getEmail().equals(em))
									{
										t.setPassword(pass);
										System.out.println(" Password Updated!!");
										break;
									}
								}
							}
							break;
						
					case 4:
							System.out.println("Enter Email for unsuscribing...");
							Customer P = new Customer(sc.next());
							int index = customers.indexOf(P);
							if (index == -1)
								throw new InvalidInputException("Invalid Email , Customer not found !!!!");
							customers.remove(index);
							System.out.println(" Customer unsuscribed succesfully!! ");
							break;
	
					case 5:
							System.out.println("Customer details");
							if(customers.size()==0)
								System.out.println(" Data Not Found!! ");
							for (Customer c : customers)
								System.out.println(c);
							break;

					case 6:
						exit = true;
						break;
					default:System.out.println(" Invalid Choice Enter Again.... ");	
							break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}	
	}	
}

