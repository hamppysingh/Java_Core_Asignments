package CustomerManagement;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

public class Validationrules {
	public static ServicePlan PlanValidate(String sp) throws IllegalArgumentException{
		return ServicePlan.valueOf(sp.toUpperCase());
	}
	public static String validatepassword(String password) throws InvalidInputException{
		if(!password.matches("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[#@$*%&?]).{8,}"))
			throw new InvalidInputException(" Password is weak \n\" It should have 1 number,1 uppercase, 1 lowercase, 1  and its length should be 8 or more... ");
		return password;
	}
	public static String Checkmailsyntax(String email) throws InvalidInputException{
		if(!email.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$"))
			throw new InvalidInputException(" The email you entered is not valid!! ");
		return email.toLowerCase();
	}
	public static String validatemail(String email,List<Customer> L) throws DuplicateValueException{
		Customer M=new Customer(email);
		if(L.contains(M))
			throw new DuplicateValueException(" Email is already Present in the List!! ");
		
		return email;
	}
	public static LocalDate validateparse(String dop) throws DateTimeParseException{
		return LocalDate.parse(dop);
	}
	public static ServicePlan RegAmountvalidate(ServicePlan sp,Double regamount) throws InvalidInputException{
		try{
			if(sp.getCharge()!=regamount)
			 {
				
				throw new ValidNotCorrect(" The Amount you paid was not for the suscription you selected....Don't worry we have reward you with your respective suscription...");
			 }
			return sp;
		 }
		 catch(ValidNotCorrect e){
			 	e.printStackTrace();
			 	String name = null;
				for(ServicePlan a:sp.values())
				{	if(a.getCharge()==regamount)
					{
						name=a.name();
						break;
					}
				}
				if(name==null)
					throw new InvalidInputException("The Amount you paid does not match any of the Service Plan prices!! \n Prices : 1000 for Silver\n\t 2000 for Gold\n\t 5000 for Diamond\n\t 10000 for Platinum...");
				sp=ServicePlan.valueOf(name.toUpperCase());
				System.out.println(" Congrats you were rewarded with "+sp.name()+" suscription...");
				return sp;
		 }
	}
	public static Customer validateallinputs(String fname, String lname, String email, String password,String dop, double regamount, String sp,List<Customer> C) throws DateTimeParseException,InvalidInputException,DuplicateValueException{
		String checkmail=validatemail(Checkmailsyntax(email),C);
		String passwd=validatepassword(password);
		LocalDate paydate=validateparse(dop);
		ServicePlan checkplan=RegAmountvalidate(PlanValidate(sp),regamount);
		return new Customer(fname,lname,checkmail,passwd,paydate,regamount,checkplan);
	}
}

