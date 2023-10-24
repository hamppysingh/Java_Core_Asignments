import java.util.Scanner;

public class BankApplication {

    private int accountNumber;
    private String customerName;
    private double balance;

    public BankApplication() {
        this.setAccountNumber(1);
        this.setCustomerName("default");
        this.balance = 100;
    }

    public BankApplication(int accountNumber, String customerName, double balance) {
        this.setAccountNumber(accountNumber);
        this.setCustomerName(customerName);
        this.balance = balance;
    }

    public void withdraw(double amount) {
        if (this.balance < amount) {
            System.out.println("Insufficient balance");
        } else {
            this.balance -= amount;
        }
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void display() {
        System.out.println("The available balance is " + this.balance);
    }

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

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
}