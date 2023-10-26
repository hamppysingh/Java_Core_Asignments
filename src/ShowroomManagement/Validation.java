package ShowroomManagement;

import java.util.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
public class Validation {
	public static SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
	static final String Str="01-01-2021";
	public static Date validatedate(String date) throws ParseException, OldVehicleException {
	    final Date defdate = sdf.parse(Str);
	    Date vdate = sdf.parse(date);
	    if (vdate.before(defdate)) {
	        throw new OldVehicleException("Vehicle is Old !!");
	    }
	    return vdate;
	}	
	public static Colors validateColor(String color) throws InvalidColorException {
		return Colors.valueOf(color.toUpperCase());
	}
	public static Vehicle validatingallinputs(int vid, String chasisNo, String company, double basePrice, String manufactureDate, String Carcolor) throws InvalidColorException,OldVehicleException,ParseException{
		Colors checkcolor=validateColor(Carcolor);
		Date checkdate=validatedate(manufactureDate);
		return new Vehicle(vid,chasisNo,company,basePrice,checkdate,checkcolor);
	}
}
