package bank.management.system;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;
import com.toedter.calendar.JDateChooser;



public class SignupOne extends JFrame implements ActionListener {
    JLabel formno,personDetails, name,dob,gender,email,maritalStetus,adress,city,state,pincode;

    JTextField fnameTextField,dobTExtField,emailTextField,adressTextField,cityTextField,stateTextField,pinTextField;

    JDateChooser dateChooser;
    
    JRadioButton male,female,marreid,unmarried,other;
    JButton next;


    String no = ""+(int)(1000 + 9000*Math.random());

    SignupOne(){
    
        setLayout(null);

        


        formno = new JLabel("APPLICATION FORM NO. "+no);
        formno.setBounds(175,50,450,40);
        formno.setFont(new Font("Time New Roman",Font.BOLD,28));
        add(formno);




        personDetails = new JLabel("Page 1: Person Details");
        personDetails.setBounds(275,90,500,40);
        personDetails.setFont(new Font("Time New Roman",Font.BOLD,18));
        add(personDetails);





        name = new JLabel("Full Name:");
        name.setBounds(175,150,100,20);
        name.setFont(new Font("Time New Roman",Font.BOLD,18));
        add(name);

        fnameTextField = new JTextField(); 
        fnameTextField.setBounds(335,145,400,30);
        fnameTextField.setFont(new Font("Arial",Font.BOLD,15));
        add(fnameTextField);


    




        dob = new JLabel("Date of Birth:");
        dob.setBounds(175,190,140,20);
        dob.setFont(new Font("Time New Roman",Font.BOLD,18));
        add(dob);


        dateChooser = new JDateChooser();
        dateChooser.setBounds(335,185,400,30);
        dateChooser.setFont(new Font("Time New Roman",Font.BOLD,18));
        add(dateChooser);




        gender = new JLabel("Gender");
        gender.setBounds(175,230,100,20);
        gender.setFont(new Font("Time New Roman",Font.BOLD,18));
        add(gender);

        male = new JRadioButton("Male"); 
        male.setBounds(335,225,200,30);
        male.setFont(new Font("Arial",Font.BOLD,15));
        add(male);

        female = new JRadioButton("Female"); 
        female.setBounds(535,225,200,30);
        female.setFont(new Font("Arial",Font.BOLD,15));
        add(female);

        ButtonGroup gendeGroup = new ButtonGroup();
        gendeGroup.add(female);
        gendeGroup.add(male);

        email = new JLabel("Email:");
        email.setBounds(175,270,100,20);
        email.setFont(new Font("Time New Roman",Font.BOLD,18));
        add(email);

        emailTextField = new JTextField(); 
        emailTextField.setBounds(335,255,400,30);
        emailTextField.setFont(new Font("Arial",Font.BOLD,15));
        add(emailTextField);





        maritalStetus = new JLabel("Marital Stetus:");
        maritalStetus.setBounds(175,310,200,30);
        maritalStetus.setFont(new Font("Time New Roman",Font.BOLD,18));
        add(maritalStetus);



        marreid = new JRadioButton("Married");
        marreid.setBounds(335,310,100,30);
        marreid.setFont(new Font("Time New Roman",Font.BOLD,15));
        add(marreid);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(440,310,150,30);
        unmarried.setFont(new Font("Time New Roman",Font.BOLD,15));
        add(unmarried);

        other = new JRadioButton("Other");
        other.setBounds(560,310,100,30);
        other.setFont(new Font("Time New Roman",Font.BOLD,15));
        add(other);

        ButtonGroup mGroup = new ButtonGroup();
        mGroup.add(marreid);
        mGroup.add(other);
        mGroup.add(unmarried);






        adress = new JLabel("Address:");
        adress.setBounds(175,350,100,20);
        adress.setFont(new Font("Time New Roman",Font.BOLD,18));
        add(adress);
        
        adressTextField = new JTextField(); 
        adressTextField.setBounds(335,335,400,30);
        adressTextField.setFont(new Font("Arial",Font.BOLD,15));
        add(adressTextField);






        city = new JLabel("City:");
        city.setBounds(175,390,100,20);
        city.setFont(new Font("Time New Roman",Font.BOLD,18));
        add(city);

        cityTextField = new JTextField(); 
        cityTextField.setBounds(335,385,400,30);
        cityTextField.setFont(new Font("Arial",Font.BOLD,15));
        add(cityTextField);





        state = new JLabel("State:");
        state.setBounds(175,430,100,20);
        state.setFont(new Font("Time New Roman",Font.BOLD,18));
        add(state);

        stateTextField = new JTextField(); 
        stateTextField.setBounds(335,435,400,30);
        stateTextField.setFont(new Font("Arial",Font.BOLD,15));
        add(stateTextField);






        pincode = new JLabel("Pin Code:");
        pincode.setBounds(175,470,100,20);
        pincode.setFont(new Font("Time New Roman",Font.BOLD,18));
        add(pincode);

        pinTextField = new JTextField(); 
        pinTextField.setBounds(335,465,400,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,15));
        add(pinTextField);



        next = new JButton("Next >");
        next.setBounds(475,530,200,40);
        next.setFont(new Font("Raleway",Font.BOLD,18));
        next.setBackground(Color.BLACK);next.setForeground(Color.red);
        add(next);
        next.addActionListener(this);

        setSize(800,850);
        setLocation(300,0);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
     

        String formNo = no;
        String fullname = fnameTextField.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        
        if (male.isSelected()) {
            gender = "Male";
        }else if (female.isSelected()) {
            gender = "Female";
        }
        String email = emailTextField.getText();
        String marital = null;
        if (marreid.isSelected()) {
            marital = "Married";
        }else if (unmarried.isSelected()) {
            marital = "Unmarried";
        }else if (other.isSelected()) {
            marital = "Other";
        }

        String adress = adressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pincode = pinTextField.getText();

        try {
            if (fullname.equals("")) {
                JOptionPane.showMessageDialog(null, "Name Is Requierd");
            }
            else if (dob.equals("")) {
                JOptionPane.showMessageDialog(null, "Date Of Birth Is Requierd");
            }else if (gender.equals(null)) {
                JOptionPane.showMessageDialog(null, "Gender Is Requierd");
            }else if (email.equals("")) {
                JOptionPane.showMessageDialog(null, "Email Is Requierd");
            }else if (marital.equals(null)) {
                JOptionPane.showMessageDialog(null, "Marital Status Is Requierd");
            }else if (city.equals("")) {
                JOptionPane.showMessageDialog(null, "City Is Requierd");
            }else if (adress.equals("")) {
                JOptionPane.showMessageDialog(null, "Adress Is Requierd");
            }else if (state.equals("")) {
                JOptionPane.showMessageDialog(null, "State Is Requierd");
            }else if (pincode.equals("")) {
                JOptionPane.showMessageDialog(null, "Pincode Is Requierd");
            }else{
                Conn c = new Conn();
                String query = "insert into signup values('"+no+"','"+fullname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+city+"','"+adress+"','"+state+"','"+pincode+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                SignupTwo x = new SignupTwo(no);
                x.setVisible(true);
                
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }
    public static void main(String[] args) {
        new SignupOne();
    }
}
