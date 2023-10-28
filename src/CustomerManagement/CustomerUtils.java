package CustomerManagement;

import java.util.List;

public class CustomerUtils {
	public static boolean authentication(String email,String password,List<Customer> L) throws InvalidInputException{
		Customer Cust=new Customer(email,password);
		if(!(L.contains(Cust)))
			throw new InvalidInputException(" Authenication failed...Email and password are not Matching !! ");
		return true;
	}
}
