
package bank.management.system;

import java.awt.ActiveEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;

public class Login extends JFrame implements ActionListener {
    JButton signup,clear,login;
    JTextField cardTextField;
    JPasswordField pinTextField;
    String card;
    Login(String cardnumber) {
        card = cardnumber;
        setLayout(null);

        setTitle("BRV INTERNATIONAL BANK ATM");
        ImageIcon i1 = new
        ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100, 10, 100, 100);
        add(image);

        JLabel heading = new JLabel("Wellcome to ATM");
        add(heading);
        heading.setBounds(220, 40 , 500 , 40);
        heading.setFont(new Font("Osward",Font.BOLD,38));

        JLabel cardNumber = new JLabel("Card No :");
        add(cardNumber);
        cardNumber.setBounds(220, 120 , 100 , 40);
        cardNumber.setFont(new Font("Osward",Font.BOLD,18));

         cardTextField = new JTextField();
         cardTextField.setText(cardnumber);
        add(cardTextField);
        cardTextField.setBounds(360, 120 , 200 , 30);


        JLabel pin = new JLabel("Pin :");
        add(pin);
        pin.setBounds(220, 180 , 200 , 40);
        pin.setFont(new Font("Osward",Font.BOLD,18));


         pinTextField = new JPasswordField();
        add(pinTextField);
        pinTextField.setBounds(360, 180 , 200 , 30);



         login = new JButton("LOG IN");
        login.setBounds(360, 250, 80, 40);
        login.setForeground(Color.BLUE);
        login.setFont(new Font("Raleway", Font.BOLD, 14));
        add(login);
        login.addActionListener(this);



         clear = new JButton("CLEAR");
        clear.setBounds(480, 250, 80, 40);
        clear.setForeground(Color.BLUE);
        clear.setFont(new Font("Raleway", Font.BOLD, 14));
        add(clear);
        clear.addActionListener(this);


         signup = new JButton("SIGN UP");
        signup.setBounds(360, 310, 200, 40);
        signup.setForeground(Color.BLUE);
        signup.setFont(new Font("Raleway", Font.BOLD, 14));
        add(signup);
        signup.addActionListener(this);

        getContentPane().setBackground(Color.white);
        setSize(800, 480);
        setVisible(true);
        setLocation(350, 200);
       

    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==clear) {
            cardTextField.setText("");
            pinTextField.setText("");
            
        }else if (ae.getSource() == login) {
            Conn c = new Conn();
            String cardnum = cardTextField.getText();
            String pin = pinTextField.getText();
            String query = "select * from signup3 where cardNumber = '"+cardnum+"' and pin = '"+pin+"'";
            try {
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    Transaction tr = new Transaction(cardnum);
                    tr.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Card Number & Pin Doesent Match \nEnter Currect Pin");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "please enter pin perfectly (pin does not contains special charachter ',`,!,@...)\n"+e);
                
                System.out.println(e);
            }
            
        }else if (ae.getSource() == signup) {
            setVisible(false);
            SignupOne  s = new SignupOne();
            s.setVisible(true);
        }
    }

    public static void main(String args[]) {
        new Login("");
    }
}
