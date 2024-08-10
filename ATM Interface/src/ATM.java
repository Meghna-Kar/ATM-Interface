import java.util.ArrayList;
// this consists of all the functions take place in atm
public class ATM {
    private Account account; //accessing account class in ATM class 

    public ATM(Account account){
        this.account=account;
    }
    public boolean validatePIN(String inputPIN){
        return account.validatePIN(inputPIN);
    }
    public double getBalance(){
        return account.getBalance();
    }
    public void deposit(double amount){
        account.deposit(amount);
    }
    public boolean withdraw(double amount){
        return account.withdraw(amount);
    }
    public void changePIN(String newPIN){
        account.changePIN(newPIN);
    }
    public ArrayList<String> getTransactionHistory(){
        return  account.getTransactionHistory();
    }
}
