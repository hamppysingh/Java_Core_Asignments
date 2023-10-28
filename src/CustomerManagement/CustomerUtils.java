package CustomerManagement;

import java.util.ArrayList;
import java.util.List;
import CustomerManagement.Validationrules;

public class CustomerUtils {
	public static boolean authentication(String email,String password,List<Customer> L) throws InvalidInputException{
		Customer Cust=new Customer(Validationrules.Checkmailsyntax(email),password);
		if(!(L.contains(Cust)))
			throw new InvalidInputException(" Authenication failed...Email and password are not Matching !! ");
		return true;
	}
	public static List<Customer> addcustomdata(List<Customer> List)
	{
		List.add(new Customer("Happy","Singh","praveen@gmail.com","Root@123",Validationrules.validateparse("2022-12-12"),2000.00,ServicePlan.GOLD));
		List.add(new Customer("Jinn","Von","jinn@gmail.com","Teddy245!",Validationrules.validateparse("2021-07-19"),10000.00,ServicePlan.PLATINUM));
		List.add(new Customer("Pedro","Capon","japon@mail.co","Cp09412$",Validationrules.validateparse("2023-09-26"),5000.00,ServicePlan.DIAMOND));
		List.add(new Customer("Flinto","Mito","jito@jinto.co.in","Nigga@12",Validationrules.validateparse("2021-08-11"),2000.00,ServicePlan.GOLD));
		List.add(new Customer("Raj","Singh","raj254@gmail.com","Raj12$23",Validationrules.validateparse("2020-06-01"),5000.00,ServicePlan.DIAMOND));
		List.add(new Customer("Maria","Lopez","mar25415@gmail.com","ML0pez!",Validationrules.validateparse("2023-02-15"),1000.00,ServicePlan.SILVER));
		List.add(new Customer("John","Smith","smito242@gmail.com","JSmith123!",Validationrules.validateparse("2022-11-27"),10000.00,ServicePlan.PLATINUM));
		List.add(new Customer("David","Jones","davidjon2542@gmail.com","DJones456!",Validationrules.validateparse("2023-10-31"),5000.00,ServicePlan.DIAMOND));
		List.add(new Customer("Lisa","Williams","lizard@gmail.com","LWilliams789!",Validationrules.validateparse("2023-03-24"),1000.00,ServicePlan.SILVER));
		return List;
	}
}
