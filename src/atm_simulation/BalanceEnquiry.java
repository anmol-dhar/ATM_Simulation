package atm_simulation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
    JButton back;
    String pinNumber;
    BalanceEnquiry(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Atm Interface.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        int balance = 0;
        try {
            DatabaseConnection c = new DatabaseConnection();
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
            while(rs.next()){
                if(rs.getString("type").equals("Credit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }
                else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }
        catch (Exception ex){
            System.out.println("An error occurred: " + ex);
        }

        JLabel text = new JLabel("Your Current Account Balance is Rs " + balance);
        text.setBounds(170, 300, 400, 30);
        text.setForeground(Color.white);
        image.add(text);


        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Transactions(pinNumber).setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
