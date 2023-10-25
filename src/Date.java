// 1.1 Define an interface Printable with a method print().
interface Printable {
    void print();
}

// Implement the Printable interface in the Employee class.
class Employee implements Printable {
    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void print() {
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Name: " + name);
    }
}

// Implement the Printable interface in the Shape class.
class Shapes implements Printable {
    private String shapeName;

    public Shapes(String shapeName) {
        this.shapeName = shapeName;
    }

    @Override
    public void print() {
        System.out.println("Shape: " + shapeName);
    }
}

// Implement the Printable interface in the Date class.
class Date implements Printable {
    private int day, month, year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public void print() {
        System.out.println("Date: " + day + "/" + month + "/" + year);
    }
}