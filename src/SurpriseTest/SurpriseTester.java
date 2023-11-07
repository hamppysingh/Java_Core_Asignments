package SurpriseTest;

import java.util.HashMap;
import static SurpriseTest.CustomerMessValidations.*;
import static SurpriseTest.CustomerUtils.*;
import java.util.Map;

public class SurpriseTester {
	public static void main(String[] args) {
		try{
			Map<Integer,Customer> customer=new HashMap<>();
			customer.putAll(addcustomdata());
			
			customer.entrySet().forEach(k->System.out.println(k));
		}
		catch(Exception E)
		{
			E.printStackTrace();
		}
	}
}
