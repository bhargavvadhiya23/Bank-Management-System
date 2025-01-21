package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.event.*;

public class Transaction extends JFrame implements ActionListener {

    JLabel label;
    JButton deposit, withdraw, fastcash, ministatement, checkbalance, pinchange, exit;
    String cardnum;

    Transaction(String cardnum) {
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

        label = new JLabel("PLEASE SELECT TRANSACTION");
        label.setBounds(180, 270, 300, 35);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 18));
        img.add(label);

        deposit = new JButton("Deposit");
        deposit.setBounds(120, 385, 150, 35);
        deposit.setForeground(Color.BLUE);
        deposit.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
        deposit.addActionListener(this);
        img.add(deposit);

        withdraw = new JButton("Cash Withdrawl");
        withdraw.setBounds(375, 385, 150, 35);
        withdraw.setForeground(Color.BLUE);
        withdraw.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
        withdraw.addActionListener(this);
        img.add(withdraw);

        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(120, 425, 150, 35);
        fastcash.setForeground(Color.BLUE);
        fastcash.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
        fastcash.addActionListener(this);
        img.add(fastcash);

        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(375, 425, 150, 35);
        ministatement.setForeground(Color.BLUE);
        ministatement.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
        ministatement.addActionListener(this);
        img.add(ministatement);

        pinchange = new JButton("Pin Change");
        pinchange.setBounds(120, 460, 150, 35);
        pinchange.setForeground(Color.BLUE);
        pinchange.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
        pinchange.addActionListener(this);
        img.add(pinchange);

        checkbalance = new JButton("Check Balance");
        checkbalance.setBounds(375, 460, 150, 35);
        checkbalance.setForeground(Color.BLUE);
        checkbalance.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
        checkbalance.addActionListener(this);
        img.add(checkbalance);

        exit = new JButton("Exit");
        exit.setBounds(375, 493, 150, 35);
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

        try {
            Conn c = new Conn();

            if (ae.getSource() == deposit) {
                setVisible(false);
                Deposit d = new Deposit(cardnum);
                d.setVisible(true);
            }

            if (ae.getSource() == pinchange) {


                setVisible(false);
               new PinChange(cardnum).setVisible(true);
            }

            if (ae.getSource() == withdraw) {
                setVisible(false);
                withdraw w = new withdraw(cardnum);
                w.setVisible(true);
            }

            if (ae.getSource() == fastcash) {
                setVisible(false);
                new FastCash(cardnum).setVisible(true);
            }

            if (ae.getSource() == ministatement) {
                setVisible(true);
                new MiniStatement(cardnum).setVisible(true);
            }

            if (ae.getSource() == checkbalance) {

                Double balance = 0.0;
                    try {
                         ResultSet r = c.s.executeQuery("select * from banking where cardnum = '" + cardnum + "'");

                        while (r.next()) {
                            if (r.getString("type").equals("Deposit")) {
                                balance += Double.parseDouble(r.getString("amount"));
                            } else {
                                balance -= Double.parseDouble(r.getString("amount"));
                            }

                        }
                    

                        setVisible(false);
                        new CheckBalance(balance+"",cardnum).setVisible(true);
                    }catch(Exception e){
                            JOptionPane.showMessageDialog(null, "Server Down! Please After Some Time !");
                        }

            }

            if (ae.getSource() == exit) {
                setVisible(false);
                Login x = new Login("");
                x.setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);

        }

    }

    public static void main(String[] args) {
        new Transaction("");
    }
}
