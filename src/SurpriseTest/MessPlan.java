package SurpriseTest;

public enum MessPlan {
	MONTHLY(3000),QUARTERLY(11700),HALFYEAR(17500),YEARLY(32000);
	private int PlanCharge;
	MessPlan(int i) {
		// TODO Auto-generated constructor stub
		PlanCharge=i;
	}
	public int getPlanCharge() {
		return PlanCharge;
	}
	public void setPlanCharge(int planCharge) {
		PlanCharge = planCharge;
	}
}
