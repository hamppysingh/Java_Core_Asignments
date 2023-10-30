package CustomerManagement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.time.Period;

public class CustomerTester{

	public static void main(String[] args) {
	    
	    List<Customer> customers = new ArrayList<>();// up casting
	    customers.add(new Customer("Admin","admin@admin","Admin@123"));  //Admin email and password
		try (Scanner sc = new Scanner(System.in)) {
			// create suitable D.S
			
			boolean exit = false;
			while (!exit) {
				System.out.println("Options : 1 . Customer Registration \n" + "2. Login Authentication via Email \n" + "3. Change password \n"
						+ "4. Unsuscribe via email \n" + "5. Display all \n"+"6. Add Custom Random data \n"+"7. Sort Customers Based on email\n"+"8. Sort Customers based on date of birth\n"+"9. Sort Customers on the basis of date of birth and lanst name\n"+"10. Login through email and query on cutomers who have not paid the suscription amount\n"+" 0.Exit : ");
				try {
					switch (sc.nextInt()) {
					
					case 1: // add a vehicle
							System.out.println("Enter the Customer details- First Name, Last Name, Email, Password, Date of Payment, Registered Amount,Last paid Suscription date ,Service Plan : ");
							Customer customer=Validationrules.validateallinputs(sc.next(),sc.next(),sc.next(),sc.next(),sc.next(),sc.nextDouble(),sc.next(),sc.next(),customers);
							// => success
							customers.add(customer);
							System.out.println("Customer registered....");
							break;
					case 2:	System.out.println("Enter Email and Password for Logging in..");
							String email1=sc.next();
							String pass1=sc.next();
							if(CustomerUtils.authentication(email1, pass1,customers))
							{
								Customer a=new Customer(email1,pass1);
								int cust_index=customers.indexOf(a);
								System.out.println(" Authentication successful...You are logged in ");
								System.out.println(" Did you pay the suscription : Y / N ");
								if(sc.next().charAt(0)=='Y')
								{	
									
									System.out.println(" Enter the amount you paid, you can also pay more for upgrading your Plan : ");
									double amt=sc.nextDouble();
									if(customers.get(cust_index).getSp().getCharge()==amt)
									{
										customers.get(cust_index).setLastpaidsuscription(LocalDate.now());
										System.out.println(" Suscription payed...date updated ");
									}
									else
									{
										customers.get(cust_index).setSp(Validationrules.RegAmountvalidate(customers.get(cust_index).getSp(),amt));
										customers.get(cust_index).setRegamount(amt);
										System.out.println(" Suscription payed...date updated ");
									}
								}
								else
									System.out.println(" Please pay the suscription charges asap!! ");
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
						
					case 4:	System.out.println("Enter Email and Password for changing password");
							String em1=sc.next();
							String pass=sc.next();
							if(CustomerUtils.authentication(em1,pass,customers))
							{	Customer p=new Customer(em1,pass);
								Customer toremove = customers.get(customers.indexOf(p));
								if (!(customers.remove(toremove)))
									throw new InvalidInputException("Invalid Email , Customer not found !!!!");
								System.out.println(" Customer unsuscribed succesfully!! ");
							}	
							break;
	
					case 5:
							System.out.println("Customer details ");
							if(customers.size()==0)
								System.out.println(" Data Not Found!! ");
							for (Customer c : customers)
								System.out.println(c);
							break;
					case 6: CustomerUtils.addcustomdata(customers);
							System.out.println(" Added custom data to the list.... ");
							break;
					case 7: Collections.sort(customers);	
							System.out.println(" Customers are sorted based on email!! ");
							break;
					case 8: Collections.sort(customers,new Comparator<Customer> () {
							public int compare(Customer o1, Customer o2) {
								int dobcheck=0;	
								if(o1.getDob()!=null&&o2.getDob()!=null)
									{	
										dobcheck=o1.getDob().compareTo(o2.getDob());
									}
									return dobcheck;
								}
							
							});	
							System.out.println(" Customers are sorted on date of birth!! ");
							break;
					case 9: Collections.sort(customers,new Comparator<Customer> () {
							public int compare(Customer o1, Customer o2) {
								int dobcheck=0;	
									if(o1.getDob()!=null&&o2.getDob()!=null)
									{
										dobcheck=o1.getDob().compareTo(o2.getDob());
										if(dobcheck==0)
										{
											return o1.getLname().compareTo(o2.getLname());
										}
									
									}
									return dobcheck;
								}
							});		
							System.out.println(" Customers are sorted on date of payment and last name!! ");
							break;
					case 10:System.out.println(" Enter the Admin email and password: "); 	
							if(CustomerUtils.authenticationadmin(sc.next(), sc.next(),customers))
							{ 
								boolean b=false;
								try{
									while(!b) 
									{
									System.out.println(" Enter 1 for displaying names of customers whom charges are pending of 3 month ");
									System.out.println(" Enter 2 for Removing names of customers whom charges are pending of 6 month ");
									System.out.println(" Enter any value for logging out of Admin... Choice : ");
									switch(sc.nextInt())
									{
										case 1: System.out.println(" These customers have not paid suscription fees from the last 3 months or more ");
												int n0=0;
												for(Customer a: customers)
												{	
													if (a.getLastpaidsuscription() != null) { //because admin has null values
													    Period p = Period.between(a.getLastpaidsuscription(), LocalDate.now());
													    if(p.getMonths()>=3||p.getYears()>0)
													    {	System.out.println(a);
													    	n0++;
													    }	
													}
												}
												System.out.println(" There are total "+n0+" customers in the list!! ");
												break;
										case 2: System.out.println(" Deleting customers who have not paid suscription fees from the last 6 months.. ");
												ListIterator<Customer> itr = customers.listIterator();
												int n1=0;
												while(itr.hasNext())
												{	
													Customer Custom=itr.next();
													if (Custom.getLastpaidsuscription() != null ) { //because admin has null values
														Period p=Period.between(Custom.getLastpaidsuscription(), LocalDate.now());
														if(p.getMonths()>=6||p.getYears()>0)
														{	
															
															n1++;
															itr.remove();
														}
													}
												}	
												System.out.println(" "+n1+" Customers deleted!! ");
												break;
												
										default:System.out.println("As your wish you are logged out!! ");
												b=true;
												break;
									}
									}
								}
								catch(Exception e){
									if(e instanceof InputMismatchException)
									{
										sc.nextLine();
									}
									e.printStackTrace();
									}
							}
							break;
					case 0:
						exit = true;
						break;
					default:System.out.println(" Invalid Choice Enter Again.... ");	
							break;
					}
				} catch (Exception E) {
					if(E instanceof InputMismatchException)
					{
						sc.nextLine();
					}
					E.printStackTrace();
				}
			}
		}	
	}	
}

