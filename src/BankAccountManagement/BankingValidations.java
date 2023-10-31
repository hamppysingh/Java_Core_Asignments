package BankAccountManagement;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;


import CustomerManagement.InvalidInputException;

public class BankingValidations {
	// add a method to validate min balance
	public static void validateBalance(Atype type, double balance) throws InsufficientFundsException {
		if (balance <= type.getMinbalance())
			throw new InsufficientFundsException("Balance too low!!!!");
	}

	// validate a/c type
	public static Atype parseAndValidateType(String type) {
		return Atype.valueOf(type.toUpperCase());
	}

	// In case of no txs (withdraw , deposit, funds transfer) ,
	// in 1 year , disable a/c status
	public static void disableAccounts(Map<Integer, BankAccount> acctMap) {
		// since it's searching based upon : value based criteria ,
		// Map ---> Collection<V> : values()
		for (BankAccount a : acctMap.values()) {
			long periodInMonths = Period.between(a.getTxndate(), LocalDate.now()).toTotalMonths();
			if (periodInMonths > 12)
				a.setActive(false);
		}
		System.out.println("a/c status updated by admin!");

	}

	public static BankAccount validateAllInputs(int acctNo, String customerName, String acctType, double balance,
			String creationDate, Map<Integer, BankAccount> map)
			throws InvalidInputException, InsufficientFundsException {
		if (map.containsKey(acctNo))
			throw new InvalidInputException("Dup acct no!!!!");
		Atype type = parseAndValidateType(acctType);
		validateBalance(type, balance);
		LocalDate date = LocalDate.parse(creationDate);
		return new BankAccount(acctNo, customerName, type, balance, date);

	}

}
