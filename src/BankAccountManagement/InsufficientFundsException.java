package BankAccountManagement;

public class InsufficientFundsException extends Exception {
	public InsufficientFundsException(String mesg) {
		super(mesg);
	}
}
