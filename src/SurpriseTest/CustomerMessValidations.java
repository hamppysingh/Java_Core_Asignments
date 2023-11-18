package SurpriseTest;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.Map;


public class CustomerMessValidations {
	public static Customer ValidateDetails(int custid, String fname, String lname, String address, String phoneno, String email,
			String password, String regdate, String mp, double final_amount,Map<Integer,Customer> cm) throws DuplicateValueException, DateTimeParseException, InvalidInputException, IllegalArgumentException, PlanNotMatchingException {
		int checkdupid=checkcustid(cm,custid);
		MessPlan m=checkplanvalue(checkplan(mp),final_amount);
		String checkedemail=checkdupemail(checkemailsyntax(email),cm);
		LocalDate checkregdate=validatedate(regdate);
		LocalDate checkplandate=planendvalidate(checkregdate,m);
		String validpass=validatepassword(password);
		String checkmob=validatemobile(phoneno);
		return new Customer(checkdupid,fname,lname,address,checkmob,checkedemail,validpass,checkregdate,checkplandate,m,final_amount);
		
	}
	public static String validatemobile(String phoneno) throws InvalidInputException {
		if(!((phoneno.length()==10)&&phoneno.matches("^[0123456789]*$")))
			throw new InvalidInputException("Phone Number is not valid!! ");
		return phoneno;
	}
	public static String validatepassword(String password) throws InvalidInputException {
		if(!password.matches("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[#@$*%&?!]).{8,}"))
			throw new InvalidInputException(" Password is weak \n\" It should have 1 number,1 uppercase, 1 lowercase, 1  and its length should be 8 or more... ");
		return password;
	}
	public static LocalDate planendvalidate(LocalDate validatedate,MessPlan m) {
		// TODO Auto-generated method stub
		if(m.name().equals("MONTHLY"))
			return validatedate.plusMonths(1);
		else if(m.name().equals("QUATERLY"))
			return validatedate.plusMonths(3);
		else if(m.name().equals("HALFYEARLY"))
			return validatedate.plusMonths(6);
		else
			return validatedate.plusYears(1);
	}

	public static LocalDate validatedate(String anydate) throws DateTimeParseException{
		// TODO Auto-generated method stub
		return LocalDate.parse(anydate);
	}

	public static String checkemailsyntax(String email) throws InvalidInputException {
		if(email.matches("[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\\\.[A-Za-z]{2,}"))
			throw new InvalidInputException(" The email you provided has wrong syntax!! ");
		return email;
	}

	public static String checkdupemail(String email, Map<Integer, Customer> cm) throws DuplicateValueException {
		Customer c=new Customer(email);
		if(cm.values().contains(c))
			throw new DuplicateValueException(" Email you provide is duplicate!!!  ");
		return email;
	}

	public static MessPlan checkplanvalue(MessPlan checkplan, double final_amount) throws PlanNotMatchingException {
		if(!(checkplan.getPlanCharge()==final_amount))
			throw new PlanNotMatchingException(" The amount you playing is not matching any of the plans!! ");
		return null;
	}

	public static MessPlan checkplan(String mp) throws IllegalArgumentException{
		// TODO Auto-generated method stub
		return MessPlan.valueOf(mp.toUpperCase());
	}

	public static int checkcustid(Map<Integer,Customer> cm,int custid) throws DuplicateValueException {
		// TODO Auto-generated method stub
		if(cm.containsKey(custid))
			throw new DuplicateValueException(" Customer Id already present cannot Enter duplicate one!!  ");
		return custid;
	}
}
