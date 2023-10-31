package BankAccountManagement;

public enum Atype {
	SAVING(1000),CURRENT(5000),FD(15000);
	private int minbalance;

	private Atype(int minbalance) {
		this.minbalance = minbalance;
	}

	public int getMinbalance() {
		return minbalance;
	}

	public void setMinbalance(int minbalance) {
		this.minbalance = minbalance;
	}
}
