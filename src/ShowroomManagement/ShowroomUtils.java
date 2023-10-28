package ShowroomManagement;

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
}
