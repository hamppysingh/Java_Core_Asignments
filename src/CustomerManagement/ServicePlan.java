package CustomerManagement;

public enum ServicePlan {
		SILVER(1000),GOLD(2000),DIAMOND(5000),PLATINUM(10000);
		private double charge;
		ServicePlan(double charge) {
			this.charge=charge;
		}
		public double getCharge() {
			return charge;
		}

		public void setCharge(int charge) {
			this.charge = charge;
		}
		
	}