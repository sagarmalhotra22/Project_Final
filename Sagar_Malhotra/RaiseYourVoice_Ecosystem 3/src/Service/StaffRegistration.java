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
public class StaffRegistration {
     
    Staff staff;

    public StaffRegistration(Staff staff) {
        this.staff = staff;
        
        DBConnection DBcon = new DBConnection();
        System.out.println("-------------Registering Staff------------------");
	Connection con= DBcon.getDbcon();
	try{
	
	PreparedStatement stmt=con.prepareStatement("insert into STAFF values(?,?,?,?,?,?,?,?,?,?)");
    
	                stmt.setString(1,staff.getName());
                        stmt.setLong(2, staff.getContact());
                        stmt.setString(3,staff.getEmail());
                        stmt.setString(4, staff.getPassword());
                        stmt.setString(5,staff.getCity());
                        stmt.setString(6,staff.getEnterprise());
                        stmt.setString(7,staff.getDepartment());
                        stmt.setString(8,staff.getRole());
                        stmt.setString(9,staff.getSecurity_question());
                        stmt.setString(10,staff.getWorking_Status());
                        stmt.executeQuery();
	JOptionPane.showMessageDialog( null, staff.getName()+" Registered Sucessfully\"");
        System.out.println("-------------Registeration Successful------------------");
        stmt.close();
	con.close();
               

            } catch (SQLException e1) {
                JOptionPane.showMessageDialog( null, "Some Error Occured. Registration Unsucccessfull. Please Try After Sometime.");
            }
    }
    
    
    
}
