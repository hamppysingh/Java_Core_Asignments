package ShowroomManagement;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class ShowroomTester{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Scanner sc = new Scanner(System.in)) {
			// create suitable D.S
			List<Vehicle> showroom = new ArrayList<>();// up casting
			boolean exit = false;
			while (!exit) {
				System.out.println("Options : 1 . Add a Vehicle\n" + "2. Display all \n" + "3. Get Vehicle Details\n "
						+ "4. Apply discount\n " + "5. Apply discount on old vehicles\n "
						+ "6. Remove specific vehicle \n 7. Remove vehicles by color \n 8. Sort vehicles as per ch no 0.Exit");
				try {
					switch (sc.nextInt()) {
					case 1: // add a vehicle
						System.out.println(
								"Enter vehicle details : chasisNo,  vehicleColor,  price,  manufactureDate,	company");
						Vehicle vehicle = Validation.validateAllInputs(sc.next(), sc.next(), sc.nextDouble(), sc.next(), sc.next(),
								showroom);
						// => success
						showroom.add(vehicle);
						System.out.println("vehicle added....");
						break;
					case 2:
						System.out.println("Showroom details");
						for (Vehicle v : showroom)
							System.out.println(v);
						break;
					case 3:
						System.out.println("Enter chasis no , to get vehicle details");
						System.out.println(ShowroomUtils.findByChasisNo(sc.next(), showroom));
						break;
					case 4:
						System.out.println("Enter chasis no n discount");
						vehicle = ShowroomUtils.findByChasisNo(sc.next(), showroom);
						// => vehicle found
						vehicle.setPrice(vehicle.getPrice() - sc.nextDouble());
						System.out.println("Applied discount !");
						break;
					case 5:
						System.out.println("Enter date n discount");

						LocalDate date = Validation.parseAndValidateDate(sc.next());
						double discount = sc.nextDouble();
						for (Vehicle v : showroom)
							if (v.getManufactureDate().isBefore(date))
								v.setPrice(v.getPrice() - discount);
						System.out.println("applied discount ....");
						break;

					case 6:
						System.out.println("Enter ch no");
						boolean removed = showroom.remove(new Vehicle(sc.next()));
						if (removed)
							System.out.println("vehicle details removed");
						else
							throw new InvaliInputException("Vehicle details can't be removed : invalid ch no!!!!");
						break;
					case 7:
						System.out.println("Enter color");
						Colors c = Validation.parseAndValidateColor(sc.next());
						for (Vehicle v : showroom)
							if (v.getVehicleColor() == c)
								showroom.remove(v);
						System.out.println("deleted vehicle details");
						break;
					case 8:
						/*
						 Collection.sort(List<T> list;
						 JVM: TimSort ---sorting algo will internally call
						 [[v1,v2,v3,v4,v5v....]]
						 Vehicle's compare to ---> v1.compareT(v2) --> <0 or 0 : no shuffling
						 > 0 -->shuffling */
						System.out.println("Sorted data is : ");
						Collections.sort(showroom);
						break;

					case 0:
						exit = true;
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}
