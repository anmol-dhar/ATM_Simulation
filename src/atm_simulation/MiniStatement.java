package atm_simulation;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame {
    MiniStatement(String pinNumber){
        setLayout(null);

        setTitle("Mini Statement");

        JLabel miniStatement = new JLabel();
        miniStatement.setBounds(20, 140, 400, 200);
        add(miniStatement);

        JLabel bankName = new JLabel("Indian Fusion Bank");
        bankName.setBounds(130, 20, 200, 20);
        add(bankName);

        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20, 400, 300, 20);
        add(balance);

        try {
            DatabaseConnection c = new DatabaseConnection();
            ResultSet rs = c.s.executeQuery("select * from login where Pin = '"+pinNumber+"'");
            while(rs.next()){
                card.setText("Card Number: " + rs.getString("Card_Number").substring(0, 4) + "XXXXXXXX" + rs.getString("Card_Number").substring(12));
            }
        }
        catch (Exception ex){
            System.out.println("An error occurred: " + ex);
        }

        try {
            DatabaseConnection c = new DatabaseConnection();
            ResultSet rs = c.s.executeQuery("SELECT * FROM (SELECT * FROM bank WHERE Pin = '" + pinNumber + "' ORDER BY date DESC LIMIT 6) AS subquery ORDER BY date ASC");
            while (rs.next()){
                miniStatement.setText(miniStatement.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
            }

            int bal = 0;
            ResultSet rs2 = c.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
            while (rs2.next()){
                if(rs2.getString("type").equals("Credit")){
                    bal += Integer.parseInt(rs2.getString("amount"));
                }
                else{
                    bal -= Integer.parseInt(rs2.getString("amount"));
                }
            }
            balance.setText("Total Balance: Rs " + bal);
        }
        catch (Exception e){
            System.out.println("An error occurred: " + e);
        }

        setSize(400, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }
    public static void main(String[] args) {
        new MiniStatement("");
    }
}
