package CustomerManagement;

import java.time.LocalDate;


public class Customer implements Comparable<Customer>{
	private int cid;
	private String fname,lname,email,password;
	private LocalDate dob,lastpaidsuscription;
	private double regamount;

	private ServicePlan sp;
	private static int autoinc=0;
	public Customer(String fname, String lname, String email, String password, LocalDate dob, double regamount,LocalDate lastpaidsuscription,
			ServicePlan sp) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.regamount = regamount;
		this.lastpaidsuscription=lastpaidsuscription;
		this.sp = sp;
		this.cid=++autoinc;
	}
	public LocalDate getLastpaidsuscription() {
		return lastpaidsuscription;
	}
	public void setLastpaidsuscription(LocalDate lastpaidsuscription) {
		this.lastpaidsuscription = lastpaidsuscription;
	}
	public Customer(String fname,String email,String password) {
		this.fname = fname;
		this.email = email;
		this.password = password;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
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
		return "Customer [cid=" + cid + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", dob=" + dob
				+ ", lastpaidsuscription=" + lastpaidsuscription + ", regamount=" + regamount + ", sp=" + sp + "]";
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
	public void setCid(int cid) {
		this.cid = cid;
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
			return this.email.equals(v.email)&&this.password.equals(v.password);
		}
		return false;
	}
	@Override
	public int compareTo(Customer cust)
	{	
		return this.email.compareTo(cust.email);
	}
}
