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
public class InvestigationService {
    
    ArrayList<InvestigationRequest> investigationRequests = new ArrayList<>();
    
    public ArrayList<InvestigationRequest> getUnallocatedMedicalRequests()
    {
        DBConnection DBcon = new DBConnection();
        System.out.println("-------------Fetching Investigation Request-------------");
        Connection con= DBcon.getDbcon();
        
        String query = prepareQuery(String.valueOf(Constants.CommonOperations.GET_UNALLOCATED_REQUESTS), "", "");
        if(query.isBlank() || query.isEmpty())
            return null;
        
        try{
            PreparedStatement s = con.prepareStatement(query);
            s.setString(1, String.valueOf(Constants.Status.ALLOCATED_TO_INVESTIGATION_MANAGEMENT));
            s.setString(2, String.valueOf(Constants.Status.SHARED_WITH_MANAGEMENT));
            System.out.println("-------------Fetching unallocated requests from " + Constants.investigationTableName + "------------");
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
    
    public ArrayList<InvestigationRequest> getInvestigationRequests(String email)
    {
        DBConnection DBcon = new DBConnection();
        System.out.println("-------------Logging In-------------");
        Connection con= DBcon.getDbcon();
        
        String query = prepareQuery(String.valueOf(Constants.InvestigationOperations.GET_INVESTIGATION_REQUESTS), "", "");
        if(query.isBlank() || query.isEmpty())
            return null;
        
        try{
            PreparedStatement s = con.prepareStatement(query);
            s.setString(1, String.valueOf(Constants.Status.ASSIGNED_TO_INVESTIGATOR));
            s.setString(2, String.valueOf(Constants.Status.REPORT_SHARED));
            if(!email.isBlank() || !email.isEmpty())
                s.setString(3, email);
            else
                s.setString(3, "");
            System.out.println("-------------Fetching investigation requests from " + Constants.investigationTableName + "------------");
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
    
    public Boolean assignRequestToInvestigationDepartment(String requestId)
    {
        if(requestId==null)
            return null;
        
        DBConnection DBcon = new DBConnection();
        System.out.println("-------------Logging In-------------");
        Connection con= DBcon.getDbcon();
        
        //check is staff is available 
        String employeeEmail = getInvestigationStaff();
        if(employeeEmail == null || employeeEmail.isBlank() || employeeEmail.isEmpty())
        {
            JOptionPane.showMessageDialog( null, "Investigator Staff unavailable. Please try after sometime.");
            return null;
        }
        //update status
        String query = prepareQuery(String.valueOf(Constants.InvestigationOperations.ASSIGN_TO_INVESTIGATION), "", "");
        String updateStaffStatus = prepareQuery(String.valueOf(Constants.InvestigationOperations.ASSIGN_STAFF), employeeEmail, "Counsellor");
        if(query.equals(null) || query.isBlank() || query.isEmpty())
            return null;
        try{
            PreparedStatement s = con.prepareStatement(query);
            PreparedStatement s1 = con.prepareStatement(updateStaffStatus);
            s.setString(1, String.valueOf(Constants.Status.ASSIGNED_TO_INVESTIGATOR));
            s.setString(2, employeeEmail);
            s.setString(3, requestId);
            s1.setString(1, String.valueOf(Constants.StaffStatus.WORKING));
            s1.setString(2, employeeEmail);
            System.out.println("-------------Updating Request Status in " + Constants.investigationTableName + "------------");
            Integer r = s.executeUpdate();
            Integer r1 = s1.executeUpdate();
            System.out.println("-------------Query Executed------------");
            if(r == 0 || r1 == 0)
            {
                JOptionPane.showMessageDialog( null, "Some error occured. Status update unsucccessfull. Please try after sometime.");
            }
            return true;
        }
        catch (SQLException e1)
        {
            JOptionPane.showMessageDialog( null, "Some error occured. Status update unsucccessfull. Please try after sometime.");
        }
        return null;
    }
    
    private String getInvestigationStaff()
    {
        DBConnection DBcon = new DBConnection();
        System.out.println("-------------Logging In-------------");
        Connection con= DBcon.getDbcon();
        
        String query = prepareQuery(String.valueOf(Constants.InvestigationOperations.SELECT_INVESTIGATION_STAFF), "", "");
        
        if(query.equals(null) || query.isBlank() || query.isEmpty())
            return null;
        try{
            PreparedStatement s = con.prepareStatement(query);
            s.setString(1, String.valueOf(Constants.Roles.Investigator));
            System.out.println("-------------Checking for Investigator staff " + Constants.staffTableName + "------------");
            ResultSet r = s.executeQuery();
            System.out.println("-------------Query Executed------------");
            if(r==null)
            {
                JOptionPane.showMessageDialog( null, "Some error occured. Staff check unsuccessfull. Please try after sometime.");
            }
            while(r.next())
            {
                return r.getString("email");
            }
            return null;
        }
        catch (SQLException e1)
        {
            JOptionPane.showMessageDialog( null, "Some error occured. Status update unsucccessfull. Please try after sometime.");
        }
        
        return null;
    }
     
    public Boolean assignRequestToAgencyManagementDepartment(String requestId, String email, String notes)
    {
        if(requestId==null)
            return null;
        
        DBConnection DBcon = new DBConnection();
        System.out.println("-------------Logging In-------------");
        Connection con= DBcon.getDbcon();
        
        //update status
        String query = prepareQuery(String.valueOf(Constants.InvestigationOperations.ASSIGN_TO_MANAGER), "", "");
        String updateStaffStatus = prepareQuery(String.valueOf(Constants.HospitalOperations.RELIEVE_STAFF), "", "");
        if(query.equals(null) || query.isBlank() || query.isEmpty())
            return null;
        try{
            PreparedStatement s = con.prepareStatement(query);
            PreparedStatement s1 = con.prepareStatement(updateStaffStatus);
            s.setString(1, String.valueOf(Constants.Status.SHARED_WITH_MANAGEMENT));
            s.setString(2, "");
            s.setString(3, notes);
            s.setString(4, requestId);
            s1.setString(1, email);
            System.out.println("-------------Updating Request Status in " + Constants.investigationTableName + "------------");
            Integer r = s.executeUpdate();
            Integer r1 = s1.executeUpdate();
            System.out.println("-------------Query Executed------------");
            if(r==0 || r1 == 0)
            {
                JOptionPane.showMessageDialog( null, "Some error occured. Status update unsucccessfull. Please try after sometime.");
            }
            return true;
        }
        catch (SQLException e1)
        {
            JOptionPane.showMessageDialog( null, "Some error occured. Status update unsucccessfull. Please try after sometime.");
        }
        return null;
    }
    
    public Boolean shareInvestigationReportWithRYV(String requestId)
    {
        if(requestId==null)
            return null;
        
        DBConnection DBcon = new DBConnection();
        System.out.println("-------------Logging In-------------");
        Connection con= DBcon.getDbcon();
        
        //update status
        String query = prepareQuery(String.valueOf(Constants.InvestigationOperations.ASSIGN_TO_ADMIN), "", "");
        
        if(query.equals(null) || query.isBlank() || query.isEmpty())
            return null;
        try{
            PreparedStatement s = con.prepareStatement(query);
            s.setString(1, String.valueOf(Constants.Status.INVESTIGATION_COMPLETE));
            s.setString(2, requestId);
            System.out.println("-------------Updating Request Status in " + Constants.investigationTableName + "------------");
            Integer r = s.executeUpdate();
            System.out.println("-------------Query Executed------------");
            if(r==0)
            {
                JOptionPane.showMessageDialog( null, "Some error occured. Status update unsucccessfull. Please try after sometime.");
            }
            return true;
        }
        catch (SQLException e1)
        {
            JOptionPane.showMessageDialog( null, "Some error occured. Status update unsucccessfull. Please try after sometime.");
        }
        return null;
    }
    
    public Boolean assignRequestToHospitalManagementDepartment(MedicalTestRequest medicalTestRequest)
    {
        if(medicalTestRequest.getRequest_Id()==null)
            return null;
        
        DBConnection DBcon = new DBConnection();
        System.out.println("-------------Logging In-------------");
        Connection con= DBcon.getDbcon();
        
        //update status
        String query = prepareQuery(String.valueOf(Constants.InvestigationOperations.ASSIGN_TO_HOSPITAL), "", "");
        if(query.equals(null) || query.isBlank() || query.isEmpty())
            return null;
        try{
            PreparedStatement s = con.prepareStatement(query);
            s.setString(1, String.valueOf(Constants.Status.ALLOCATED_TO_HOSPITAL));
            s.setString(2, medicalTestRequest.getRequest_Id());
            /*s.setString(1, medicalTestRequest.getRequest_Id());
            s.setString(2, medicalTestRequest.getVictim_Email());
            s.setString(3, String.valueOf(Constants.Department.HOSPITAL_MANAGEMENT));
            s.setString(4, "");
            s.setString(5, String.valueOf(Constants.Status.ALLOCATED_TO_HOSPITAL));
            s.setString(6, "");
            s.setString(7, "");
            s.setString(8, "");*/
            System.out.println("-------------Updating Request Status in " + Constants.investigationTableName + "------------");
            s.executeQuery();
            System.out.println("-------------Query Executed------------");
            s.close();
            con.close();
            return true;
        }
        catch (SQLException e1)
        {
            JOptionPane.showMessageDialog( null, "Some error occured. Status update unsucccessfull. Please try after sometime.");
        }
        return null;
    }
    
    
    private String prepareQuery(String operation, String role, String email)
    {
        if(operation.equals(String.valueOf(Constants.CommonOperations.GET_UNALLOCATED_REQUESTS)))
        {
            return "SELECT * FROM " + Constants.investigationTableName + " WHERE Status=? OR Status=?";
        }
        if(operation.equals(String.valueOf(Constants.InvestigationOperations.GET_INVESTIGATION_REQUESTS)))
        {
            return "SELECT * FROM " + Constants.investigationTableName + " WHERE Status=? OR Status=? OR Assigned_To=?";
        }
        if(operation.equals(String.valueOf(Constants.InvestigationOperations.ASSIGN_TO_INVESTIGATION)))
        {
            return "UPDATE " + Constants.investigationTableName + " SET Status=?, Assigned_to=? WHERE Request_Id=?";
        }
        if(operation.equals(String.valueOf(Constants.InvestigationOperations.ASSIGN_TO_MANAGER)))
        {
            return "UPDATE " + Constants.investigationTableName + " SET Status=?, Assigned_to=?, Notes=? WHERE Request_Id=?";
        }
        if(operation.equals(String.valueOf(Constants.InvestigationOperations.ASSIGN_TO_TESTING)))
        {
            return "UPDATE " + Constants.medicalTableName + "SET Status=? WHERE Request_Id=?";
        }
        if(operation.equals(String.valueOf(Constants.CommonOperations.REJECT)))
        {
            return "UPDATE " + Constants.investigationTableName + " SET Status=?, Notes=? WHERE Request_Id=?";
        }
        if(operation.equals(String.valueOf(Constants.InvestigationOperations.SELECT_INVESTIGATION_STAFF)))
        {
            return "SELECT * FROM  " + Constants.staffTableName + 
                    " WHERE Working_Status is null AND role=? FETCH FIRST 1 ROW ONLY";
        }
        if(operation.equals(String.valueOf(Constants.InvestigationOperations.ASSIGN_STAFF)))
        {
            return "UPDATE " + Constants.staffTableName + " SET Working_Status=? WHERE email=?" ;
        }
        if(operation.equals(String.valueOf(Constants.HospitalOperations.RELIEVE_STAFF)))
        {
            return "UPDATE " + Constants.staffTableName + " SET Working_Status=NULL WHERE email=?";
        }
        if(operation.equals(String.valueOf(Constants.InvestigationOperations.ASSIGN_TO_ADMIN)))
        {
            return "UPDATE " + Constants.investigationTableName + " SET Status=? WHERE Request_Id=?";
        }
        if(operation.equals(String.valueOf(Constants.InvestigationOperations.ASSIGN_TO_HOSPITAL)))
        {
            return "UPDATE " + Constants.investigationTableName + " SET Status=? WHERE Request_Id=?";
            //return "INSERT INTO " + Constants.medicalTestsTableName + "(REQUEST_ID,VICTIM_EMAIL,DEPARTMENT,ASSIGNED_TO,STATUS,NOTES,REQUEST_DATE,UPDATE_DATE) VALUES(?,?,?,?,?,?,?,?)";
        }
        return null;
    }
}
