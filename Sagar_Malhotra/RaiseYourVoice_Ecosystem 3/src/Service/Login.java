/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;
import Interface.HospitalAdmin;
import Interface.VictimReporting;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author sagar
 */
public class Login {
 String pass;
 String role;
 String Counter;
 String email;
 String passwor ;
 String table;

    public String UserLogin(String email, String passwor, String table) {
        this.email = email;
        this.passwor = passwor;
        this.table = table;
        
        
        DBConnection DBcon = new DBConnection();
        System.out.println("-------------Logging In-------------");
        Connection con= DBcon.getDbcon();
        if(table.equalsIgnoreCase("Victim")){
                try{
                    PreparedStatement stmt=con.prepareStatement("Select password from VICTIM where EMAIL=?");

                               
                                    stmt.setString(1,email);
                                    System.out.println("-------------Logging In2------------");
                                    ResultSet rset=stmt.executeQuery();

                    System.out.println("query executed");
                    while(rset.next()){
                             pass =rset.getString("password");
                    }
                     System.out.println(pass);
                    if(pass.isEmpty()){
                     JOptionPane.showMessageDialog(null, "Email not present in dataset");

                    }
                    else if(!(pass.trim().equalsIgnoreCase(passwor.trim()))){
                        JOptionPane.showMessageDialog(null, "Incorrect Password");
                    }
                    else
                    {JOptionPane.showMessageDialog(null, "Login Successfull");
                    Counter = "VICTIM";
                    }

                    stmt.close();
                    con.close();


                } 
                catch (SQLException e1) {
                        JOptionPane.showMessageDialog( null, "Some Error Occured.Login Unsucccessfull. Please Try After Sometime.");
                    }
             
     
       }
        else if (table.equalsIgnoreCase("Staff")){
         try{
                    PreparedStatement stmt=con.prepareStatement("Select password, role from STAFF where EMAIL=?");

                                    
                                    stmt.setString(1,email);
                                    ResultSet rset=stmt.executeQuery();

                    System.out.println("query executed");
                    while(rset.next()){
                        System.out.println("!@#$%^&*Admin12345678");
                             pass =rset.getString("password");
                             role = rset.getString("role");
                    }
                    if(pass.isEmpty()){
                     JOptionPane.showMessageDialog(null, "Email not present in dataset");

                    }
                    else if(!(pass.trim().equalsIgnoreCase(passwor.trim()))){
                        JOptionPane.showMessageDialog(null, "Incorrect Password");
                    }
                    else
                    {JOptionPane.showMessageDialog(null, "Login Successfull");
                        System.out.println(role);
                    Counter = role; 
                    }

                    stmt.close();
                    con.close();


                } 
                catch (SQLException e1) {
                        JOptionPane.showMessageDialog( null, "Some Error Occured.Login Unsucccessfull. Please Try After Sometime.");
                    }
             
     
        }
        
     return Counter;
        }
     
    }
  

