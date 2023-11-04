package ShowroomManagement;

import java.time.LocalDate;
import java.util.List;


public class Validation {
//add a method to parse n validate color
	public static Colors parseAndValidateColor(String clr) throws IllegalArgumentException // optional
	{
		return Colors.valueOf(clr.toUpperCase());// throws IllegalArgumentExc
	}

	// add a method to parse n validate manu. date : after 1st Jan 2022
	public static LocalDate parseAndValidateDate(String date) throws InvaliInputException {
		// parsing
		LocalDate manuDate = LocalDate.parse(date);
		// parsing success --> validations
		LocalDate checkDate = LocalDate.of(2022, 1, 1);
		if (manuDate.isBefore(checkDate))
			throw new InvaliInputException("Manu date must be after 1st Jan 2022");
		return manuDate;
	}
	//add a method to check for dups
	//in case of dup vehicle : throw custom exc
	public static void checkForDup(String chNo,List<Vehicle> vehicles) throws InvaliInputException
	{
		Vehicle newVehicle=new Vehicle(chNo);
		if(vehicles.contains(newVehicle))
			throw new InvaliInputException("Dup ch no!!!!!");
	}
	

	// add a method to validate all i/ps
	public static Vehicle validateAllInputs(String chasisNo, String vehicleColor, double price, String manufactureDate,
			String company,List<Vehicle> vehicles) throws IllegalArgumentException, InvaliInputException {
		Colors color = parseAndValidateColor(vehicleColor);
		LocalDate validatedDate = parseAndValidateDate(manufactureDate);
		checkForDup(chasisNo, vehicles);
		//=> i/ps are valid
		return new Vehicle(chasisNo, color, price, validatedDate, company);
	}
}