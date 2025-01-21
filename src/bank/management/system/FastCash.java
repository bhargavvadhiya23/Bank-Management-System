package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.*;
import javax.swing.event.*;

public class FastCash extends JFrame implements ActionListener {

    JLabel label;
    JButton fiveH, thousand, twoth, fiveth, checkbalance, tenth, back;
    String cardnum;
    Double z;
    FastCash(String cardnum) {
        this.cardnum = cardnum;
        setLayout(null);

        setTitle("Fast Cash");
        ImageIcon atm = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i = atm.getImage().getScaledInstance(1000, 900, Image.SCALE_DEFAULT);
        ImageIcon x = new ImageIcon(i);
        JLabel img = new JLabel(x);
        img.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        img.setAlignmentX((int) CENTER_ALIGNMENT);
        img.setBounds(0, 0, 900, 850);
        add(img);

        label = new JLabel("SELECT AMMOUNT");
        label.setBounds(180, 270, 300, 35);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 18));
        img.add(label);

        fiveH = new JButton("500");
        fiveH.setBounds(120, 385, 150, 35);
        fiveH.setForeground(Color.BLUE);
        fiveH.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
        fiveH.addActionListener(this);
        img.add(fiveH);

        thousand = new JButton("1000");
        thousand.setBounds(375, 385, 150, 35);
        thousand.setForeground(Color.BLUE);
        thousand.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
        thousand.addActionListener(this);
        img.add(thousand);

        twoth = new JButton("2000");
        twoth.setBounds(120, 425, 150, 35);
        twoth.setForeground(Color.BLUE);
        twoth.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
        twoth.addActionListener(this);
        img.add(twoth);

        fiveth = new JButton("5000");
        fiveth.setBounds(375, 425, 150, 35);
        fiveth.setForeground(Color.BLUE);
        fiveth.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
        fiveth.addActionListener(this);
        img.add(fiveth);

        tenth = new JButton("10000");
        tenth.setBounds(120, 460, 150, 35);
        tenth.setForeground(Color.BLUE);
        tenth.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
        tenth.addActionListener(this);
        img.add(tenth);

        back = new JButton("Back");
        back.setBounds(375, 493, 150, 35);
        back.setForeground(Color.RED);
        back.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
        back.addActionListener(this);
        img.add(back);

        setSize(900, 850);
        setMinimumSize(new Dimension(900, 850));
        setMaximumSize(new Dimension(900, 850));
        setVisible(true);
        setLocation(300, 0);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Transaction(cardnum).setVisible(true);

        }else{
            String rs =((JButton)ae.getSource()).getText();

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

    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
