
package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.nio.channels.Pipe.SourceChannel;
import java.util.Date;

import javax.swing.*;
import javax.swing.event.*;

public class PinChange extends JFrame implements ActionListener {

    JLabel label;
    JPasswordField fpin,spin;
    Double x;
    String cardnum;
    JButton deposit, withdraw, fastcash, ministatement, checkbalance, enter, exit;

    PinChange(String cardnum) {
        this.cardnum = cardnum;

        setLayout(null);

        ImageIcon atm = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i = atm.getImage().getScaledInstance(1000, 900, Image.SCALE_DEFAULT);
        ImageIcon x = new ImageIcon(i);
        JLabel img = new JLabel(x);
        img.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        img.setAlignmentX((int) CENTER_ALIGNMENT);
        img.setBounds(0, 0, 900, 850);
        add(img);

        label = new JLabel("Please Enter new Pin");
        label.setBounds(230, 270, 300, 35);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 18));
        img.add(label);


        label = new JLabel("Enter New Pin");
        label.setBounds(170, 330, 300, 20);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.CENTER_BASELINE, 12));
        img.add(label);


        fpin = new JPasswordField();
        fpin.setBounds(170, 350, 300, 35);
        fpin.setForeground(Color.BLACK);
        fpin.setFont(new Font("Arial", Font.PLAIN, 18));
        img.add(fpin);


        label = new JLabel("Re-Enter New Pin");
        label.setBounds(170, 390, 300, 20);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.CENTER_BASELINE, 12));
        img.add(label);
        spin = new JPasswordField();
        spin.setBounds(170, 410, 300, 35);
        spin.setForeground(Color.BLACK);
        spin.setFont(new Font("Arial", Font.PLAIN, 18));
        img.add(spin);

        enter = new JButton("Enter");
        enter.setBounds(170, 460, 100, 35);
        enter.setForeground(Color.BLUE);
        enter.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
        enter.addActionListener(this);
        img.add(enter);

        exit = new JButton("Cancel");
        exit.setBounds(370, 460, 100, 35);
        exit.setForeground(Color.RED);
        exit.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
        exit.addActionListener(this);
        img.add(exit);

        setSize(900, 850);
        setMinimumSize(new Dimension(900, 850));
        setMaximumSize(new Dimension(900, 850));
        setVisible(true);
        setLocation(300, 0);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == exit) {
            setVisible(false);
            new Login(cardnum).setVisible(true);
        }else{
            String pin = fpin.getText();
            String pin2  = spin.getText();

            if (!pin.equals(pin2)) {
                JOptionPane.showMessageDialog(null, "Entered Pin Does not Match!");
                fpin.setText("");
                spin.setText("");
                return;
            }else{

                if (pin.equals("") || pin2.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter Both Pin!");
                    fpin.setText("");
                    spin.setText("");  
                    return;
                }else{

                    Conn c = new Conn();
                    String q = "update signup3 set pin = '"+pin+"' where cardNumber='"+cardnum+"'";
                    try {
                        c.s.executeUpdate(q);
                        JOptionPane.showMessageDialog(null, "Pin Chnaged sucessfully :)");
                        setVisible(false);
                        new Login(cardnum).setVisible(true);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        new PinChange("");
    }
}
