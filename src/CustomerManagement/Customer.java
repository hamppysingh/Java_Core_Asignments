package CustomerManagement;

import java.time.LocalDate;

public class Customer {
	private int cid;
	private String fname,lname,email,password;
	private double regamount;
	private LocalDate dob;
	private ServicePlan sp;
	public Customer(String fname, String lname, String email, String password, double regamount, LocalDate dob,
			ServicePlan sp) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.regamount = regamount;
		this.dob = dob;
		this.sp = sp;
	}
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", regamount="
				+ regamount + ", dob=" + dob + ", sp=" + sp + "]";
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
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
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public ServicePlan getSp() {
		return sp;
	}
	public void setSp(ServicePlan sp) {
		this.sp = sp;
	}
}
