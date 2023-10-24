import java.util.Scanner;

public class BankTester {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Enter your account number: ");
	        int accountNumber = scanner.nextInt();

	        System.out.println("Enter your name: ");
	        String customerName = scanner.next();

	        System.out.println("Your balance?: ");
	        double balance = scanner.nextDouble();

	        BankApplication bankAccount = new BankApplication(accountNumber, customerName, balance);

	        int choice;
	        double amount;

	        while(true){
	            System.out.println(" 1. Deposit  2. Withdraw  3. Check balance 4. Exit ");
	            System.out.println(" Enter choice: ");
	            choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                    System.out.println(" Enter amount to deposit: ");
	                    amount = scanner.nextDouble();
	                    bankAccount.deposit(amount);
	                    break;
	                case 2:
	                    System.out.println(" Enter amount to withdraw: ");
	                    amount = scanner.nextDouble();
	                    bankAccount.withdraw(amount);
	                    break;
	                case 3:
	                    bankAccount.display();
	                    break;
	                case 4: 
	                	scanner.close();
	                	System.out.println(" Exiting!! ");
	                	System.exit(0);
	                default:
	                    System.out.println(" Invalid input!! Enter again please : ");
	            }
	        }  
	 }
}
