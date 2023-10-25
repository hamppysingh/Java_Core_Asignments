
public class Dateinterfacetester {
	    public static void main(String[] args) {
	        // Testing the Printable interface
	        Employee emp = new Employee(1, "John");
	        Shapes shapes = new Shapes("Circle");
	        Date date = new Date(25, 10, 2023);

	        // Create an array of Printable objects
	        Printable[] printables = { emp, shapes, date };

	        System.out.println("Printing using Printable interface:");
	        for (Printable printable : printables) {
	            printable.print();
	        }
	    }     
}
