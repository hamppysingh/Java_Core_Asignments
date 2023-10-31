package CustomerManagementHash;

import java.util.HashMap;
import java.util.Map;

import CustomerManagement.Customer;
import CustomerManagement.InvalidInputException;
import CustomerManagement.ServicePlan;

public class CustomerUtilshash {
	public static boolean authentication(String email,String password,Map<String,Customer> L) throws InvalidInputException{
		Customer Cust=new Customer(Validaterules.Checkmailsyntax(email),password);
		if(!(L.containsValue(Cust)))
			throw new InvalidInputException(" Authenication failed...Email and password are not Matching !! ");
		return true;
	}
	public static boolean authenticationadmin(String email,String password,Map<String,Customer> L) throws InvalidInputException{
		Customer Cust=new Customer(Validaterules.Checkmailsyntax(email),password);
		if(!(L.get("admin@admin").getEmail().equals(Cust.getEmail())&&(L.get("admin@admin").getPassword().equals(Cust.getPassword()))))
			throw new InvalidInputException(" Authenication failed...You are not the admin !! ");
		return true;
	}
	public static Map<String,Customer> addcustomdata()
	{	Map<String,Customer> map=new HashMap<>();
		map.put("praveen@gmail.com",new Customer("Happy","Singh","praveen@gmail.com","Root@123",Validaterules.validateparse("2002-12-12"),2000.00,Validaterules.validateparse("2020-02-19"),ServicePlan.GOLD));
		map.put("jinnbluevis@gmail.com",new Customer("Jinn","Von","jinnbluevis@gmail.com","Teddy245!",Validaterules.validateparse("2001-07-19"),10000.00,Validaterules.validateparse("2021-09-17"),ServicePlan.PLATINUM));
		map.put("japon@mail.co",new Customer("Pedro","Capon","japon@mail.co","Cp09412$",Validaterules.validateparse("2003-09-26"),5000.00,Validaterules.validateparse("2022-11-25"),ServicePlan.DIAMOND));
		map.put("jito@jinto.co.in",new Customer("Flinto","Mito","jito@jinto.co.in","Nigga@12",Validaterules.validateparse("2001-08-11"),2000.00,Validaterules.validateparse("2022-12-12"),ServicePlan.GOLD));
		map.put("raj254@gmail.com",new Customer("Raj","Singh","raj254@gmail.com","Raj12$23",Validaterules.validateparse("2000-06-01"),5000.00,Validaterules.validateparse("2023-04-02"),ServicePlan.DIAMOND));
		map.put("mar25415@gmail.com",new Customer("Maria","Lopez","mar25415@gmail.com","ML0pez!",Validaterules.validateparse("2003-02-15"),1000.00,Validaterules.validateparse("2022-12-12"),ServicePlan.SILVER));
		map.put("smito242@gmail.com",new Customer("John","Smith","smito242@gmail.com","JSmith123!",Validaterules.validateparse("2002-11-27"),10000.00,Validaterules.validateparse("2023-02-02"),ServicePlan.PLATINUM));
		map.put("davidjon2542@gmail.com",new Customer("David","Jones","davidjon2542@gmail.com","DJones456!",Validaterules.validateparse("2003-10-31"),5000.00,Validaterules.validateparse("2023-02-24"),ServicePlan.DIAMOND));
		map.put("lizard@gmail.com",new Customer("Lisa","Williams","lizard@gmail.com","LWilliams789!",Validaterules.validateparse("2003-03-24"),1000.00,Validaterules.validateparse("2023-10-12"),ServicePlan.SILVER));
		return map;
	}
}
