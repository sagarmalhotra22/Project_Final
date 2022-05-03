/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author sagar
 */
public class VictimRegistration {
    Victim victim;

    public VictimRegistration(Victim victim) {
        this.victim = victim;
        
         DBConnection DBcon = new DBConnection();
        System.out.println("-------------Registering Victim------------------");
	Connection con= DBcon.getDbcon();
	try{
	
	PreparedStatement stmt=con.prepareStatement("insert into VICTIM values(?,?,?,?,?,?)");
    
	                stmt.setString(1,victim.getName());
                        stmt.setLong(2, victim.getContact());
                        stmt.setString(3,victim.getEmail());
                        stmt.setString(4, victim.getPassword());
                        stmt.setString(5,victim.getCity());
                        stmt.setString(6,victim.getSecurity_question());
                        stmt.executeQuery();
        JOptionPane.showMessageDialog( null, victim.getName()+ " Registered Sucessfully");
	System.out.println("-------------Registeration Successful------------------");
        stmt.close();
	con.close();
               

            } catch (SQLException e1) {
                JOptionPane.showMessageDialog( null, "Some Error Occured. Registration Unsucccessfull. Please Try After Sometime.");
            }
    }
    
}
