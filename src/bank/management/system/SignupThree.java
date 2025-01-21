package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SignupThree extends JFrame implements ActionListener{
    JLabel l1,type,card,cardNumber,pin,services;
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit, cancel;
    JTextField pinTextField;
    String no;
    SignupThree(String form){
no = form;
        setLayout(null);

        l1 = new JLabel("Page 3: Account Details");
        l1.setBounds(300,50,300,40);
        l1.setFont(new Font("Raleway",Font.BOLD,20));
        add(l1);


        type = new JLabel("Account Type:");
        type.setBounds(100,100,300,40);
        type.setFont(new Font("Raleway",Font.ROMAN_BASELINE,18));
        add(type);



        r1 = new JRadioButton("Saving Account");
        r1.setBounds(300, 100, 200, 20);
        r1.setFont(new Font("Arial", Font.PLAIN, 15));
        add(r1);

        r2 = new JRadioButton("Current Account");
        r2.setBounds(500, 100, 200, 20);
        r2.setFont(new Font("Arial", Font.PLAIN, 15));
        add(r2);
        r3 = new JRadioButton("FD Account");
        r3.setBounds(300, 130, 200, 20);
        r3.setFont(new Font("Arial", Font.PLAIN, 15));
        add(r3);
        r4 = new JRadioButton("RD Account");
        r4.setBounds(500, 130, 200, 20);
        r4.setFont(new Font("Arial", Font.PLAIN, 15));
        add(r4);

        ButtonGroup x = new ButtonGroup();
        x.add(r1);
        x.add(r2);
        x.add(r3);
        x.add(r4);



        card = new JLabel("Card Number:");
        card.setBounds(100,200,200,40);
        card.setFont(new Font("Raleway",Font.ROMAN_BASELINE,18));
        add(card);

        cardNumber = new JLabel("XXXX-XXXX-XXXX-1234");
        cardNumber.setBounds(300,200,300,40);
        cardNumber.setFont(new Font("Raleway",Font.ROMAN_BASELINE,18));
        add(cardNumber);

        pin = new JLabel("Pin:");
        pin.setBounds(100,250,200,40);
        pin.setFont(new Font("Raleway",Font.ROMAN_BASELINE,18));
        add(pin);

        pinTextField = new JTextField();
        pinTextField.setBounds(300,250,300,40);
        pinTextField.setFont(new Font("Raleway",Font.ROMAN_BASELINE,18));
        add(pinTextField);


        services = new JLabel("Services Requierd:");
        services.setBounds(100,320,200,40);
        services.setFont(new Font("Raleway",Font.BOLD,18));
        add(services);



        c1 = new JCheckBox("Debit Card");
        c1.setBounds(300,320,200,40);
        c1.setFont(new Font("Arial",Font.PLAIN,15));
        add(c1);

        c3 = new JCheckBox("Cheque Book");
        c3.setBounds(500,320,200,40);
        c3.setFont(new Font("Arial",Font.PLAIN,15));
        add(c3);

        c2 = new JCheckBox("Mobile Banking");
        c2.setBounds(300,360,200,40);
        c2.setFont(new Font("Arial",Font.PLAIN,15));
        add(c2);

        c4 = new JCheckBox("Email & SMS Alerts");
        c4.setBounds(300,400,200,40);
        c4.setFont(new Font("Arial",Font.PLAIN,15));
        add(c4);

        c5 = new JCheckBox("Internet Banking");
        c5.setBounds(500,360,200,40);
        c5.setFont(new Font("Arial",Font.PLAIN,15));
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBounds(500,400,200,40);
        c6.setFont(new Font("Arial",Font.PLAIN,15));
        add(c6);



        c7 = new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge");
        c7.setBounds(90,500,650,40);
        c7.setFont(new Font("Arial",Font.PLAIN,15));
        add(c7);


        submit = new JButton("Submit");
        submit.setBounds(200,620,200,40);
        submit.setFont(new Font("Raleway",Font.BOLD,18));
        submit.setForeground(Color.BLUE);
        submit.addActionListener(this);
        add(submit);
    


        cancel = new JButton("Cancel");
        cancel.setBounds(400,620,200,40);
        cancel.setFont(new Font("Raleway",Font.BOLD,18));
        cancel.setForeground(Color.RED);
        cancel.addActionListener(this);
        add(cancel);



        getContentPane().setBackground(Color.WHITE);
        setSize(800,850);
        setLocation(300,0);
        setTitle("ACCOUNT DETAILS PAGE - 3");
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        if (ae.getSource() == submit) {

            String accountType = null;

            if (r1.isSelected()) {
                accountType = "saving Account";
            }if (r2.isSelected()) {
                accountType = "current Account";
            }
            if (r3.isSelected()) {
                accountType="fd Account";
            }
            if (r4.isSelected()) {
                accountType="rd Account";
            }

            StringBuilder cardNumberBuilder = new StringBuilder();
            Random random = new Random();
            for (int i = 0; i < 16; i++) {
                cardNumberBuilder.append(random.nextInt(10));
            }
            String cardNumber = cardNumberBuilder.toString();
            String pin = pinTextField.getText();

            String Facility = "";
            if (c1.isSelected()) {
                Facility = Facility + "Debit Card,";
            }
            if (c2.isSelected()) {
                Facility = Facility + "Mobile Banking,";
            }
            if (c3.isSelected()) {
                Facility = Facility + "Cheque Book,";
            }
            if (c4.isSelected()) {
                Facility = Facility + "Email & SMS Alerts,";
            }
            if (c5.isSelected()) {
                Facility = Facility + "Internet Banking,";
            }
            if (c6.isSelected()) {
                Facility = Facility + "E-Statement";
            }
         
    
    
            try {
    
                if (!c7.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Please Select Terms & Condition");
                }
                else{
                Conn c = new Conn();
                String q1 = "insert into signup3 values('"+no+"','"+accountType+"','"+cardNumber+"','"+pin+"','"+Facility+"')";
                    c.s.executeUpdate(q1);


                    
                    JOptionPane.showMessageDialog(null, "Card Number: "+cardNumber+"\n pin: "+pin+"\n Please Notice this Card Number & Pin To Feature Use :)");

                    setVisible(false);
                    new Deposit(cardNumber).setVisible(true);

                }
                
            } catch (Exception e) {
                System.out.println(e);
            }

        }if (ae.getSource() == cancel) {
            setVisible(false);
            Login x = new Login("");
            x.setVisible(true);
        }

      
    }

    public static void main(String[] args) {
        new SignupThree("x");
    }
}
