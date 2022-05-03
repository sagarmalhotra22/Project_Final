/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author shreyangiprasad
 */
public class LawService {
    
    public ArrayList<InvestigationRequest> getLawyerRequests(String email)
    {
        ArrayList<InvestigationRequest> lawRequests = new ArrayList<InvestigationRequest>();
        DBConnection DBcon = new DBConnection();
        System.out.println("-------------Fetching Investigation Request-------------");
        Connection con= DBcon.getDbcon();
        
        String query = prepareQuery(String.valueOf(Constants.LawOperations.GET_ALLOCATED_REQUESTS), "", "");
        
        if(query.isBlank() || query.isEmpty())
            return null;
        
        try{
            PreparedStatement s = con.prepareCall(query);
            s.setString(1, String.valueOf(Constants.Status.ASSIGNED_TO_LAWYER));
            System.out.println("-------------Fetching law requests from " + Constants.investigationTableName + "------------");
            ResultSet r = s.executeQuery();
            System.out.println("-------------Query Executed------------");
            if(r==null)
            {
                JOptionPane.showMessageDialog( null, "Some error occured. Data fetch unsucccessfull. Please try after sometime.");
            }
            
            while(r.next())
            {
                InvestigationRequest investigationRequest = new InvestigationRequest();
                investigationRequest.setRequest_Id((!r.getString("Request_Id").isBlank() || r.getString("Request_Id").isEmpty()) ? 
                        r.getString("Request_Id") : null);
                investigationRequest.setVictim_email((!r.getString("Victim_email").isBlank() || r.getString("Victim_email").isEmpty()) ? 
                        r.getString("Victim_email") : null);
                investigationRequest.setCrime_Description((r.getString("Crime_Description").isBlank() || r.getString("Crime_Description").isEmpty()) ? 
                        r.getString("Crime_Description") : null);
                investigationRequest.setStatus((r.getString("Status").isBlank() || r.getString("Status").isEmpty()) ?
                        r.getString("Status") : null);
                
                if(!investigationRequest.getVictim_email().isEmpty() || !investigationRequest.getVictim_email().isBlank())
                    lawRequests.add(investigationRequest);
            }
            s.close();
            con.close();
            return lawRequests;
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog( null, "Some error occured. Data fetch unsucccessfull. Please try after sometime.");
        }
        return null;
    }
    
    public Boolean presentCase(String email, String notes, String requestId)
    {
        DBConnection DBcon = new DBConnection();
        System.out.println("-------------Fetching Investigation Request-------------");
        Connection con = DBcon.getDbcon();
        
        String query = prepareQuery(String.valueOf(Constants.LawOperations.PRESENT_CASE), "", "");
        
        if(query.isBlank() || query.isEmpty())
            return null;
        try{
            PreparedStatement s = con.prepareCall(query);
            s.setString(1, String.valueOf(Constants.Status.CASE_PRESENTED));
            s.setString(2, email);
            s.setString(3, notes);
            s.setString(4, requestId);
            System.out.println("-------------Fetching law requests from " + Constants.investigationTableName + "------------");
            Integer r = s.executeUpdate();
            System.out.println("-------------Query Executed------------");
            if(r==0)
            {
                JOptionPane.showMessageDialog( null, "Some error occured. Data fetch unsucccessfull. Please try after sometime.");
            }
            s.close();
            con.close();
            return true;
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog( null, "Some error occured. Data fetch unsucccessfull. Please try after sometime.");
        }
        return null;
    }
    
    public ArrayList<InvestigationRequest> getJudgeRequests()
    {
        ArrayList<InvestigationRequest> judgeRequests = new ArrayList<InvestigationRequest>();
        DBConnection DBcon = new DBConnection();
        System.out.println("-------------Fetching Investigation Request-------------");
        Connection con= DBcon.getDbcon();
        
        String query = prepareQuery(String.valueOf(Constants.LawOperations.GET_JUDGE_REQUESTS), "", "");
        if(query.isBlank() || query.isEmpty())
            return null;
        
        try{
            PreparedStatement s = con.prepareCall(query);
            s.setString(1, String.valueOf(Constants.Status.CASE_PRESENTED));
            System.out.println("-------------Fetching judge requests from " + Constants.investigationTableName + "------------");
            ResultSet r = s.executeQuery();
            System.out.println("-------------Query Executed------------");
            if(r==null)
            {
                JOptionPane.showMessageDialog( null, "Some error occured. Data fetch unsucccessfull. Please try after sometime.");
            }
            
            while(r.next())
            {
                InvestigationRequest investigationRequest = new InvestigationRequest();
                investigationRequest.setRequest_Id((!r.getString("Request_Id").isBlank() || r.getString("Request_Id").isEmpty()) ? 
                        r.getString("Request_Id") : null);
                investigationRequest.setVictim_email((!r.getString("Victim_email").isBlank() || r.getString("Victim_email").isEmpty()) ? 
                        r.getString("Victim_email") : null);
                investigationRequest.setCrime_Description((r.getString("Crime_Description").isBlank() || r.getString("Crime_Description").isEmpty()) ? 
                        r.getString("Crime_Description") : null);
                investigationRequest.setStatus((r.getString("Status").isBlank() || r.getString("Status").isEmpty()) ?
                        r.getString("Status") : null);
                
                if(!investigationRequest.getVictim_email().isEmpty() || !investigationRequest.getVictim_email().isBlank())
                    judgeRequests.add(investigationRequest);
            }
            s.close();
            con.close();
            return judgeRequests;
        
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog( null, "Some error occured. Data fetch unsucccessfull. Please try after sometime.");
        }
        return null;
    }
    
    public Boolean passJudgement(String requestId, String notes)
    {
        DBConnection DBcon = new DBConnection();
        System.out.println("-------------Logging In-------------");
        Connection con = DBcon.getDbcon();
        
        String query = prepareQuery(String.valueOf(Constants.LawOperations.PRESENT_CASE), "", "");
        
        if(query.isBlank() || query.isEmpty())
            return null;
        try{
            PreparedStatement s = con.prepareCall(query);
            s.setString(1, String.valueOf(Constants.Status.CASE_CLOSED));
            s.setString(2, "");
            s.setString(3, notes);
            s.setString(4, requestId);
            System.out.println("-------------Fetching law requests from " + Constants.investigationTableName + "------------");
            Integer r = s.executeUpdate();
            System.out.println("-------------Query Executed------------");
            if(r==0)
            {
                JOptionPane.showMessageDialog( null, "Some error occured. Data fetch unsucccessfull. Please try after sometime.");
            }
            s.close();
            con.close();
            return true;
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog( null, "Some error occured. Data fetch unsucccessfull. Please try after sometime.");
        }
        return null;
    }
    
    private String prepareQuery(String operation, String role, String email)
    {
        if(operation.equals(String.valueOf(Constants.LawOperations.GET_ALLOCATED_REQUESTS)))
        {
            return "SELECT * FROM " + Constants.investigationTableName + " WHERE Status=?";
        }
        if(operation.equals(String.valueOf(Constants.LawOperations.PRESENT_CASE)))
        {
            return "UPDATE " + Constants.investigationTableName + " SET Status=?, Assigned_To=?, Notes=? WHERE Request_Id=?";
        }
        if(operation.equals(String.valueOf(Constants.LawOperations.GET_JUDGE_REQUESTS)))
        {
            return "SELECT * FROM " + Constants.investigationTableName + " WHERE Status=?";
        }
        if(operation.equals(String.valueOf(Constants.LawOperations.PASS_VERDICT)))
        {
            return "UPDATE " + Constants.investigationTableName + " SET Status=?, Assigned_To=?, Notes=? WHERE Request_Id=?";
        }
        return null;
    }
    
}
