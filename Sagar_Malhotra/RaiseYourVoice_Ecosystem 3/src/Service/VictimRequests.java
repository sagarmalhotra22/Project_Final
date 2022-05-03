/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author sagar
 */
public class VictimRequests {
     ArrayList<InvestigationRequest> investigationRequests = new ArrayList<>();
     ArrayList<MedicalRequest> medicalRequests = new ArrayList<>();
     
     
     
         public ArrayList<InvestigationRequest> getVictimInvestigationRequest() {
        DBConnection DBcon = new DBConnection();
        System.out.println("-------------Fetching Investigation Request-------------");
        Connection con= DBcon.getDbcon();
        
        
        try{
            PreparedStatement s = con.prepareStatement("Select * from INVESTIGATION_REQUEST");
            System.out.println("-------------Fetching Investigation requests for victim "+ "------------");
            ResultSet r = s.executeQuery();
            System.out.println("-------------Query Executed------------");
            if(r==null)
            {
                JOptionPane.showMessageDialog( null, "Some error occured. Data fetch unsucccessfull. Please try after sometime.");
            }
            
            while(r.next())
            {
                InvestigationRequest investigationRequest = new InvestigationRequest();
                investigationRequest.setVictim_email((!r.getString("Victim_email").isBlank() || r.getString("Victim_email").isEmpty()) ? 
                        r.getString("Victim_email") : null);
                investigationRequest.setCrime_Description((r.getString("Crime_Description").isBlank() || r.getString("Crime_Description").isEmpty()) ? 
                        r.getString("Crime_Description") : null);
                investigationRequest.setAssigned_To((r.getString("ASSIGNED_TO").isBlank() || r.getString("ASSIGNED_TO").isEmpty()) ? 
                        r.getString("ASSIGNED_TO") : null);
                investigationRequest.setDepartment((r.getString("DEPARTMENT").isBlank() || r.getString("DEPARTMENT").isEmpty()) ? 
                        r.getString("DEPARTMENT") : null);
                investigationRequest.setStatus((r.getString("Status").isBlank() || r.getString("Status").isEmpty()) ?
                        r.getString("Status") : null);
                
                if(!investigationRequest.getVictim_email().isEmpty() || !investigationRequest.getVictim_email().isBlank())
                    investigationRequests.add(investigationRequest);
            }
            return investigationRequests;
        }
        catch (SQLException e1)
        {
            JOptionPane.showMessageDialog( null, "Some error occured. Data fetch unsucccessfull. Please try after sometime.");
        }
        return null;
    }
         
           public ArrayList<MedicalRequest> getVictimMedicalRequest() {
        DBConnection DBcon = new DBConnection();
        System.out.println("-------------Fetching Medical Request-------------");
        Connection con= DBcon.getDbcon();
        
        
        try{
            PreparedStatement s = con.prepareStatement("Select * from MEDICAL_REQUEST");
            System.out.println("-------------Fetching Medical requests for victim "+ "------------");
            ResultSet r = s.executeQuery();
            System.out.println("-------------Query Executed------------");
            if(r==null)
            {
                JOptionPane.showMessageDialog( null, "Some error occured. Data fetch unsucccessfull. Please try after sometime.");
            }
            
            while(r.next())
            {
                MedicalRequest medicalRequest = new MedicalRequest();
                medicalRequest.setVictim_email((!r.getString("Victim_email").isBlank() || r.getString("Victim_email").isEmpty()) ? 
                        r.getString("Victim_email") : null);
                medicalRequest.setProblem_Description((r.getString("Problem_Description").isBlank() || r.getString("Problem_Description").isEmpty()) ? 
                        r.getString("Problem_Description") : null);
                medicalRequest.setAssigned_To((r.getString("ASSIGNED_TO").isBlank() || r.getString("ASSIGNED_TO").isEmpty()) ? 
                        r.getString("ASSIGNED_TO") : null);
                medicalRequest.setDepartment((r.getString("DEPARTMENT").isBlank() || r.getString("DEPARTMENT").isEmpty()) ? 
                        r.getString("DEPARTMENT") : null);
                medicalRequest.setStatus((r.getString("Status").isBlank() || r.getString("Status").isEmpty()) ?
                        r.getString("Status") : null);
                
                if(!medicalRequest.getVictim_email().isEmpty() || !medicalRequest.getVictim_email().isBlank())
                    medicalRequests.add(medicalRequest);
            }
            return medicalRequests;
        }
        catch (SQLException e1)
        {
            JOptionPane.showMessageDialog( null, "Some error occured. Data fetch unsucccessfull. Please try after sometime.");
        }
        return null;
    }
}
