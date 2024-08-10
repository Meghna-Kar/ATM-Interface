import java.util.ArrayList;
//This manages the account info of the customer
public class Account {
    private String pin;
    private double balance;
    private ArrayList<String> transactionHistory;

    public Account(String pin, double initialBalance){
        this.pin = pin;
        this.balance = initialBalance;
        this.transactionHistory= new ArrayList<>();
    }
    //To check the pin number
    public boolean validatePIN(String inputPIN){
        return
                this.pin.equals(inputPIN);
    }
    //to get the balance
    public double getBalance(){
        return this.balance;
    }
    //to deposit amount
    public void deposit(double amount){
        this.balance += amount;
        this.transactionHistory.add("Deposited: Rs."+amount);
    }
    // to withdraw amount from the existing balance
    public boolean withdraw(double amount){
        if (amount> this.balance){
            return false;
        }
        else{
            this.balance-=amount;
            this.transactionHistory.add("Withdraw: Rs."+amount);
            return true;
        }
    }
    // to modify pin
    public void changePIN(String newPIN){
        this.pin=newPIN;
    }
    //to get the transaction history performed
    public ArrayList<String> getTransactionHistory(){
        return this.transactionHistory;
    }
}
