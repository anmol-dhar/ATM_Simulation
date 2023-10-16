package atm_interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener {

    JRadioButton savingsA, currentA, salaryA, fdA;
    JCheckBox atmC, internetC, mobileC, emailC, chequeC, eStatementC, iAgreeC;
    String FormNo;
    JButton submit, cancel;

    SignupThree(String formNo){
        this.FormNo = formNo;
        setLayout(null);

        setTitle("New Account Application - Page 3");

        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(290, 65, 400, 30);
        add(l1);

        JLabel type = new JLabel("Account Type:");
        type.setFont(new Font("Raleway", Font.BOLD, 20));
        type.setBounds(150, 140, 200, 30);
        add(type);

        savingsA = new JRadioButton("Savings Account");
        savingsA.setBackground(Color.white);
        savingsA.setBounds(170, 180, 200, 30);
        savingsA.setFont(new Font("Raleway", Font.BOLD, 18));
        add(savingsA);

        currentA = new JRadioButton("Current Account");
        currentA.setBounds(400, 180, 200, 30);
        currentA.setBackground(Color.white);
        currentA.setFont(new Font("Raleway", Font.BOLD, 18));
        add(currentA);

        salaryA = new JRadioButton("Salary Account");
        salaryA.setBounds(170, 220, 200, 30);
        salaryA.setBackground(Color.white);
        salaryA.setFont(new Font("Raleway", Font.BOLD, 18));
        add(salaryA);

        fdA = new JRadioButton("FD Account");
        fdA.setBounds(400, 220, 200, 30);
        fdA.setBackground(Color.white);
        fdA.setFont(new Font("Raleway", Font.BOLD, 18));
        add(fdA);

        ButtonGroup accountType = new ButtonGroup();
        accountType.add(savingsA);
        accountType.add(currentA);
        accountType.add(salaryA);
        accountType.add(fdA);

        JLabel cardNo = new JLabel("Card Number:");
        cardNo.setBounds(150, 290, 200, 30);
        cardNo.setFont(new Font("Raleway", Font.BOLD, 20));
        add(cardNo);

        JLabel cardNoInfo = new JLabel("(This is your 16 digit card number)");
        cardNoInfo.setBounds(150, 320, 200, 20);
        cardNoInfo.setFont(new Font("Raleway", Font.BOLD, 12));
        add(cardNoInfo);

        JLabel dummyCard = new JLabel("XXXX-XXXX-XXXX-5182");
        dummyCard.setBounds(400, 290, 300, 30);
        dummyCard.setFont(new Font("Raleway", Font.BOLD, 18));
        add(dummyCard);

        JLabel pinNo = new JLabel("Pin Number:");
        pinNo.setBounds(150, 360, 200, 30);
        pinNo.setFont(new Font("Raleway", Font.BOLD, 20));
        add(pinNo);

        JLabel pinNoInfo = new JLabel("(This is your 4 digit PIN)");
        pinNoInfo.setBounds(150, 390, 200, 20);
        pinNoInfo.setFont(new Font("Raleway", Font.BOLD, 12));
        add(pinNoInfo);

        JLabel dummyPin = new JLabel("XXXX");
        dummyPin.setBounds(400, 360, 200, 30);
        dummyPin.setFont(new Font("Raleway", Font.BOLD, 18));
        add(dummyPin);

        JLabel services = new JLabel("Services Required:");
        services.setBounds(150, 450, 250, 30);
        services.setFont(new Font("Raleway", Font.BOLD, 20));
        add(services);

        atmC = new JCheckBox("Atm Card");
        atmC.setBackground(Color.white);
        atmC.setFont(new Font("Raleway", Font.BOLD, 18));
        atmC.setBounds(170, 490, 200, 30);
        add(atmC);

        internetC = new JCheckBox("Internet Banking");
        internetC.setBackground(Color.white);
        internetC.setFont(new Font("Raleway", Font.BOLD, 18));
        internetC.setBounds(400, 490, 200, 30);
        add(internetC);

        mobileC = new JCheckBox("Mobile Banking");
        mobileC.setBackground(Color.white);
        mobileC.setFont(new Font("Raleway", Font.BOLD, 18));
        mobileC.setBounds(170, 530, 200, 30);
        add(mobileC);

        emailC = new JCheckBox("Email & SMS Alerts");
        emailC.setBackground(Color.white);
        emailC.setFont(new Font("Raleway", Font.BOLD, 18));
        emailC.setBounds(400, 530, 200, 30);
        add(emailC);

        chequeC = new JCheckBox("Cheque Book");
        chequeC.setBackground(Color.white);
        chequeC.setFont(new Font("Raleway", Font.BOLD, 18));
        chequeC.setBounds(170, 570, 200, 30);
        add(chequeC);

        eStatementC = new JCheckBox("E-Statement");
        eStatementC.setBackground(Color.white);
        eStatementC.setFont(new Font("Raleway", Font.BOLD, 18));
        eStatementC.setBounds(400, 570, 200, 30);
        add(eStatementC);

        iAgreeC = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge.");
        iAgreeC.setBackground(Color.white);
        iAgreeC.setFont(new Font("Raleway", Font.BOLD, 12));
        iAgreeC.setBounds(130, 640, 700, 30);
        add(iAgreeC);

        submit = new JButton("Submit");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(230, 690, 100, 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(480, 690, 100, 30);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit){
            String accountType = "null";
            if(savingsA.isSelected()){
                accountType = "Savings account";
            }
            else if(currentA.isSelected()){
                accountType = "Current Account";
            }
            else if(salaryA.isSelected()){
                accountType = "Salary Account";
            }
            else if(fdA.isSelected()){
                accountType = "Fixed Deposit";
            }

            Random random = new Random();
            String cardNumber = String.format("%016d", Math.abs(random.nextLong() % 100000000L) + 5436012100000000L);
            String pinNumber = String.format("%04d", Math.abs((random.nextLong() % 9000L)) + 1000L);

            String services = "";
            String agree = "null";
            if(atmC.isSelected()){
                services = "Atm Card, ";
            }
            if(internetC.isSelected()){
                services = services + "Internet Banking, ";
            }
            if(mobileC.isSelected()){
                services = services + "Mobile Banking, ";
            }
            if(emailC.isSelected()){
                services = services + "Email and SMS Alerts, ";
            }
            if(chequeC.isSelected()){
                services = services + "Cheque Book, ";
            }
            if(eStatementC.isSelected()){
                services = services + "E-Statement ";
            }
            if(iAgreeC.isSelected()){
                agree = "true";
            }
            try {
                if(accountType.equals("null") || services.equals("") || agree.equals("null")){
                    JOptionPane.showMessageDialog(null, "Please select the required fields");
                }
                else{
                    DatabaseConnection c = new DatabaseConnection();

                    String query1 = "insert into signupThree values ('"+FormNo+"', '"+accountType+"', '"+cardNumber+"', '"+pinNumber+"','"+services+"')";
                    String query2 = "insert into login values ('"+FormNo+"', '"+cardNumber+"', '"+pinNumber+"')";

                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null, "Card Number: " + cardNumber + "\nPin: "+ pinNumber);

                    setVisible(false);
                    new Deposit(pinNumber).setVisible(true);
                }
            }
            catch (Exception ex){
                System.out.println("An error occurred: " + ex);
            }

        }
        else if(e.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new SignupThree("");
    }
}
