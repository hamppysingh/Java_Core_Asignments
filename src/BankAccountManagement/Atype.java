package BankAccountManagement;

public enum Atype {
	SAVING(1000),CURRENT(5000),FD(15000);
	private double minbalance;

	private Atype(double minbalance) {
		this.minbalance = minbalance;
	}

	public double getMinbalance() {
		return minbalance;
	}

	public void setMinbalance(int minbalance) {
		this.minbalance = minbalance;
	}

	double getMinBalance() {
		// TODO Auto-generated method stub
		return 0;
	}
}
