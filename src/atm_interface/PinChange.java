package atm_interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class PinChange extends JFrame implements ActionListener {
    JPasswordField newPin, confirmPin;
    JButton change, back;
    String pinNumber;

    PinChange(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Atm Interface.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(250, 280, 500, 35);
        image.add(text);

        JLabel newPinText = new JLabel("New Pin:");
        newPinText.setForeground(Color.white);
        newPinText.setFont(new Font("System", Font.BOLD, 16));
        newPinText.setBounds(165, 320, 180, 25);
        image.add(newPinText);

        newPin = new JPasswordField();
        newPin.setFont(new Font("Raleway", Font.BOLD, 25));
        newPin.setBounds(330, 320, 180, 25);
        image.add(newPin);

        JLabel confirmPinText = new JLabel("Re-Enter New Pin:");
        confirmPinText.setForeground(Color.white);
        confirmPinText.setFont(new Font("System", Font.BOLD, 16));
        confirmPinText.setBounds(165, 360, 180, 25);
        image.add(confirmPinText);

        confirmPin = new JPasswordField();
        confirmPin.setFont(new Font("Raleway", Font.BOLD, 25));
        confirmPin.setBounds(330, 360, 180, 25);
        image.add(confirmPin);

        change = new JButton("Change");
        change.setBounds(355, 485, 150, 30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == change){
            try {
                String pin = newPin.getText();
                String rePin = confirmPin.getText();

                if(!pin.equals(rePin)){
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }
                if(pin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the PIN");
                    return;
                }
                if(rePin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Re-PIN");
                    return;
                }

                DatabaseConnection c = new DatabaseConnection();
                String query1 = "update bank set Pin ='"+rePin+"' where Pin = '"+pinNumber+"'";
                String query2 = "update login set Pin ='"+rePin+"' where Pin = '"+pinNumber+"'";
                String query3 = "update signupThree set Pin ='"+rePin+"' where Pin = '"+pinNumber+"'";

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transactions(rePin).setVisible(true);
            }
            catch (Exception ex){
                System.out.println("An error occurred: " + ex);
            }
        }
        else if(e.getSource() == back){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }

    }

    public static void main(String[] args) {
        new PinChange("");
    }
}
