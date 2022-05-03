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
public class RequestInvestigation {
    InvestigationRequest invRequest;
     public void ReqInvestigation(InvestigationRequest invRequest){
     this.invRequest = invRequest;
     DBConnection DBcon = new DBConnection();
        System.out.println("-------------Requesting Investigation------------------");
	Connection con= DBcon.getDbcon();
	try{
	
	PreparedStatement stmt=con.prepareStatement("Insert into Investigation_Request(Victim_email,Culprit_Name,Crime_Description,Crime_Location,Crime_Date,Culprit_Image,Department,Assigned_To,Status,Notes,Request_Date,Update_Date,Test_Assigne) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
    
	                stmt.setString(1,invRequest.getVictim_email());
                        stmt.setString(2,invRequest.getCulprit_Name());
                        stmt.setString(3, invRequest.getCrime_Description());
                        stmt.setString(4,invRequest.getCrime_Location());
                        stmt.setString(5, invRequest.getCrime_Date());
                        stmt.setString(6,invRequest.getCulprit_Image());
                        stmt.setString(7,invRequest.getDepartment());
                        stmt.setString(8,invRequest.getAssigned_To());
                        stmt.setString(9,invRequest.getStatus());
                        stmt.setString(10,invRequest.getNotes());
                        stmt.setString(11,invRequest.getRequest_Date());
                        stmt.setString(12,invRequest.getUpdate_Date());
                        stmt.setString(13,invRequest.getTest_Assigne());
                        stmt.executeQuery();
        JOptionPane.showMessageDialog( null, " Request raised sucessfully for "+invRequest.getVictim_email());
	System.out.println("-------------Request raised sucessfully------------------");
        stmt.close();
	con.close();
               

            } catch (SQLException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog( null, "Some Error Occured. Please Try After Sometime.");
            }
     }
}
