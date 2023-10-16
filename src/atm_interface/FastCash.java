package atm_interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.ResultSet;

public class FastCash extends JFrame implements ActionListener {

    JButton withdraw100, withdraw500, withdraw1000, withdraw2000, withdraw5000, withdraw10000, exit;
    String pinNumber;

    FastCash(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Atm Interface.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Select withdrawal amount");
        text.setBounds(220, 300, 700, 35);
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        withdraw100 = new JButton("Rs 100");
        withdraw100.setBounds(170, 415, 150, 30);
        withdraw100.addActionListener(this);
        image.add(withdraw100);

        withdraw500 = new JButton("Rs 500");
        withdraw500.setBounds(355, 415, 150, 30);
        withdraw500.addActionListener(this);
        image.add(withdraw500);

        withdraw1000 = new JButton("Rs 1000");
        withdraw1000.setBounds(170, 450, 150, 30);
        withdraw1000.addActionListener(this);
        image.add(withdraw1000);

        withdraw2000 = new JButton("Rs 2000");
        withdraw2000.setBounds(355, 450, 150, 30);
        withdraw2000.addActionListener(this);
        image.add(withdraw2000);

        withdraw5000 = new JButton("Rs 5000");
        withdraw5000.setBounds(170, 485, 150, 30);
        withdraw5000.addActionListener(this);
        image.add(withdraw5000);

        withdraw10000 = new JButton("Rs 10000");
        withdraw10000.setBounds(355, 485, 150, 30);
        withdraw10000.addActionListener(this);
        image.add(withdraw10000);

        exit = new JButton("Back");
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
        if(e.getSource() == exit) {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
        else{
            String amount = ((JButton) e.getSource()).getText().substring(3);
            DatabaseConnection c = new DatabaseConnection();
            try {
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Credit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }
                    else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(e.getSource() != exit && balance <Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                Date date = new Date();
                String query = "insert into bank values('"+pinNumber+"', '"+date+"', 'Debit', '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+amount+" debited successfully");

                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
            }
            catch (Exception ex){
                System.out.println("An error occurred: " + ex);
            }
        }
    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
