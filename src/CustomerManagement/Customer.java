package CustomerManagement;

import ShowroomManagement.Vehicle;

public class Customer implements Comparable<Customer>{
	private int cid;
	private String fname,lname,email,password;
	private double regamount;

	private ServicePlan sp;
	private static int autoinc=0;
	public Customer(String fname, String lname, String email, String password, double regamount, ServicePlan sp) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.regamount = regamount;
		this.sp = sp;
		this.cid=++autoinc;
	}
	public Customer(String email) {
		this.email=email;
	}
	public Customer(String email, String password) {
		this.email=email;
		this.password=password;
	}
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", regamount="
				+ regamount + ", sp=" + sp + "]";
	}
	public int getCid() {
		return cid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getRegamount() {
		return regamount;
	}
	public void setRegamount(double regamount) {
		this.regamount = regamount;
	}
	public ServicePlan getSp() {
		return sp;
	}
	public void setSp(ServicePlan sp) {
		this.sp = sp;
	}
	@Override
	public boolean equals(Object o) {
		if (o instanceof Customer) {
			Customer v=(Customer)o;
			return this.email.equals(v.email);
		}
		return false;
	}
	
	@Override
	public int compareTo(Customer cust)
	{
		System.out.println("in compareTo");
		return this.email.compareTo(cust.email)+this.password.compareTo(cust.password);
	}
}
