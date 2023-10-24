import java.util.Scanner;
public class Point2D {
    private int x;
    private int y;

    public Point2D() {
    	x=10;
    	y=20;
    }

    public Point2D(int x, int y) {
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

    public String toString(int i) {
        return "Point "+i+1+" is : "+"(" + x + "," + y + ")";
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
 }

