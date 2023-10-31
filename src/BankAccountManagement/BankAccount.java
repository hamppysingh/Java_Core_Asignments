package BankAccountManagement;

import java.time.LocalDate;


public class BankAccount {
	private int acctNo;
	private String cname;
	private double balance;
	private LocalDate createdate,txndate;
	private Atype actype;
	private boolean isActive;
	@Override
	public String toString() {
		return "BankAccount [acctNo=" + acctNo + ", cname=" + cname + ", balance=" + balance + ", createdate="
				+ createdate + ", txndate=" + txndate + ", actype=" + actype + "]";
	}
	public int getAcctNo() {
		return acctNo;
	}
	public void setAcctNo(int acctNo) {
		this.acctNo = acctNo;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public LocalDate getCreatedate() {
		return createdate;
	}
	public void setCreatedate(LocalDate createdate) {
		this.createdate = createdate;
	}
	public LocalDate getTxndate() {
		return txndate;
	}
	public void setTxndate(LocalDate txndate) {
		this.txndate = txndate;
	}
	public Atype getActype() {
		return actype;
	}
	public void setActype(Atype actype) {
		this.actype = actype;
	}
	public BankAccount(int acctNo, String cname, Atype actype, double balance, LocalDate createdate) {
		super();
		this.acctNo = acctNo;
		this.cname = cname;
		this.actype = actype;
		this.balance = balance;
		this.createdate = createdate;// in real app : LocalDate.now()
		this.setActive(true);
		this.txndate = LocalDate.parse(this.createdate.toString());// in real app : LocalDate.now()
	}
	public void withdraw(double amt) {
		if(this.balance-amt<0)
			this.balance=0;
		this.balance=this.balance-amt;
	}
	public void deposit(double amt) {
		this.balance=this.balance+amt;
	}
	public void transferFunds(BankAccount dest, double transferAmount) throws InsufficientFundsException {
		this.withdraw(transferAmount);
		dest.deposit(transferAmount);
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
}
