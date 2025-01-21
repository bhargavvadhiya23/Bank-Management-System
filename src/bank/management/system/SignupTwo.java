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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;



public class SignupTwo extends JFrame implements ActionListener {
    JLabel additionalDetails, religion,category,income,education,qualifiaction,occupation,pan,adhar,scitizen,existingAccount;

    JTextField educationTextField,occupationTextField,panTextField,adharTextField;

    JComboBox religionComboBox,categoryComboBox,incomeComboobx,educationComboBox,occupationComboBox;
    
    JRadioButton yes,no,y1,n1;
    JButton next;
    String number;

    SignupTwo(String form){

        number = form;
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
    


        additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setBounds(275,90,500,40);
        additionalDetails.setFont(new Font("Time New Roman",Font.BOLD,18));
        add(additionalDetails);





        religion = new JLabel("Religion:");
        religion.setBounds(150,150,180,20);
        religion.setFont(new Font("Time New Roman",Font.BOLD,18));
        add(religion);

        String lreligion[] = {"select","Hindu","Sikh","Muslim","Jain","Cristion","Parsi","Other"};
        religionComboBox = new JComboBox(lreligion); 
        religionComboBox.setBounds(335,145,400,30);
        religionComboBox.setFont(new Font("Arial",Font.BOLD,15));
        add(religionComboBox);


    




        category = new JLabel("Category:");
        category.setBounds(150,190,140,20);
        category.setFont(new Font("Time New Roman",Font.BOLD,18));
        add(category);


        String lcategory[] = {"select","GENERAL","OBC","SC","ST","OTHER"};
        categoryComboBox = new JComboBox(lcategory); 
        categoryComboBox.setBounds(335,185,400,30);
        categoryComboBox.setFont(new Font("Arial",Font.BOLD,15));
        add(categoryComboBox);


    




        income = new JLabel("Income");
        income.setBounds(150,230,180,20);
        income.setFont(new Font("Time New Roman",Font.BOLD,18));
        add(income);


        String lincome[] = {"select","<150000","<500000","<1000000","<1500000",">1500000"};
        incomeComboobx = new JComboBox(lincome); 
        incomeComboobx.setBounds(335,230,400,30);
        incomeComboobx.setFont(new Font("Arial",Font.BOLD,15));
        add(incomeComboobx);


        // male = new JRadioButton("Male"); 
        // male.setBounds(335,225,200,30);
        // male.setFont(new Font("Arial",Font.BOLD,15));
        // add(male);

        // female = new JRadioButton("Female"); 
        // female.setBounds(535,225,200,30);
        // female.setFont(new Font("Arial",Font.BOLD,15));
        // add(female);

        // ButtonGroup gendeGroup = new ButtonGroup();
        // gendeGroup.add(female);
        // gendeGroup.add(male);

        education = new JLabel("Education:");
        education.setBounds(150,270,180,20);
        education.setFont(new Font("Time New Roman",Font.BOLD,18));
        add(education);

        String leducation[] = {"select","Non-Graduate","Graduate","Post-Graduate","Doctrate","Other"};
        educationComboBox = new JComboBox(leducation); 
        educationComboBox.setBounds(335,265,400,30);
        educationComboBox.setFont(new Font("Arial",Font.BOLD,15));
        add(educationComboBox);

        // marreid = new JRadioButton("Married");
        // marreid.setBounds(335,310,180,30);
        // marreid.setFont(new Font("Time New Roman",Font.BOLD,15));
        // add(marreid);
        
        // unmarried = new JRadioButton("Unmarried");
        // unmarried.setBounds(440,310,150,30);
        // unmarried.setFont(new Font("Time New Roman",Font.BOLD,15));
        // add(unmarried);

        // other = new JRadioButton("Other");
        // other.setBounds(560,310,180,30);
        // other.setFont(new Font("Time New Roman",Font.BOLD,15));
        // add(other);

        // ButtonGroup mGroup = new ButtonGroup();
        // mGroup.add(marreid);
        // mGroup.add(other);
        // mGroup.add(unmarried);






        occupation = new JLabel("Occupation:");
        occupation.setBounds(150,350,180,20);
        occupation.setFont(new Font("Time New Roman",Font.BOLD,18));
        add(occupation);

        String loccupation[] = {"select","Self-Employe","Salaried","Bussiness-Man","Student","Retiered","Others"};
        occupationComboBox = new JComboBox(loccupation); 
        occupationComboBox.setBounds(335,350,400,30);
        occupationComboBox.setFont(new Font("Arial",Font.BOLD,15));
        add(occupationComboBox);







        pan = new JLabel("PAN Number:");
        pan.setBounds(150,390,180,20);
        pan.setFont(new Font("Time New Roman",Font.BOLD,18));
        add(pan);

        panTextField = new JTextField(); 
        panTextField.setBounds(335,385,400,30);
        panTextField.setFont(new Font("Arial",Font.BOLD,15));
        add(panTextField);





        adhar = new JLabel("Aadhar Number:");
        adhar.setBounds(150,430,180,20);
        adhar.setFont(new Font("Time New Roman",Font.BOLD,18));
        add(adhar);

        adharTextField = new JTextField(); 
        adharTextField.setBounds(335,435,400,30);
        adharTextField.setFont(new Font("Arial",Font.BOLD,15));
        add(adharTextField);






        scitizen = new JLabel("Senior Citizen:");
        scitizen.setBounds(150,470,180,20);
        scitizen.setFont(new Font("Time New Roman",Font.BOLD,18));
        add(scitizen);

        yes = new JRadioButton("Yes"); 
        yes.setBounds(335,465,200,30);
        yes.setFont(new Font("Arial",Font.BOLD,15));
        add(yes);

        no = new JRadioButton("No"); 
        no.setBounds(535,465,200,30);
        no.setFont(new Font("Arial",Font.BOLD,15));
        add(no);



        ButtonGroup z = new ButtonGroup();
        z.add(no);
        z.add(yes);


        existingAccount = new JLabel("Existing Account:");
        existingAccount.setBounds(150,510,200,20);
        existingAccount.setFont(new Font("Time New Roman",Font.BOLD,18));
        add(existingAccount);


        y1 = new JRadioButton("Yes"); 
        y1.setBounds(335,510,200,30);
        y1.setFont(new Font("Arial",Font.BOLD,15));
        add(y1);


        n1 = new JRadioButton("No"); 
        n1.setBounds(535,510,200,30);
        n1.setFont(new Font("Arial",Font.BOLD,15));
        add(n1);

        
       ButtonGroup x = new ButtonGroup();
       x.add(n1);
       x.add(y1);



        next = new JButton("Next >");
        next.setBounds(530,550,200,40);
        next.setFont(new Font("Raleway",Font.BOLD,18));
        next.setBackground(Color.BLACK);next.setForeground(Color.red);
        add(next);
        next.addActionListener(this);

        setSize(800,850);
        setLocation(300,0);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
     

    
        
        // String income = null;
     
        // String education = educationTextField.getText();
        // String marital = null;
       

        // String occupation = occupationTextField.getText();
        // String pan = panTextField.getText();
        // String adhar = adharTextField.getText();
        // String scitizen = yes.getText();

        String Religion = religionComboBox.getSelectedItem().toString();
        String category = categoryComboBox.getSelectedItem().toString();
        String income =  incomeComboobx.getSelectedItem().toString();
        String education = educationComboBox.getSelectedItem().toString();
        String occupation = occupationComboBox.getSelectedItem().toString();
        String pan = panTextField.getText();
        String adhar = adharTextField.getText();
        String scitizen = null;
        String existingAccount = null;

        if (yes.isSelected()) {
            scitizen = "yes";
        }else if(no.isSelected()){
            scitizen ="no";
        }


        if (y1.isSelected()) {
            existingAccount = "yes";
        }else if(n1.isSelected()){
            existingAccount ="no";
        }

        try {
            if (Religion.equals("select")) {
                JOptionPane.showMessageDialog(null, "Select Religion ");
            }else if(category.equals("select")){
                JOptionPane.showMessageDialog(null, "Select Category ");
            }else if(income.equals("select")){
                JOptionPane.showMessageDialog(null, "Select Income ");
            }else if(education.equals("select")){
                JOptionPane.showMessageDialog(null, "Select Education ");
            }else if(occupation.equals("select")){
                JOptionPane.showMessageDialog(null, "Select Occupation ");
            }
          else{
                Conn c = new Conn();
                String query = "insert into signup2 values('"+number+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+pan+"','"+adhar+"','"+scitizen+"','"+existingAccount+"')";
                c.s.executeUpdate(query);

                setVisible(false);
               SignupThree x = new SignupThree(number);
               x.setVisible(true);
                
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }
    public static void main(String[] args) {
        new SignupTwo("");
    }
}
