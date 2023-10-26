package ShowroomManagement;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Vehicle {
	public Vehicle(int vid, String chasisNo, String company, double basePrice, Date manufactureDate, Colors Carcolor) {
		this.vid = vid;
		this.ChasisNo = chasisNo;
		this.company = company;
		this.basePrice = basePrice;
		this.manufactureDate = manufactureDate;
		this.Carcolor = Carcolor;
		this.isavailable = true;
	}
	

	public Vehicle() {
		// TODO Auto-generated constructor stub
	}


	public static SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
	private int vid;
	private String ChasisNo,company;
	private double basePrice;
	private Date manufactureDate; 
	private Colors Carcolor;
	private boolean isavailable;
	@Override
	public String toString() {
		return "Vehicle (vid=" + vid + ", ChasisNo=" + ChasisNo + ", company=" + company + ", basePrice=" + basePrice
				+ ", manufactureDate=" + sdf.format(manufactureDate) + ", color=" + Carcolor + ", isavailable=" + isavailable + ")";
	}
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	public String getChasisNo() {
		return ChasisNo;
	}
	public void setChasisNo(String chasisNo) {
		ChasisNo = chasisNo;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public double getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}
	public Date getManufactureDate() {
		return manufactureDate;
	}
	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	public Colors getColor() {
		return Carcolor;
	}
	public void setColor(Colors Carcolor) {
		this.Carcolor = Carcolor;
	}
	public boolean isIsavailable() {
		return isavailable;
	}
	public void setIsavailable(boolean isavailable) {
		this.isavailable = isavailable;
	}
	public boolean equals(Object o) {
		System.out.println(" In vehicle's Equal ");
		if(o instanceof Vehicle)
		{
			Vehicle v=(Vehicle)o;
			return this.ChasisNo.equals(v.ChasisNo);
		}
		return false;
	}
	
}
