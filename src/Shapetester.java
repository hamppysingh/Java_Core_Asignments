import java.util.ArrayList;
import java.util.Scanner;
class ShapeFactory {
    private ArrayList<Shape> shapes = new ArrayList<>();

    public void addCircle(double x, double y, double radius) {
        shapes.add(new Circle(x, y, radius));
    }

    public void addRectangle(double x, double y, double width, double height) {
        shapes.add(new Rectangle(x, y, width, height));
    }

    public void addSquare(double x, double y, double side) {
        shapes.add(new Square(x, y, side));
    }

    public void showAll() {
        for (Shape shape : shapes) {
            System.out.println(shape);
            System.out.println("Area: " + shape.area());
            System.out.println();
        }
    }
}

public class Shapetester {
	 public static void main(String[] args) {
	        ShapeFactory factory = new ShapeFactory();
	        Scanner scanner = new Scanner(System.in);

	        int choice;

	        do {
	            System.out.println("Menu:");
	            System.out.println("1: Show All");
	            System.out.println("2: Add Circle");
	            System.out.println("3: Add Rectangle");
	            System.out.println("4: Add Square");
	            System.out.println("0: Exit");
	            System.out.print("Enter your choice: ");
	            choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                    factory.showAll();
	                    break;
	                case 2:
	                    System.out.print("Enter x, y, and radius: ");
	                    double x = scanner.nextDouble();
	                    double y = scanner.nextDouble();
	                    double radius = scanner.nextDouble();
	                    factory.addCircle(x, y, radius);
	                    break;
	                case 3:
	                    System.out.print("Enter x, y, width, and height: ");
	                    x = scanner.nextDouble();
	                    y = scanner.nextDouble();
	                    double width = scanner.nextDouble();
	                    double height = scanner.nextDouble();
	                    factory.addRectangle(x, y, width, height);
	                    break;
	                case 4:
	                    System.out.print("Enter x, y, and side length: ");
	                    x = scanner.nextDouble();
	                    y = scanner.nextDouble();
	                    double side = scanner.nextDouble();
	                    factory.addSquare(x, y, side);
	                    break;
	            }
	        } while (choice != 0);

	        scanner.close();
	    }
}
