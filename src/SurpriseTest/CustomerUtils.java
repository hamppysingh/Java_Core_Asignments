package SurpriseTest;

import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;
import static SurpriseTest.CustomerMessValidations.*;
import SurpriseTest.InvalidInputException;

public class CustomerUtils {
	public static Map<Integer,Customer> addcustomdata() throws DateTimeParseException, IllegalArgumentException, DuplicateValueException, InvalidInputException, PlanNotMatchingException, CustomerManagement.InvalidInputException
	{	Map<Integer,Customer> map=new HashMap<>();
	map.put(1, CustomerMessValidations.ValidateDetails(1, "Happy", "Singh", "akurdi", "8342019522", "praveen@gmail.com", "Root@123", "2023-11-07", "MONTHLY", 3000.0, map));
	map.put(2, CustomerMessValidations.ValidateDetails(2, "Jinn", "Von", "pune", "5551234567", "jinnbluevis@gmail.com", "Teddy245!", "2023-11-08", "YEARLY", 32000.0, map));
	map.put(3, CustomerMessValidations.ValidateDetails(3, "Pedro", "Capon", "mumbai", "5551234568", "japon@mail.co", "Cp09412$", "2023-11-07", "MONTHLY", 3000.0, map));
	map.put(4, CustomerMessValidations.ValidateDetails(4, "Flinto", "Mito", "bangalore", "5551234569", "jito@jinto.co.in", "Nigga@12", "2023-11-08", "QUARTERLY", 11700.0, map));
	map.put(5, CustomerMessValidations.ValidateDetails(5, "Raj", "Singh", "delhi", "5551234570", "raj254@gmail.com", "Raj12$23", "2023-11-07", "HALFYEAR", 17500.0, map));
	map.put(6, CustomerMessValidations.ValidateDetails(6, "Maria", "Lopez", "myanmar", "5551234571", "mar25415@gmail.com", "ML0prez!", "2023-11-07", "YEARLY", 32000.0, map));
	map.put(7, CustomerMessValidations.ValidateDetails(7, "John", "Smith", "pcmc", "5551234572", "smito242@gmail.com", "JSmith123!", "2023-11-07", "MONTHLY", 3000.0, map));
	map.put(8, CustomerMessValidations.ValidateDetails(8, "David", "Jones", "nagpur", "5551234573", "davidjon2542@gmail.com", "DJones456!", "2023-11-07", "QUARTERLY", 11700.0, map));
	map.put(9, CustomerMessValidations.ValidateDetails(9, "Lisa", "Williams", "goa", "5551234574", "lizard@gmail.com", "LWilliams789!", "2023-11-08", "HALFYEAR", 17500.0, map));
	map.put(10, CustomerMessValidations.ValidateDetails(10, "Alice", "Smith", "New York, NY", "5551234565", "alicesmith@example.com", "StrongPass123!", "2023-11-08", "YEARLY", 32000.0, map));
	map.put(11, CustomerMessValidations.ValidateDetails(11, "Bob", "Johnson", "Los Angeles, CA", "5551234566", "bobjohnson@example.com", "SecurePwd567#", "2023-11-07", "MONTHLY", 3000.0, map));
	map.put(12, CustomerMessValidations.ValidateDetails(12, "Charlie", "Brown", "Chicago, IL", "5551234567", "charliebrown@example.com", "Brownie456!", "2023-11-08", "QUARTERLY", 11700.0, map));
	map.put(13, CustomerMessValidations.ValidateDetails(13, "David", "Wilson", "San Francisco, CA", "5551234568", "davidwilson@example.com", "Wilson#123", "2023-11-07", "HALFYEAR", 17500.0, map));
	map.put(14, CustomerMessValidations.ValidateDetails(14, "Eve", "Martin", "Miami, FL", "5551234569", "evemartin@example.com", "Martin456@", "2023-11-08", "YEARLY", 32000.0, map));
	map.put(15, CustomerMessValidations.ValidateDetails(15, "Frank", "Harris", "Dallas, TX", "5551234570", "frankharris@example.com", "HarrisPass123!", "2023-11-07", "MONTHLY", 3000.0, map));
	map.put(16, CustomerMessValidations.ValidateDetails(16, "Grace", "Thompson", "Boston, MA", "5551234571", "gracethompson@example.com", "GracePwd@567", "2023-11-08", "QUARTERLY", 11700.0, map));
	map.put(17, CustomerMessValidations.ValidateDetails(17, "Hannah", "Davis", "Seattle, WA", "5551234572", "hannahdavis@example.com", "DavisSecret123!", "2023-11-07", "HALFYEAR", 17500.0, map));
	map.put(18, CustomerMessValidations.ValidateDetails(18, "Isaac", "Allen", "New York, NY", "5551234573", "isaacallen@example.com", "AllenPass@789", "2023-11-08", "YEARLY", 32000.0, map));
	map.put(19, CustomerMessValidations.ValidateDetails(19, "Julia", "White", "Los Angeles, CA", "5551234574", "juliawhite@example.com", "White123456#", "2023-11-07", "MONTHLY", 3000.0, map));
	map.put(20, CustomerMessValidations.ValidateDetails(20, "Kevin", "Smith", "Chicago, IL", "5551234575", "kevinsmith@example.com", "SmithSecure123!", "2023-11-08", "QUARTERLY", 11700.0, map));
	map.put(21, CustomerMessValidations.ValidateDetails(21, "Linda", "Johnson", "San Francisco, CA", "5551234576", "lindajohnson@example.com", "Linda2023@", "2023-11-08", "HALFYEAR", 17500.0, map));
	map.put(22, CustomerMessValidations.ValidateDetails(22, "Michael", "Davis", "Miami, FL", "5551234577", "michaeldavis@example.com", "MichaelPwd123#", "2023-11-08", "YEARLY", 32000.0, map));
	map.put(23, CustomerMessValidations.ValidateDetails(23, "Nancy", "Harris", "Dallas, TX", "5551234578", "nancyharris@example.com", "NancySecure@567", "2023-11-07", "MONTHLY", 3000.0, map));
	map.put(24, CustomerMessValidations.ValidateDetails(24, "Oliver", "Martin", "Boston, MA", "5551234579", "olivermartin@example.com", "Oliver#2023", "2023-11-07", "QUARTERLY", 11700.0, map));
	map.put(25, CustomerMessValidations.ValidateDetails(25, "Penny", "Thompson", "Seattle, WA", "5551234580", "pennythompson@example.com", "Penny456!", "2023-11-08", "HALFYEAR", 17500.0, map));
	map.put(26, CustomerMessValidations.ValidateDetails(26, "Quincy", "Allen", "New York, NY", "5551234581", "quincyallen@example.com", "QuincyPass@123", "2023-11-07", "YEARLY", 32000.0, map));
	map.put(27, CustomerMessValidations.ValidateDetails(27, "Rachel", "White", "Los Angeles, CA", "5551234582", "rachelwhite@example.com", "RachelSecure456#", "2023-11-08", "MONTHLY", 3000.0, map));
	map.put(28, CustomerMessValidations.ValidateDetails(28, "Samuel", "Smith", "Chicago, IL", "5551234583", "samuelsmith@example.com", "Samuel#2023", "2023-11-08", "QUARTERLY", 11700.0, map));
	map.put(29, CustomerMessValidations.ValidateDetails(29, "Tina", "Johnson", "San Francisco, CA", "5551234584", "tinajohnson@example.com", "TinaSecure123@", "2023-11-07", "HALFYEAR", 17500.0, map));
		return map;
	}
	public static boolean Authetication(Map<String,Customer> mp,String email,String password) throws InvalidInputException {
		Customer C=new Customer(checkemailsyntax(email),validatepassword(password));
		if(!mp.containsValue(C))
		{
			throw new InvalidInputException(" Authentication failed.....You are not the Admin ");
		}
		return true;
	}
}
