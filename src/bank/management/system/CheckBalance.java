
package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.nio.channels.Pipe.SourceChannel;
import java.util.Date;

import javax.swing.*;
import javax.swing.event.*;

public class CheckBalance extends JFrame implements ActionListener {

    JLabel label;
    JPasswordField fpin, spin;
    Double x;
    String Balance,cardnum;
    JButton deposit, withdraw, fastcash, ministatement, checkbalance, enter, exit;

    CheckBalance(String balance2, String cardnum) {
        this.Balance = balance2;
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

        label = new JLabel("Balance: "+Balance);
        label.setBounds(210, 370, 300, 35);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
        img.add(label);

        exit = new JButton("Exit");
        exit.setBounds(370, 460, 100, 35);
        exit.setForeground(Color.RED);
        exit.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
        exit.addActionListener(this);
        img.add(exit);

        setSize(900, 850);
        setTitle("Balance Inquery");
        setMinimumSize(new Dimension(900, 850));
        setMaximumSize(new Dimension(900, 850));
        setVisible(true);
        setLocation(300, 0);

    }

    public void actionPerformed(ActionEvent ae) {

        setVisible(false);
        new Transaction(cardnum).setVisible(true);
    }

    public static void main(String[] args) {
        new CheckBalance("","");
    }
}
