package atm_interface;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame{
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
        JLabel text = new JLabel("Welcome to the ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200, 40, 400, 40);
        add(text);

        // card no text label
        JLabel cardno = new JLabel("Card No.:");
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        cardno.setBounds(120, 150, 250, 30);
        add(cardno);

        // card no text field
        JTextField cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 250, 30);
        add(cardTextField);

        // pin text label
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(120, 220, 250, 30);
        add(pin);

        // pin text field
        JTextField pinTextField = new JTextField();
        pinTextField.setBounds(300, 220, 250, 30);
        add(pinTextField);

        // Login button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(300, 300, 100, 30);
        loginButton.setBackground(Color.BLACK);
        loginButton.setForeground(Color.WHITE);
        add(loginButton);

        // Frame attributes
        setSize(800, 480);
        setLocation(350, 200);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Login();
    }
}
