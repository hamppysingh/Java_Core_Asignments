package CustomerManagementHash;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import CustomerManagement.Customer;
import CustomerManagement.InvalidInputException;

public class Customerhashtester{

	public static void main(String[] args) {

	    Map<String,Customer> customers = new HashMap<>();// up casting
	    customers.putIfAbsent("admin@admin",new Customer("Admin","admin@admin","Admin@123"));
	    customers.get("admin@admin").setCid(0);								//Admin email and password
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
							Customer customer=Validaterules.validateallinputs(sc.next(),sc.next(),sc.next(),sc.next(),sc.next(),sc.nextDouble(),sc.next(),sc.next(),customers);
							// => success
							customers.putIfAbsent(customer.getEmail(),customer);
							System.out.println("Customer registered....");
							break;
					case 2:	System.out.println("Enter Email and Password for Logging in..");
							String email1=sc.next();
							String pass1=sc.next();
							if(CustomerUtilshash.authentication(email1, pass1,customers))
							{
								Customer a=new Customer(email1,pass1);
								System.out.println(" Authentication successful...You are logged in ");
								System.out.println(" Did you pay the suscription : Y / N ");
								if(sc.next().toUpperCase().charAt(0)=='Y')
								{	
									
									System.out.println(" Enter the amount you paid, you can also pay more for upgrading your Plan : ");
									double amt=sc.nextDouble();
									if(customers.get(a.getEmail()).getSp().getCharge()==amt)
									{
										customers.get(a.getEmail()).setLastpaidsuscription(LocalDate.now());
										System.out.println(" Suscription payed...date updated ");
									}
									else
									{
										customers.get(a.getEmail()).setSp(Validaterules.RegAmountvalidate(customers.get(a.getEmail()).getSp(),amt));
										customers.get(a.getEmail()).setRegamount(amt);
										System.out.println(" Suscription payed...date updated ");
									}
								}
								else
									System.out.println(" Please pay the suscription charges asap!! ");
							}
							break;
					case 3:	System.out.println("Enter Email and Password for changing password");
							String em=sc.next();
							if(CustomerUtilshash.authentication(em, sc.next(),customers))
							{	
								System.out.println(" Enter the new password : ");
								String pass=sc.next();
								for(Customer t:customers.values()) {
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
							if(CustomerUtilshash.authentication(em1,pass,customers))
							{	Customer p=new Customer(em1,pass);
								if (!(customers.remove(p.getEmail(),p)))
									throw new InvalidInputException("Invalid Email , Customer not found !!!!");
								System.out.println(" Customer unsuscribed succesfully!! ");
							}	
							break;
	
					case 5:
							System.out.println("Customer details ");
							if(customers.size()==0)
								System.out.println(" Data Not Found!! ");
							for (Customer c : customers.values())
								System.out.println(c);
							break;
					case 6: customers.putAll(CustomerUtilshash.addcustomdata());
							System.out.println(" Added custom data to the list.... ");
							break;
					case 7: TreeMap<String, Customer> M = new TreeMap<>(customers);
							for(Map.Entry<String, Customer>m: M.entrySet())
								System.out.println(m);
							System.out.println(" Above are sorted Customers based on email!! ");
							break;
					case 8: ArrayList<Customer> C=new ArrayList<>(customers.values());
							Collections.sort(C,new Comparator<Customer> () {
							public int compare(Customer o1, Customer o2) {
								int dobcheck=0;	
								if(o1.getDob()!=null&&o2.getDob()!=null)
									{	
										dobcheck=o1.getDob().compareTo(o2.getDob());
									}
									return dobcheck;
								}
							
							});	
							for( Customer a:C)
								System.out.println(a);
							System.out.println(" Above are the sorted Customers on date of birth!! ");
							break;
					case 9: ArrayList<Customer> P=new ArrayList<>(customers.values());
							Collections.sort(P,new Comparator<Customer> () {
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
							for( Customer a:P)
								System.out.println(a);
							System.out.println("  Above are the sorted Customers on date of payment and last name!! ");
							break;
					case 10:System.out.println(" Enter the Admin email and password: "); 	
							if(CustomerUtilshash.authenticationadmin(sc.next(), sc.next(),customers))
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
												for(Customer a: customers.values())
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
												int n1=0,i=0;
												while(i!=customers.size())
												{   String key=null;
													for(Map.Entry<String,Customer> T:customers.entrySet())
													{	
														Customer F=customers.get(T.getKey());
														if (F.getLastpaidsuscription()!= null ) { //because admin has null values
															Period p=Period.between(F.getLastpaidsuscription(), LocalDate.now());
															if(p.toTotalMonths()>=6)
															{	
																n1++;
																key=T.getKey();
																break;
															}
														}
													}
													customers.remove(key);
													i++;
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
					case 0:System.out.println("As your wish you Exited...!! ");
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
