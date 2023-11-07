package SurpriseTest;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Customer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	public Customer(int custid, String fname, String lname, String address, String phoneno, String email,
			String password, LocalDate regdate, LocalDate planenddate, MessPlan mp, double final_amount) {
		super();
		this.custid = custid;
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.phoneno = phoneno;
		this.email = email;
		this.password = password;
		this.regdate = regdate;
		this.planenddate = planenddate;
		this.mp = mp;
		this.final_amount = final_amount;
	}
	public Customer(String email) {
		this.email=email;
	}
	public Customer(String email2, String password2) {
		// TODO Auto-generated constructor stub
		email=email2;
		password=password2;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return custid == other.custid;
	}
	@Override
	public String toString() {
		return "Customer [custid=" + custid + ", fname=" + fname + ", lname=" + lname + ", address=" + address
				+ ", phoneno=" + phoneno + ", email=" + email + ", regdate=" + regdate + ", planenddate=" + planenddate
				+ ", mp=" + mp + ", final_amount=" + final_amount + "]";
	}
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
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
	public LocalDate getRegdate() {
		return regdate;
	}
	public void setRegdate(LocalDate regdate) {
		this.regdate = regdate;
	}
	public LocalDate getPlanenddate() {
		return planenddate;
	}
	public void setPlanenddate(LocalDate planenddate) {
		this.planenddate = planenddate;
	}
	public MessPlan getMp() {
		return mp;
	}
	public void setMp(MessPlan mp) {
		this.mp = mp;
	}
	public double getFinal_amount() {
		return final_amount;
	}
	public void setFinal_amount(double final_amount) {
		this.final_amount = final_amount;
	}
	private int custid;
	private String fname,lname,address,phoneno,email,password;
	private LocalDate regdate,planenddate;
	MessPlan mp;
	public double final_amount = 0;
	
}
