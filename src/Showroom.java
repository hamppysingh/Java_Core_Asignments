
public class Showroom {
	public Showroom(int vid, String name, String color, double price) {
		super();
		this.vid = vid;
		this.name = name;
		this.color = color;
		this.price = price-price*discount;
	}
	private int vid;
	private String name,color;
	private double price;
	private static double discount=0.15;
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price-price*discount;
	}
	@Override
	public String toString() {
		return "Showroom [vid=" + vid + ", name=" + name + ", color=" + color + ", price after discount =" + price + "]";
	}

}
