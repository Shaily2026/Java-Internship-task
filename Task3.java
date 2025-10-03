import java.util.*;
class BankAccount{
    private double balance;
    public BankAccount(double balance){
        this.balance = balance;
    }
    public void deposit(double amount){
        balance+= amount;
    }
    public boolean withDraw(double amount){
        if(balance >= amount){
            balance -= amount;
            return true;
        }
        return false;
    }
    public double checkBalance() {
        return balance;
    }
}

// Class to Represent ATM Machine
class ATM {
    private BankAccount account ;

    public ATM(BankAccount account){
        this.account = account;
    }
    public void displayMenu(){
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. WithDraw");
            System.out.println("2. Check Balance");
            System.out.println("4. Exit");
            System.out.println("Choose an option:");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw");
                    double withdrawAmount = sc.nextDouble();
                    if (account.withDraw(withdrawAmount)) {
                        System.out.println("Withdrawal successful");
                    }else{
                        System.out.println("Insufficient balance.");
                    }
                    break;
            case 2:
                 System.out.print("Enter amount to deposit:");
                 double depositAmount = sc.nextDouble();
                 account.deposit(depositAmount);
                 System.out.println("Deposit Successful.");
                 break;
            case 3:
                System.out.println("Balance :"+ account.checkBalance()); 
                break;
            case 4:
                System.out.println("Existing...");  
                return;      
                default:
                System.out.println("Invalid option. Try again.");
                
            }
        }
    }
}
 public class Task3 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0); // Initial Balance
        ATM atm = new ATM(account);
        atm.displayMenu();
    }
}
