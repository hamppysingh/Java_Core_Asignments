package ShowroomManagement;

import static java.time.LocalDate.parse;

import java.util.ArrayList;
import java.util.List;


public class ShowroomUtils {
//add a method to return found vehicle ref or throw exc
	public static Vehicle findByChasisNo(String chNo, List<Vehicle> list) throws InvaliInputException {
		Vehicle vehicle = new Vehicle(chNo);
		int index = list.indexOf(vehicle);
		if (index == -1)
			throw new InvaliInputException("Invalid ch no , Vehicle not found !!!!");
		System.out.println(list.get(index));
		return vehicle;
	}
	// add a static method to return a populate list of vehicles , with sample data
		public static List<Vehicle> populateShowroom() {
			List<Vehicle> vehicles = new ArrayList<>();
			vehicles.add(new Vehicle("abc-1233", Colors.WHITE, 456789, parse("2023-05-25"), "Honda"));
			vehicles.add(new Vehicle("abc-1235", Colors.RED, 556787, parse("2022-10-20"), "Maruti"));
			vehicles.add(new Vehicle("abc-1238", Colors.WHITE, 956789, parse("2023-05-25"), "Mahindra"));
			vehicles.add(new Vehicle("abc-1239", Colors.BLACK, 576787, parse("2023-10-21"), "Honda"));
			vehicles.add(new Vehicle("abc-1231", Colors.WHITE, 496789, parse("2022-08-20"), "Honda"));
			vehicles.add(new Vehicle("abc-1234", Colors.BLUE, 706787, parse("2023-05-25"), "Tata"));
			vehicles.add(new Vehicle("abc-1230", Colors.WHITE, 416789, parse("2022-08-20"), "Honda"));
			vehicles.add(new Vehicle("abc-1236", Colors.BLUE, 356787, parse("2023-05-25"), "Tata"));
		
			return vehicles;
		}
}
