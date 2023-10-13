package atm_interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Transactions extends JFrame implements ActionListener {

    JButton cashDeposit, cashWithdrawal, fastCash, miniStatement, pinChange, balanceEnquiry, exit;
    String pinNumber;

    Transactions(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Atm Interface.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(220, 300, 700, 35);
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        cashDeposit = new JButton("Deposit");
        cashDeposit.setBounds(170, 415, 150, 30);
        cashDeposit.addActionListener(this);
        image.add(cashDeposit);

        cashWithdrawal = new JButton("Cash Withdrawal");
        cashWithdrawal.setBounds(355, 415, 150, 30);
        cashWithdrawal.addActionListener(this);
        image.add(cashWithdrawal);

        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(170, 450, 150, 30);
        fastCash.addActionListener(this);
        image.add(fastCash);

        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(355, 450, 150, 30);
        miniStatement.addActionListener(this);
        image.add(miniStatement);

        pinChange = new JButton("Pin Change");
        pinChange.setBounds(170, 485, 150, 30);
        pinChange.addActionListener(this);
        image.add(pinChange);

        balanceEnquiry = new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(355, 485, 150, 30);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);

        exit = new JButton("Exit");
        exit.setBounds(355, 520, 150, 30);
        exit.addActionListener(this);
        image.add(exit);

        getContentPane().setBackground(Color.white);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == cashDeposit){

        }
        else if(e.getSource() == cashWithdrawal){

        }
        else if(e.getSource() == fastCash){

        }
        else if(e.getSource() == miniStatement){

        }
        else if(e.getSource() == pinChange){

        }
        else if(e.getSource() == balanceEnquiry){

        }
        else if(e.getSource() == exit){
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Transactions("");
    }
}
