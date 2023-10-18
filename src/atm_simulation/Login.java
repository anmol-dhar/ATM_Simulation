package atm_simulation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{

    JButton loginButton, signupButton, clearButton;
    JTextField cardTextField;
    JPasswordField pinTextField;

    Login(){
        // Title
        setTitle("ATM Machine");

        setLayout(null);

        // Background color -> white
        getContentPane().setBackground(Color.WHITE);

        // Adding logo in the login page
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/ATM logo.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);

        // Welcome text label
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200, 40, 400, 40);
        add(text);

        // card no text label
        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        cardno.setBounds(120, 150, 250, 30);
        add(cardno);

        // card no text field
        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 230, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);

        // pin text label
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(120, 220, 250, 30);
        add(pin);

        // pin text field
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220, 230, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);

        // Login button
        loginButton = new JButton("LOGIN");
        loginButton.setBounds(300, 300, 100, 30);
        loginButton.setBackground(Color.BLACK);
        loginButton.setForeground(Color.WHITE);
        loginButton.addActionListener(this);
        add(loginButton);

        // Clear button
        clearButton = new JButton("CLEAR");
        clearButton.setBounds(430, 300, 100, 30);
        clearButton.setBackground(Color.BLACK);
        clearButton.setForeground(Color.WHITE);
        clearButton.addActionListener(this);
        add(clearButton);

        // Signup button
        signupButton = new JButton("SIGN UP");
        signupButton.setBounds(300, 350, 230, 30);
        signupButton.setBackground(Color.BLACK);
        signupButton.setForeground(Color.WHITE);
        signupButton.addActionListener(this);
        add(signupButton);

        // Frame attributes
        setSize(800, 480);
        setLocation(350, 200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed (ActionEvent e){
        if(e.getSource() == loginButton){
            DatabaseConnection c = new DatabaseConnection();
            String cardNumber = cardTextField.getText();
            String pinNumber = pinTextField.getText();
            String query = "select * from login where Card_Number = '"+cardNumber+"' and Pin = '"+pinNumber+"'";
            try {
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                }
            }
            catch (Exception Ex){
                System.out.println("An error occurred: " + Ex);
            }
        }
        else if(e.getSource() == clearButton){
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if(e.getSource() == signupButton){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Login();
    }
}
