package ShowroomManagement;

public enum Colors{
	RED(1000),
	BLACK(5000),
	WHITE(3000),
	BLUE(4000),
	VIOLET(7000),
	GREEN(6000);
	private int charge;
	
	private Colors(int charge) {
		this.charge = charge;
	}

	public int getCharge() {
		return charge;
	}

	public void setCharge(int charge) {
		this.charge = charge;
	}
	
}