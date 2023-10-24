import java.util.Scanner;
public class Point2Dnew {
    private int x;
    private int y;

    public Point2Dnew() {
    	x=10;
    	y=20;
    }

    public Point2Dnew(int x, int y) {
        this.x = x;
        this.y = y;
    }
    

    public void acceptPoint() {
    	Scanner sc=new Scanner(System.in);
        System.out.println("Enter the x: ");
        x = sc.nextInt();

        System.out.println("Enter the y: ");
        y = sc.nextInt();
        sc.close();
    }
    public int getX()
    {
    	return x;
    }
    public int getY()
    {
    	return y;
    }
    public void setX(int x)
    {
    	this.x=x;
    }
    public void setY(int y)
    {
    	this.y=y;
    }

	@Override
	public String toString() {
		return "Point2D (x=" + x + ", y=" + y + ")";
	}
	public boolean isEqual(Point2Dnew p) {
        return this.x == p.x && this.y == p.y;
    }
	public double calculatedistance(Point2Dnew A) {
		return Math.sqrt(Math.pow((this.x-A.x),2)+Math.pow((this.y-A.y),2));
	}
}

