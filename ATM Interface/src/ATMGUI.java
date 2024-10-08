import javax.swing.*;
import java.awt.*;
import java.awt.ActiveEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
// this consists of layout of the interface
public class ATMGUI {
    private ATM atm;
    private JFrame frame;
    private JPanel panel;
    private JTextArea display;
    private JTextField input;
    private JButton submitButton;

    public ATMGUI(ATM atm){
        this.atm=atm;
        createGUI();
    }
    //creating frame and panel
    private void createGUI(){
        frame= new JFrame("ATM Machine");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,300);
        panel= new JPanel();
        panel.setLayout(new BorderLayout());
        display= new JTextArea();
        display.setEditable(false);
        panel.add(new JScrollPane(display),BorderLayout.CENTER);
        input=new JTextField();
        panel.add(input, BorderLayout.NORTH);
        submitButton=new JButton("Submit");
        // adding event on submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processInput();
            }
        });
        panel.add(submitButton,BorderLayout.SOUTH);
        frame.add(panel);
        frame.setVisible(true);
    }
    private void processInput(){
        String command= input.getText().trim();
        input.setText("");
// consists of all the conditions to be verified to perform a task
        if (command.startsWith("PIN ")){
            String pin= command.substring(4);
            if(atm.validatePIN(pin)){
                display.setText("PIN validated.\n");
            }else {
                display.setText("Invalid PIN.\n");
            }
        } else if (command.startsWith("BALANCE")) {
            display.setText("Balance: Rs." + atm.getBalance() + "\n");

        } else if (command.startsWith("DEPOSIT")) {
            double amount = Double.parseDouble(command.substring(8));
            atm.deposit(amount);
            display.setText("Deposited: Rs."+ amount+"\n");
        } else if (command.startsWith("WITHDRAW")) {
            double amount = Double.parseDouble(command.substring(9));
            if(atm.withdraw(amount)){
                display.setText("Withdraw: Rs."+ amount +"\n");
            }else {
                display.setText("Insufficient Funds.\n");
            }
        } else if (command.startsWith("PINCHANGE")) {
            String newPIN= command.substring(10);
            atm.changePIN(newPIN);
            display.setText("PIN changed successfully.\n");

        }else if(command.startsWith("HISTORY")){
            ArrayList<String> history= atm.getTransactionHistory();
            display.setText("Transaction History:\n");
            for(String record: history){
                display.append(record + "\n");
            }
        }else{
            display.setText("Unknown command.\n");
        }
    }
//creation of main function linking with ATM and Account class
    public static void main(String[] args) {
        Account account= new Account("1234", 50000);
        ATM atm=new ATM(account);
        new ATMGUI(atm);
    }
}
