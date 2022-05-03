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
public class RequestMedical {
    MedicalRequest medReq;

    public RequestMedical(MedicalRequest medReq) {
        this.medReq = medReq;
        
        DBConnection DBcon = new DBConnection();
        System.out.println("-------------Requesting Medical------------------");
	Connection con= DBcon.getDbcon();
	try{
	
	PreparedStatement stmt=con.prepareStatement("Insert into  Medical_Request(Victim_email,Problem_Description,Service,Gender,Department,Assigned_To,Status,Notes,Request_Date,Update_Date) Values(?,?,?,?,?,?,?,?,?,?)");
    
	                stmt.setString(1,medReq.getVictim_email());
                        stmt.setString(2,medReq.getProblem_Description());
                        stmt.setString(3, medReq.getService());
                        stmt.setString(4,medReq.getGender());
                        stmt.setString(5,medReq.getDepartment());
                        stmt.setString(6,medReq.getAssigned_To());
                        stmt.setString(7,medReq.getStatus());
                        stmt.setString(8,medReq.getNotes());
                        stmt.setString(9,medReq.getRequest_Date());
                        stmt.setString(10,medReq.getUpdate_Date());
                        stmt.executeQuery();
        JOptionPane.showMessageDialog( null, " Request raised sucessfully for "+medReq.getVictim_email());
	System.out.println("-------------Request raised sucessfully------------------");
        stmt.close();
	con.close();
               

            } catch (SQLException e1) {
                JOptionPane.showMessageDialog( null,e1.getMessage());
            }
    }
    
    
}
