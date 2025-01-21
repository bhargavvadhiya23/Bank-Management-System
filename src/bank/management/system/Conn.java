
package bank.management.system;
import java.sql.*;
public class Conn {
    
    Connection c=null;
    Statement s=null;
   public Conn(){
       
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem","root","bhargav&1");
            s = c.createStatement();
        }catch(Exception e){
            System.out.print(e);
        }
    
   
   
   }
   
   
}




