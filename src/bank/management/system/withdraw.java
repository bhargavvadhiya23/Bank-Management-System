package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.nio.channels.Pipe.SourceChannel;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.*;
import javax.swing.event.*;

public class withdraw extends JFrame implements ActionListener {

    JLabel label;
    JTextField amount;
    Double z;
    String cardnum;
    JButton deposit, withdraw, fastcash, ministatement, checkbalance, enter, exit;

    withdraw(String cardnum) {
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

        setTitle("Atm Withdrawal");
        label = new JLabel("Please Enter Amount");
        label.setBounds(230, 270, 300, 35);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 18));
        img.add(label);

        amount = new JTextField();
        amount.setBounds(170, 350, 300, 35);
        amount.setForeground(Color.BLACK);
        amount.setFont(new Font("Arial", Font.PLAIN, 18));
        img.add(amount);

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
            new Login("");
        } else {
            String rs = amount.getText();

            try {
                z = Double.parseDouble(rs);
                Conn c = new Conn();

                try {
                    ResultSet r = c.s.executeQuery("select * from banking where cardnum = '" + cardnum + "'");

                    Double balance = 0.0;
                    try {

                        while (r.next()) {
                            if (r.getString("type").equals("Deposit")) {
                                balance += Double.parseDouble(r.getString("amount"));
                            } else {
                                balance -= Double.parseDouble(r.getString("amount"));
                            }

                        }

                        if (z > balance) {
                            JOptionPane.showMessageDialog(null, "insufficient Balance");
                        } else {

                            Date date = new Date();
                            String q1 = "Insert into banking values('" + cardnum + "','" + date +
                                    "','Withdraw','"
                                    + z.toString() + "')";
                            try {
                                c.s.executeUpdate(q1);
                                JOptionPane.showMessageDialog(null, z.toString() + " debited Succefully :)");
                                setVisible(false);
                                new Login(cardnum).setVisible(true);
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "Server Error Try After Some Time !");

                            }
                        }

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "CardNumber Not Match");

                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Server Error!");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Invalid Input!");
            }

        }

        // try {
        // Conn c = new Conn();

        // if (ae.getSource() == enter) {
        // String rs = amount.getText();
        // try {
        // z = Double.parseDouble(rs);

        // ResultSet x = c.s.executeQuery("select * from banking where cardnum = '" +
        // cardnum + "'");
        // Double balance = 0.0;
        // while (x.next()) {
        // if (x.getString("type").equals("Deposit")) {
        // balance += Double.parseDouble(x.getString("amount"));
        // } else {
        // balance -= Double.parseDouble(x.getString("amount"));
        // }
        // }

        // if (z > balance) {
        // JOptionPane.showMessageDialog(null, "insufficient Balance");
        // } else {

        // Date date = new Date();
        // String q1 = "Insert into banking values('" + cardnum + "','" + date +
        // "','Withdraw','"
        // + x.toString() + "')";
        // try {
        // c.s.executeUpdate(q1);
        // JOptionPane.showMessageDialog(null, x.toString() + " debited Succefully :)");
        // setVisible(false);
        // new Login(cardnum).setVisible(true);
        // } catch (Exception e) {
        // JOptionPane.showMessageDialog(null, "Server Error Try After Some Time !");

        // }
        // }

        // } catch (Exception e) {
        // JOptionPane.showMessageDialog(null, "Please Enter Valid Ammount Details!");
        // }

        // }

        // if (ae.getSource() == exit) {
        // setVisible(false);
        // Transaction x = new Transaction(cardnum);
        // x.setVisible(true);
        // }
        // } catch (Exception e) {
        // JOptionPane.showMessageDialog(null, "Server Error Try After Some Time !");
        // setVisible(false);
        // new Login("").setVisible(true);

        // }

    }

    public static void main(String[] args) {
        new withdraw("");
    }
}
