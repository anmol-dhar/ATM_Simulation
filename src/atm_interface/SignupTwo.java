package atm_interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {

    JTextField panTextField, aadhaarTextField;
    JRadioButton SYes, SNo, EYes, ENo;
    JComboBox religionDrop, categoryDrop, salaryDrop, educationDrop, occupationDrop;
    JButton next;
    String FormNo;

    SignupTwo(String formNo){
        this.FormNo = formNo;
        setLayout(null);

        setTitle("New Account Application and Form - Page 2");

        JLabel personalDetails = new JLabel("Page 2: Additional Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDetails.setBounds(290, 80, 400, 30);
        add(personalDetails);

        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        religion.setBounds(100, 140, 200, 30);
        add(religion);

        String[] valReligion = {"Hindu", "Muslim", "Sikh", "Cristian", "Other"};
        religionDrop = new JComboBox(valReligion);
        religionDrop.setBounds(300, 140, 400, 30);
        religionDrop.setBackground(Color.white);
        add(religionDrop);

        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        category.setBounds(100, 190, 200, 30);
        add(category);

        String[] valCategory = {"General", "OBC", "SC", "ST", "Other"};
        categoryDrop = new JComboBox(valCategory);
        categoryDrop.setBounds(300, 190, 400, 30);
        categoryDrop.setBackground(Color.white);
        add(categoryDrop);

        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100, 240, 200, 30);
        add(income);

        String[] valsalary = {"null", "< 1,00,000", "< 2,00,000", "< 5,00,000", "Upto 1,00,000"};
        salaryDrop = new JComboBox(valsalary);
        salaryDrop.setFont(new Font("Raleway", Font.BOLD, 14));
        salaryDrop.setBounds(300, 240, 200, 30);
        salaryDrop.setBackground(Color.white);
        add(salaryDrop);

        JLabel educational = new JLabel("Educational");
        educational.setFont(new Font("Raleway", Font.BOLD, 20));
        educational.setBounds(100, 290, 200, 30);
        add(educational);

        JLabel qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway", Font.BOLD, 20));
        qualification.setBounds(100, 315, 200, 30);
        add(qualification);

        String[] valEducation = {"Non-Graduate", "Graduate", "Post-Graduation", "Doctrate", "Other"};
        educationDrop = new JComboBox(valEducation);
        educationDrop.setBounds(300, 315, 400, 30);
        educationDrop.setBackground(Color.white);
        add(educationDrop);

        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(100, 390, 200, 30);
        add(occupation);

        String[] valOccupation = {"Salaried", "Self-Employed", "Student", "Retired", "Other"};
        occupationDrop = new JComboBox(valOccupation);
        occupationDrop.setBounds(300, 390, 400, 30);
        occupationDrop.setBackground(Color.white);
        add(occupationDrop);

        JLabel pan = new JLabel("PAN Number:");
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(100, 440, 200, 30);
        add(pan);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        panTextField.setBounds(300, 440, 400, 30);
        add(panTextField);

        JLabel aadhaar = new JLabel("Aadhaar Number:");
        aadhaar.setFont(new Font("Raleway", Font.BOLD, 20));
        aadhaar.setBounds(100, 490, 200, 30);
        add(aadhaar);

        aadhaarTextField = new JTextField();
        aadhaarTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadhaarTextField.setBounds(300, 490, 400, 30);
        add(aadhaarTextField);

        JLabel senior = new JLabel("Senior Citizen:");
        senior.setFont(new Font("Raleway", Font.BOLD, 20));
        senior.setBounds(100, 540, 200, 30);
        add(senior);

        SYes = new JRadioButton("Yes");
        SYes.setBounds(300, 540, 100, 30);
        SYes.setBackground(Color.white);
        add(SYes);

        SNo = new JRadioButton("No");
        SNo.setBounds(400, 540, 100, 30);
        SNo.setBackground(Color.white);
        add(SNo);

        ButtonGroup sGroup = new ButtonGroup();
        sGroup.add(SYes);
        sGroup.add(SNo);

        JLabel country = new JLabel("Existing Account:");
        country.setFont(new Font("Raleway", Font.BOLD, 20));
        country.setBounds(100, 590, 200, 30);
        add(country);

        EYes = new JRadioButton("Yes");
        EYes.setBounds(300, 590, 100, 30);
        EYes.setBackground(Color.white);
        add(EYes);

        ENo = new JRadioButton("No");
        ENo.setBounds(400, 590, 100, 30);
        ENo.setBackground(Color.white);
        add(ENo);

        ButtonGroup eGroup = new ButtonGroup();
        eGroup.add(EYes);
        eGroup.add(ENo);

        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(600, 670, 100, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    public void actionPerformed(ActionEvent e){
        String Religion = (String) religionDrop.getSelectedItem();
        String Category = (String) categoryDrop.getSelectedItem();
        String Salary = (String) salaryDrop.getSelectedItem();
        String Education = (String) educationDrop.getSelectedItem();
        String Occupation = (String) occupationDrop.getSelectedItem();
        String Pan = panTextField.getText();
        String Aadhaar = aadhaarTextField.getText();

        String Senior = "null";
        if(SYes.isSelected()){
            Senior = "Yes";
        }
        else if (SNo.isSelected()) {
            Senior = "No";
        }

        String Existing = "null";
        if(EYes.isSelected()){
            Existing = "Yes";
        }
        else if(ENo.isSelected()){
            Existing = "No";
        }

        try{
            if(Religion == null || Category == null || Salary == null || Education == null || Occupation == null || Pan.isEmpty() || Aadhaar.isEmpty() || Senior.equals("null") || Existing.equals("null")){
                JOptionPane.showMessageDialog(null, "Please fill the required fields");
            }
            else{
                DatabaseConnection c = new DatabaseConnection();
                String query = "insert into signupTwo values ('"+FormNo+"', '"+Religion+"', '"+Category+"', '"+Salary+"','"+Education+"', '"+Occupation+"', '"+Pan+"', '"+Aadhaar+"', '"+Senior+"', '"+Existing+"')";
                c.s.executeUpdate(query);
            }
        }
        catch (Exception E){
            System.out.println("An error occurred: " + E);
        }

    }

    public static void main(String[] args) {
        new SignupTwo("");
    }
}
