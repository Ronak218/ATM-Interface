import java.util.*;

class BankAccount{
    private double balance;

    public BankAccount(double initialBalance)
    {
        this.balance = initialBalance;
    }
    public double getBalance()
    {
        return balance;
    }

    public void deposit(double amount)
    {
        if(amount > 0){
            balance += amount;
            System.out.println("Deposit Successful. New balance : " + balance);
        }
        else{
            System.out.println("Invalid amount deposited !");
        }
    }

    public void withdraw(double amount)
    {
        if(amount > 0 && amount <= balance){
            balance -= amount;
            System.out.println("Withdrawl Successful. New balance : " + balance);
        }
        else{
            System.out.println("Invalid amount for withdrawl !");
        }
    }
}


class ATM 
{
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account){
        this.account = account;
        this.scanner=new Scanner (System.in);
    }

    public void showMenu()
    {
        System.out.println("1. Check balance ");
        System.out.println("2. Deposit ");
        System.out.println("3. Withdraw ");
        System.out.println("4. Exit ");
    }

    public void run()
    {
        int choice;
        do{
            showMenu();
            System.out.println("Enter your choice : ");
            choice = scanner.nextInt();
            switch(choice)
            {
                case 1:
                     checkBalance();
                     break;
                case 2:
                     deposit();
                     break;
                case 3:
                     withdraw();
                     break;
                case 4:
                     System.out.println("Thank you for using ATM !");
                     break;
                default:
                     System.out.println("Invalid Choice. Please select a valid option.");
            }
        }
        while( choice != 4);
    }

    private void checkBalance()
    {
        System.out.println("Your Balance is : "+account.getBalance());
    }

    private void deposit()
    {
        System.out.println("Enter amount to deposit : ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }

    private void withdraw()
    {
        System.out.println("Enter amount to withdraw : ");
        double amount = scanner.nextDouble();
        account.withdraw(amount);
    }
}

public class ATM_Interface
{
    public static void main(String[] args) 
    {
        System.out.println("WELCOME TO ATM ! ");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your four digit pin : ");
        int pin=sc.nextInt();

        BankAccount userAccount = new BankAccount(1000.0);
        ATM atm = new ATM(userAccount);
        atm.run();
    }
}