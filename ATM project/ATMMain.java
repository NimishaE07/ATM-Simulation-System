import java.util.Scanner;
class ATM {
    private double balance;
    private int pin;

  
    ATM(double balance, int pin) {
        this.balance = balance;
        this.pin = pin;
    }

    
    boolean validatePin(int enteredPin) {
        return this.pin == enteredPin;
    }

    
    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    
    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdraw successful.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    
    void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }
}


public class ATMMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

       
        ATM atm = new ATM(5000, 1234);

        System.out.print("Enter PIN: ");
        int enteredPin = sc.nextInt();

        
        if (!atm.validatePin(enteredPin)) {
            System.out.println("Wrong PIN. Access Denied.");
            return;
        }

        int choice;

        
        while (true) {
            System.out.println("\n1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount: ");
                    atm.deposit(sc.nextDouble());
                    break;

                case 2:
                    System.out.print("Enter amount: ");
                    atm.withdraw(sc.nextDouble());
                    break;

                case 3:
                    atm.checkBalance();
                    break;

                case 4:
                    System.out.println("Thank you for using ATM.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
