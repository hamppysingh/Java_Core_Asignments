package CustomerManagement;

import java.time.LocalDate;

public class Validationrules {
	public static ServicePlan PlanValidate(String sp) throws IllegalArgumentException{
		return ServicePlan.valueOf(sp.toUpperCase());
	}
	public static LocalDate Dateparse(String dob) throws InvalidInputException{
		return LocalDate.parse(dob);
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
	public static Customer validateallinputs(String fname, String lname, String email, String password, double regamount, String dob, String sp) throws InvalidInputException{
		ServicePlan checkplan=RegAmountvalidate(PlanValidate(sp),regamount);
		LocalDate checkdate=Dateparse(dob);
		return new Customer(fname,lname,email,password,regamount,checkdate,checkplan);
	}
}

