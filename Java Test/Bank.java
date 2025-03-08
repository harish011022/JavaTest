abstract class BankAccount
{
    protected String accountNumber;
    protected double balance;

    public BankAccount(String accountNumber, double balance) 
    {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) 
    {
        if (amount > 0) 
        {
            balance += amount;
            System.out.println("Deposited rupees is: " + amount );
            System.out.println("Balance rupees is: " + balance );
        } 
        else 
        {
            System.out.println("Invalid deposit amount enter valid amount to be deposited.");
        }
    }

    public abstract void withdraw(double amount);

    public double getBalance() 
    {
        return balance;
    }
}

interface Transaction 
{
    void transfer(BankAccount toAccount, double amount);
}

class SavingsAcc extends BankAccount implements Transaction 
{
    private static final double minBalance = 500;

    public SavingsAcc(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount >= minBalance) 
        {
            balance -= amount;
            System.out.println("Withdrawn rupees is" + amount );
            System.out.println("New balance is :" + balance );
        } 
        else 
        {
            System.out.println("Withdrawal failed! Minimum balance of ₹500 required.");
            System.out.println("Enter valid amount to be withdrawn");
        }
    }

    @Override
    public void transfer(BankAccount toAccount, double amount) {
        if (balance - amount >= minBalance) 
        {
            balance -= amount;
            toAccount.deposit(amount);
            System.out.println("Transferred rupees is " + amount + " to " + toAccount.accountNumber + " your new balance is : " + balance);
        } 
        else 
        {
            System.out.println("Transfer failed! Insufficient balance.");
        }
    }
}

class CurrentAcc extends BankAccount implements Transaction {
    private static final double overDraft = -5000;

    public CurrentAcc(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount >= overDraft) 
        {
            balance -= amount;
            System.out.println("Withdrawn rupees is " + amount );
            System.out.println("New balance is  " + balance );
        } 
        else 
        {
            System.out.println("Withdrawal failed! Overdraft limit exceeded.");
        }
    }

    @Override
    public void transfer(BankAccount toAccount, double amount) 
    {
        if (balance - amount >= overDraft) 
        {
            balance -= amount;
            toAccount.deposit(amount);
            System.out.println("Transferred rupees is " + amount + " to " + toAccount.accountNumber + " your new balance is " + balance);
        } 
        else 
        {
            System.out.println("Transfer failed! Overdraft limit exceeded.");
        }
    }
}

public class Bank
{
    public static void main(String[] args) {
        SavingsAcc savings = new SavingsAcc("SHAR508461", 10000);
        CurrentAcc current = new CurrentAcc("CJAY508461", 2000);

        savings.deposit(1000); 
        current.withdraw(3000); 

        savings.transfer(current, 1500);
        current.transfer(savings, 6000); 

        current.deposit(4000);

        current.transfer(savings, 3000);
    }
}
