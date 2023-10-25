import java.util.ArrayList;
import java.util.Scanner;

public class Emptester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Emp> employees = new ArrayList<>();

        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Hire Manager");
            System.out.println("2. Hire Worker");
            System.out.println("3. Display Employee Information");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Manager details (id, name, deptId, basicSalary, perfBonus): ");
                    int id = scanner.nextInt();
                    String name = scanner.next();
                    int deptId = scanner.nextInt();
                    double basicSalary = scanner.nextDouble();
                    double perfBonus = scanner.nextDouble();
                    employees.add(new Mgr(id, name, deptId, basicSalary, perfBonus));
                    System.out.println("Manager hired successfully.");
                    break;

                case 2:
                    System.out.print("Enter Worker details (id, name, deptId, basicSalary, hoursWorked, hourlyRate): ");
                    id = scanner.nextInt();
                    name = scanner.next();
                    deptId = scanner.nextInt();
                    basicSalary = scanner.nextDouble();
                    double hoursWorked = scanner.nextDouble();
                    double hourlyRate = scanner.nextDouble();
                    employees.add(new Worker(id, name, deptId, basicSalary, hoursWorked, hourlyRate));
                    System.out.println("Worker hired successfully.");
                    break;

                case 3:
                    System.out.println("Employee Information:");
                    for (Emp employee : employees) {
                        System.out.println(employee);
                        System.out.println("Net Salary: " + employee.computeNetSalary());
                        if (employee instanceof Mgr) {
                            Mgr manager = (Mgr) employee;
                            System.out.println("Performance Bonus: " + manager.getPerformanceBonus());
                        } else if (employee instanceof Worker) {
                            Worker worker = (Worker) employee;
                            System.out.println("Hourly Rate: " + worker.getHourlyRate());
                        }
                        System.out.println();
                    }
                    break;

                case 4:
                    System.out.println("Exiting the program.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);

        scanner.close();
    }
}