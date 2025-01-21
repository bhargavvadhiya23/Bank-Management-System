package bank.management.system;

import java.awt.Font;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MiniStatement extends JFrame {
    JLabel text,card,statement,bl;
    String cardnum;

    MiniStatement(String cardnum){
        this.cardnum = cardnum;


        setLayout(null);


        text =new JLabel("BRV INTERNATIONAL BANK");
        text.setFont(new Font("Times New Roman",Font.BOLD,18));
        text.setBounds(120,50,500,40);
        add(text);


        card = new JLabel("Card No: "+cardnum);
        card.setFont(new Font("Arial",Font.PLAIN,13));
        card.setBounds(50,100,200,30);
        add(card);







        Double balance = 0.0;
                    try {
                        Conn c = new Conn();
                         ResultSet r = c.s.executeQuery("select * from banking where cardnum = '" + cardnum + "'");

                        while (r.next()) {
                            if (r.getString("type").equals("Deposit")) {
                                balance += Double.parseDouble(r.getString("amount"));
                            } else {
                                balance -= Double.parseDouble(r.getString("amount"));
                            }

                        }
                    

                        bl = new JLabel("Balance: "+balance);
                        bl.setFont(new Font("Arial",Font.PLAIN,13));
                        bl.setBounds(300,100,200,30);
                        add(bl);
                        
                    }catch(Exception e){
                            JOptionPane.showMessageDialog(null, "Server Down! Please After Some Time !");
                        }















        statement = new JLabel("");
        statement.setFont(new Font("Arial",Font.PLAIN,13));
        statement.setBounds(50,140,500,450);
        add(statement);
        try {
            Conn c = new Conn();
            String q = "select * from banking where cardnum = '"+cardnum+"'";
            ResultSet rs = c.s.executeQuery(q);
            ArrayList<String> x = new ArrayList<>();
            while (rs.next()) {
                String transaction = rs.getString("date") + "&nbsp&nbsp&nbsp      "+rs.getString("type")+"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp " + rs.getString("amount");
                x.add(transaction);
            }
       
        int d = 10;
        if (x.size() < 10) {
            d=x.size();
        }
        for (int i = x.size()-1; i >=x.size()-d; i--) {
            statement.setText(statement.getText()+"<html><br><br>"+x.get(i));
        }
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Server error!");
        }




        setTitle("Mini Statement");
        setLocation(100,100);
        setSize(500,600);
        setVisible(true);



    }
    public static void main(String[] args) {
        new MiniStatement("");
    }
}
