package ShowroomManagement;

import java.time.LocalDate;

/*
 * chasisNo(string) : Unique ID, color(enum) , basePrice(double) ,
 *  manufactureDate(LocalDate),company,isAvailable
 */
public class Vehicle implements Comparable<Vehicle>{
	private String chasisNo;
	private Colors vehicleColor;
	private double price;//base price
	private LocalDate manufactureDate;
	private String company;
	private boolean isAvailable;	
	

	public Vehicle(String chasisNo, Colors vehicleColor, double price, LocalDate manufactureDate, String company) {
		super();
		this.chasisNo = chasisNo;
		this.vehicleColor = vehicleColor;
		this.price = price;
		this.manufactureDate = manufactureDate;
		this.company = company;
		this.isAvailable = true;
	}
	//add overloaded ctor to wrap PK
	public Vehicle(String chasisNo) {
		super();
		this.chasisNo = chasisNo;
	}

	
	//How to add a formatted date string instead of Date's toString?
	@Override
	public String toString() {
		return "Vehicle [chasisNo=" + chasisNo + ", vehicleColor=" + vehicleColor + ", price=" + (price+vehicleColor.getCharge())
				+ ", manufactureDate=" +manufactureDate + ", company=" + company + ", isAvailable=" + isAvailable
				+ "]";
	}

	



	@Override
	public boolean equals(Object o) {
		if (o instanceof Vehicle) {
			Vehicle v=(Vehicle)o;
			return this.chasisNo.equals(v.chasisNo);
		}
		return false;
	}
	
	@Override
	public int compareTo(Vehicle anotherVehicle)
	{
		return this.chasisNo.compareTo(anotherVehicle.chasisNo);
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getChasisNo() {
		return chasisNo;
	}
	public Colors getVehicleColor() {
		return vehicleColor;
	}
	public LocalDate getManufactureDate() {
		return manufactureDate;
	}
	public String getCompany() {
		return company;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	

}
