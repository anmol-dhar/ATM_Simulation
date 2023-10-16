package atm_interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    JButton depositButton, backButton;
    JTextField amountDeposit;
    String pinNumber;
    Deposit(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Atm Interface.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to deposit");
        text.setBounds(170, 300, 400, 20);
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        amountDeposit = new JTextField();
        amountDeposit.setFont(new Font("Raleway", Font.BOLD, 22));
        amountDeposit.setBounds(170, 350, 320, 25);
        image.add(amountDeposit);

        depositButton = new JButton("Deposit");
        depositButton.setBounds(355, 485, 150, 30);
        depositButton.addActionListener(this);
        image.add(depositButton);

        backButton = new JButton("Back");
        backButton.setBounds(355, 520, 150, 30);
        backButton.addActionListener(this);
        image.add(backButton);


        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == depositButton){
            String amount = amountDeposit.getText();
            Date date = new Date();
            if(amount.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
            }
            else{
                try {
                    DatabaseConnection c = new DatabaseConnection();
                    String query = "insert into bank values('"+pinNumber+"', '"+date+"', 'Credit', '"+amount+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs "+amount+" deposited successfully");
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }
                catch (Exception ex) {
                    System.out.println("An error occurred: " + ex);
                }
            }
        }
        else if(e.getSource() == backButton){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Deposit("");
    }
}
