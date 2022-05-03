/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author sagar
 */
public class RecoverPassword {
    String email;
    String petname;
    String user;
    String pass;
    String question;
    String rpass;
    
    public String ReturnPassword(String email, String petname,String user){
    this.email =email;
    this.petname= petname;
    this.user = user;
    
     DBConnection DBcon = new DBConnection();
        
        Connection con= DBcon.getDbcon();
    if(user.equalsIgnoreCase("Victim")){
                try{
                    PreparedStatement stmt=con.prepareStatement("Select password,security_question from VICTIM where EMAIL=?");

                               
                                    stmt.setString(1,email);
                                   System.out.println("-------------Recovering Password-------------");
                                    ResultSet rset=stmt.executeQuery();

                    System.out.println("query executed");
                    while(rset.next()){
                             pass =rset.getString("password");
                             question = rset.getString("security_question");
                    }
                  
                    if(pass.isEmpty()){
                     JOptionPane.showMessageDialog(null, "Email not present in dataset");

                    }
                    else if(!(question.trim().equalsIgnoreCase(petname.trim()))){
                        JOptionPane.showMessageDialog(null, "Incorrect Pet name");
                    }
                    else
                    {JOptionPane.showMessageDialog(null, "Password Recovery Successfull");
                    rpass = pass;
                    }

                    stmt.close();
                    con.close();


                } 
                catch (SQLException e1) {
                        JOptionPane.showMessageDialog( null, "Some Error Occured.Password Recovery Unsucccessfull. Please Try After Sometime.");
                    }
             
     
       }
        else if (user.equalsIgnoreCase("Staff")){
         try{
                    PreparedStatement stmt=con.prepareStatement("Select password from STAFF where EMAIL=?");

                                    
                                    stmt.setString(1,email);
                                    ResultSet rset=stmt.executeQuery();

                    System.out.println("query executed");
                    while(rset.next()){
                             pass =rset.getString("password");
                              question = rset.getString("security_question");
                             
                    }
                    if(pass.isEmpty()){
                     JOptionPane.showMessageDialog(null, "Email not present in dataset");

                    }
                    else if(!(question.trim().equalsIgnoreCase(petname.trim()))){
                        JOptionPane.showMessageDialog(null, "Incorrect Pet name");
                    }
                    else
                    {JOptionPane.showMessageDialog(null, "Password Recovery Successfull");
                    rpass = pass; 
                    }

                    stmt.close();
                    con.close();


                } 
                catch (SQLException e1) {
                        JOptionPane.showMessageDialog( null, "Some Error Occured.Password Recovery Unsucccessfull. Please Try After Sometime.");
                    }
             
     
        }
        
     return pass; }
}
