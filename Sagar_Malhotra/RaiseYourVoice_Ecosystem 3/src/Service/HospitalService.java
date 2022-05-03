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
public class HospitalService {
    
    //ArrayList<MedicalRequest> medicalRequests = new ArrayList<>();
    
    public ArrayList<MedicalRequest> getAllUnallocatedMedicalRequests()
    {
        ArrayList<MedicalRequest> unallocatedMedicalRequests = getUnallocatedMedicalRequests();
        ArrayList<MedicalRequest> unallocatedTestRequests = getUnallocatedTestRequests();
        ArrayList<MedicalRequest> allUnallocatedMedicalRequests = new ArrayList<>();
        allUnallocatedMedicalRequests.addAll(unallocatedMedicalRequests);
        allUnallocatedMedicalRequests.addAll(unallocatedTestRequests);
        return allUnallocatedMedicalRequests;
    }
    public ArrayList<MedicalRequest> getUnallocatedMedicalRequests()
    {
        ArrayList<MedicalRequest> medicalRequests = new ArrayList<>();
        DBConnection DBcon = new DBConnection();
        System.out.println("-------------Logging In-------------");
        Connection con= DBcon.getDbcon();
        
        String query = prepareQuery(String.valueOf(Constants.CommonOperations.GET_UNALLOCATED_REQUESTS), "", "");
        if(query.isBlank() || query.isEmpty())
            return null;
        
        try{
            PreparedStatement s = con.prepareStatement(query);
            s.setString(1, String.valueOf(Constants.Status.ALLOCATED_TO_HOSPITAL));
            System.out.println("-------------Fetching unallocated requests from " + Constants.medicalTableName + "------------");
            ResultSet r = s.executeQuery();
            System.out.println("-------------Query Executed------------");
            if(r==null)
            {
                JOptionPane.showMessageDialog( null, "Some error occured. Data fetch unsucccessfull. Please try after sometime.");
            }
            
            while(r.next())
            {
                MedicalRequest medicalRequest = new MedicalRequest();
                medicalRequest.setRequest_Id((!r.getString("Request_Id").isBlank() || r.getString("Request_Id").isEmpty()) ? 
                        r.getString("Request_Id") : null);
                medicalRequest.setVictim_email((!r.getString("Victim_email").isBlank() || r.getString("Victim_email").isEmpty()) ? 
                        r.getString("Victim_email") : null);
                medicalRequest.setProblem_Description((r.getString("Problem_Description").isBlank() || r.getString("Problem_Description").isEmpty()) ? 
                        r.getString("Problem_Description") : null);
                medicalRequest.setStatus((r.getString("Status").isBlank() || r.getString("Status").isEmpty()) ?
                        r.getString("Status") : null);
                
                if(!medicalRequest.getRequest_Id().isEmpty() || !medicalRequest.getRequest_Id().isBlank())
                    medicalRequests.add(medicalRequest);
            }
            s.close();
            con.close();
            return medicalRequests;
        }
        catch (SQLException e1)
        {
            JOptionPane.showMessageDialog( null, "Some error occured. Data fetch unsucccessfull. Please try after sometime.");
        }
        return null;
    }
    
    private ArrayList<MedicalRequest> getUnallocatedTestRequests() {
        ArrayList<MedicalRequest> medicalRequests = new ArrayList<>();
        
        DBConnection DBcon = new DBConnection();
        System.out.println("-------------Logging In-------------");
        Connection con= DBcon.getDbcon();
        
        String query = prepareQuery(String.valueOf(Constants.CommonOperations.GET_UNALLOCATED_TEST_REQUESTS), "", "");
        if(query.isBlank() || query.isEmpty())
            return null;
        
        try{
            PreparedStatement s = con.prepareStatement(query);
            s.setString(1, String.valueOf(Constants.Status.ALLOCATED_TO_HOSPITAL));
            System.out.println("-------------Fetching unallocated requests from " + Constants.investigationTableName + "------------");
            ResultSet r = s.executeQuery();
            System.out.println("-------------Query Executed------------");
            if(r==null)
            {
                JOptionPane.showMessageDialog( null, "Some error occured. Data fetch unsucccessfull. Please try after sometime.");
            }
            
            while(r.next())
            {
                MedicalRequest medicalRequest = new MedicalRequest();
                medicalRequest.setRequest_Id((!r.getString("Request_Id").isBlank() || r.getString("Request_Id").isEmpty()) ? 
                        r.getString("Request_Id") : null);
                medicalRequest.setVictim_email((!r.getString("Victim_email").isBlank() || r.getString("Victim_email").isEmpty()) ? 
                        r.getString("Victim_email") : null);
                medicalRequest.setProblem_Description((r.getString("Crime_Description").isBlank() || r.getString("Crime_Description").isEmpty()) ? 
                        r.getString("Crime_Description") : null);
                medicalRequest.setStatus((r.getString("Status").isBlank() || r.getString("Status").isEmpty()) ?
                        r.getString("Status") : null);
                
                if(!medicalRequest.getRequest_Id().isEmpty() || !medicalRequest.getRequest_Id().isBlank())
                    medicalRequests.add(medicalRequest);
            }
            s.close();
            con.close();
            return medicalRequests;
        }
        catch (SQLException e1)
        {
            JOptionPane.showMessageDialog( null, "Some error occured. Data fetch unsucccessfull. Please try after sometime.");
        }
        return null;
    }
    
    public ArrayList<MedicalRequest> getCounsellingMedicalRequests(String email)
    {
        ArrayList<MedicalRequest> medicalRequests = new ArrayList<>();
        DBConnection DBcon = new DBConnection();
        System.out.println("-------------Logging In-------------");
        Connection con= DBcon.getDbcon();
        
        String query = prepareQuery(String.valueOf(Constants.HospitalOperations.GET_COUNSELLING_REQUESTS), "", "");
        if(query.isBlank() || query.isEmpty())
            return null;
        
        try{
            PreparedStatement s = con.prepareStatement(query);
            s.setString(1, String.valueOf(Constants.Status.ASSIGNED_TO_COUNSELLOR));
            if(!email.isBlank() || !email.isEmpty())
                s.setString(2, email);
            else
                s.setString(2, "");
            System.out.println("-------------Fetching counselling requests from " + Constants.medicalTableName + "------------");
            ResultSet r = s.executeQuery();
            System.out.println("-------------Query Executed------------");
            if(r==null)
            {
                JOptionPane.showMessageDialog( null, "Some error occured. Data fetch unsucccessfull. Please try after sometime.");
            }
            
            while(r.next())
            {
                MedicalRequest medicalRequest = new MedicalRequest();
                 medicalRequest.setRequest_Id((!r.getString("Request_Id").isBlank() || r.getString("Request_Id").isEmpty()) ? 
                        r.getString("Request_Id") : null);
                medicalRequest.setVictim_email((!r.getString("Victim_email").isBlank() || r.getString("Victim_email").isEmpty()) ? 
                        r.getString("Victim_email") : null);
                medicalRequest.setProblem_Description((r.getString("Problem_Description").isBlank() || r.getString("Problem_Description").isEmpty()) ? 
                        r.getString("Problem_Description") : null);
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
    
    public ArrayList<MedicalRequest> getTestMedicalRequests(String email)
    {
        ArrayList<MedicalRequest> medicalRequests = new ArrayList<>();
        DBConnection DBcon = new DBConnection();
        System.out.println("-------------Logging In-------------");
        Connection con= DBcon.getDbcon();
        
        String query = prepareQuery(String.valueOf(Constants.HospitalOperations.GET_TEST_REQUESTS), "", "");
        
        if(query.isBlank() || query.isEmpty())
            return null;
        
        try{
            PreparedStatement s = con.prepareStatement(query);
            s.setString(1,String.valueOf(Constants.Status.ASSIGNED_TO_TESTER));
            s.setString(2, String.valueOf(Constants.Status.TESTING_IN_PROGRESS));
            if(!email.isBlank() || !email.isEmpty())
                s.setString(3, email);
            else
                s.setString(3, "");
            System.out.println("-------------Fetching testing requests from " + Constants.medicalTestsTableName + "------------");
            ResultSet r = s.executeQuery();
            System.out.println("-------------Query Executed------------");
            if(r==null)
            {
                JOptionPane.showMessageDialog( null, "Some error occured. Data fetch unsucccessfull. Please try after sometime.");
            }
            
            while(r.next())
            {
                MedicalRequest medicalRequest = new MedicalRequest();
                medicalRequest.setRequest_Id((!r.getString("Request_Id").isBlank() || r.getString("Request_Id").isEmpty()) ? 
                        r.getString("Request_Id") : null);
                medicalRequest.setVictim_email((!r.getString("Victim_email").isBlank() || r.getString("Victim_email").isEmpty()) ? 
                        r.getString("Victim_email") : null);
                medicalRequest.setProblem_Description((r.getString("Crime_Description").isBlank() || r.getString("Crime_Description").isEmpty()) ? 
                        r.getString("Crime_Description") : null);
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
    
    public ArrayList<MedicalRequest> getTestSampleMedicalRequests(String email)
    {
        ArrayList<MedicalRequest> medicalRequests = new ArrayList<>();
        DBConnection DBcon = new DBConnection();
        System.out.println("-------------Logging In-------------");
        Connection con= DBcon.getDbcon();
        
        String query = prepareQuery(String.valueOf(Constants.HospitalOperations.GET_TEST_REQUESTS), "", "");
        
        if(query.isBlank() || query.isEmpty())
            return null;
        
        try{
            PreparedStatement s = con.prepareStatement(query);
            s.setString(1,String.valueOf(Constants.Status.ASSIGNED_TO_TESTER));
            s.setString(2, "");
            if(!email.isBlank() || !email.isEmpty())
                s.setString(3, email);
            else
                s.setString(3, "");
            System.out.println("-------------Fetching testing requests from " + Constants.medicalTestsTableName + "------------");
            ResultSet r = s.executeQuery();
            System.out.println("-------------Query Executed------------");
            if(r==null)
            {
                JOptionPane.showMessageDialog( null, "Some error occured. Data fetch unsucccessfull. Please try after sometime.");
            }
            
            while(r.next())
            {
                MedicalRequest medicalRequest = new MedicalRequest();
                medicalRequest.setRequest_Id((!r.getString("Request_Id").isBlank() || r.getString("Request_Id").isEmpty()) ? 
                        r.getString("Request_Id") : null);
                medicalRequest.setVictim_email((!r.getString("Victim_email").isBlank() || r.getString("Victim_email").isEmpty()) ? 
                        r.getString("Victim_email") : null);
                medicalRequest.setProblem_Description((r.getString("Crime_Description").isBlank() || r.getString("Crime_Description").isEmpty()) ? 
                        r.getString("Crime_Description") : null);
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
    
    
    public ArrayList<MedicalRequest> getTestAssistantMedicalRequests(String email)
    {
        ArrayList<MedicalRequest> medicalRequests = new ArrayList<>();
        DBConnection DBcon = new DBConnection();
        System.out.println("-------------Logging In-------------");
        Connection con= DBcon.getDbcon();
        
        String query = prepareQuery(String.valueOf(Constants.HospitalOperations.GET_TEST_REQUESTS), "", "");
        
        if(query.isBlank() || query.isEmpty())
            return null;
        
        try{
            PreparedStatement s = con.prepareStatement(query);
            s.setString(1,String.valueOf(Constants.Status.TESTING_IN_PROGRESS));
            s.setString(2, "");
            if(!email.isBlank() || !email.isEmpty())
                s.setString(3, email);
            else
                s.setString(3, "");
            System.out.println("-------------Fetching testing requests from " + Constants.medicalTestsTableName + "------------");
            ResultSet r = s.executeQuery();
            System.out.println("-------------Query Executed------------");
            if(r==null)
            {
                JOptionPane.showMessageDialog( null, "Some error occured. Data fetch unsucccessfull. Please try after sometime.");
            }
            
            while(r.next())
            {
                MedicalRequest medicalRequest = new MedicalRequest();
                medicalRequest.setRequest_Id((!r.getString("Request_Id").isBlank() || r.getString("Request_Id").isEmpty()) ? 
                        r.getString("Request_Id") : null);
                medicalRequest.setVictim_email((!r.getString("Victim_email").isBlank() || r.getString("Victim_email").isEmpty()) ? 
                        r.getString("Victim_email") : null);
                medicalRequest.setProblem_Description((r.getString("Crime_Description").isBlank() || r.getString("Crime_Description").isEmpty()) ? 
                        r.getString("Crime_Description") : null);
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
    
    public Boolean assignRequestToCounsellingDepartment(String requestId)
    {
        if(requestId==null)
            return null;
        
        DBConnection DBcon = new DBConnection();
        System.out.println("-------------Logging In-------------");
        Connection con= DBcon.getDbcon();
        
        //check is staff is available 
        String employeeEmail = getCounsellingStaff();
        if(employeeEmail == null || employeeEmail.isBlank() || employeeEmail.isEmpty())
        {
            JOptionPane.showMessageDialog( null, "Counselling Staff unavailable. Please try after sometime.");
            return null;
        }
        //update status
        String query = prepareQuery(String.valueOf(Constants.HospitalOperations.ASSIGN_TO_COUNSELLING), "", "");
        String updateStaffStatus = prepareQuery(String.valueOf(Constants.HospitalOperations.ASSIGN_STAFF), employeeEmail, "Counsellor");
        if(query.equals(null) || query.isBlank() || query.isEmpty())
            return null;
        try{
            PreparedStatement s = con.prepareStatement(query);
            PreparedStatement s1 = con.prepareStatement(updateStaffStatus);
            s.setString(1, String.valueOf(Constants.Status.ASSIGNED_TO_COUNSELLOR));
            s.setString(2, employeeEmail);
            s.setString(3,requestId);
            s1.setString(1, String.valueOf(Constants.StaffStatus.WORKING));
            s1.setString(2, employeeEmail);
            System.out.println("-------------Updating Request Status in " + Constants.medicalTableName + "------------");
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
    
    private String getCounsellingStaff()
    {
        DBConnection DBcon = new DBConnection();
        System.out.println("-------------Logging In-------------");
        Connection con= DBcon.getDbcon();
        
        String query = prepareQuery(String.valueOf(Constants.HospitalOperations.SELECT_COUNSELLING_STAFF), "", "");
        
        if(query.equals(null) || query.isBlank() || query.isEmpty())
            return null;
        try{
            PreparedStatement s = con.prepareStatement(query);
          //  s.setString(1, String.valueOf(Constants.StaffStatus.WORKING));
            s.setString(1, String.valueOf(Constants.Roles.Counselor));
            System.out.println("-------------Checking for counselling staff " + Constants.staffTableName + "------------");
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
       private String getSampleCollectorStaff()
    {
        DBConnection DBcon = new DBConnection();
        System.out.println("-------------Logging In-------------");
        Connection con= DBcon.getDbcon();
        
        String query = prepareQuery(String.valueOf(Constants.HospitalOperations.SELECT_COUNSELLING_STAFF), "", "");
        
        if(query.equals(null) || query.isBlank() || query.isEmpty())
            return null;
        try{
            PreparedStatement s = con.prepareStatement(query);
          //  s.setString(1, String.valueOf(Constants.StaffStatus.WORKING));
            s.setString(1, String.valueOf(Constants.Roles.Collector));
            
            System.out.println("-------------Checking for sample collector " + Constants.staffTableName + "------------");
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
    
       
       
       
       
    
    public Boolean assignRequestToTestDepartment(String requestId)
    {
        if(requestId==null)
            return null;
        
        DBConnection DBcon = new DBConnection();
        System.out.println("-------------Logging In-------------");
        Connection con= DBcon.getDbcon();
        
        //check is staff is available 
         String employeeEmail = getSampleCollectorStaff();
        if(employeeEmail == null || employeeEmail.isBlank() || employeeEmail.isEmpty())
        {
            JOptionPane.showMessageDialog( null, "Sample collector unavailable. Please try after sometime.");
            return null;
        }
        //update status
        String query = prepareQuery(String.valueOf(Constants.HospitalOperations.ASSIGN_TO_TEST), "", "");
        String updateStaffStatus = prepareQuery(String.valueOf(Constants.HospitalOperations.ASSIGN_STAFF), employeeEmail, "Collector");
        if(query.equals(null) || query.isBlank() || query.isEmpty())
            return null;
        try{
            PreparedStatement s = con.prepareStatement(query);
            PreparedStatement s1 = con.prepareStatement(updateStaffStatus);
            s.setString(1,String.valueOf(Constants.Status.ASSIGNED_TO_TESTER));
            s.setString(2,employeeEmail);
            s.setString(3,requestId);
            s1.setString(1, String.valueOf(Constants.StaffStatus.WORKING));
            s1.setString(2, employeeEmail);
            System.out.println("-------------Updating Request Status in " + Constants.medicalTableName + "------------");
            Integer r = s.executeUpdate();
            Integer r1 = s1.executeUpdate();
            System.out.println("-------------Query Executed------------");
           
            
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
    
    private String getAssistantStaff()
    {
        DBConnection DBcon = new DBConnection();
        System.out.println("-------------Logging In-------------");
        Connection con= DBcon.getDbcon();
        
        String query = prepareQuery(String.valueOf(Constants.HospitalOperations.SELECT_COUNSELLING_STAFF), "", "");
        
        if(query.equals(null) || query.isBlank() || query.isEmpty())
            return null;
        try{
            PreparedStatement s = con.prepareStatement(query);
          //  s.setString(1, String.valueOf(Constants.StaffStatus.WORKING));
            s.setString(1, String.valueOf(Constants.Roles.Assistant));
            System.out.println("-------------Checking for Assistant " + Constants.staffTableName + "------------");
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
 
    public Boolean assignRequestToAssistant(String requestId, String email)
    {
        if(requestId==null)
            return null;
        
        DBConnection DBcon = new DBConnection();
        System.out.println("-------------Logging In-------------");
        Connection con= DBcon.getDbcon();
        
        //check is staff is available 
        String employeeEmail = getAssistantStaff();
        if(employeeEmail == null || employeeEmail.isBlank() || employeeEmail.isEmpty())
        {
            JOptionPane.showMessageDialog( null, "Assistant unavailable. Please try after sometime.");
            return null;
        }
        //update status
        String query = prepareQuery(String.valueOf(Constants.HospitalOperations.ASSIGN_TO_TEST), "", "");
        String updateStaffStatus = prepareQuery(String.valueOf(Constants.HospitalOperations.ASSIGN_STAFF), employeeEmail, "Assistant");
        String relieveStaff = prepareQuery(String.valueOf(Constants.HospitalOperations.RELIEVE_STAFF), "", "");
        if(query.equals(null) || query.isBlank() || query.isEmpty())
            return null;
        try{
            PreparedStatement s = con.prepareStatement(query);
            PreparedStatement s1 = con.prepareStatement(updateStaffStatus);
            PreparedStatement s2 = con.prepareStatement(relieveStaff);
            
            s.setString(1,String.valueOf(Constants.Status.TESTING_IN_PROGRESS));
            s.setString(2,employeeEmail);
            s.setString(3,requestId);
            s1.setString(1, String.valueOf(Constants.StaffStatus.WORKING));
            s1.setString(2, employeeEmail);
            s2.setString(1, email);
            System.out.println("-------------Updating Request Status in " + Constants.medicalTestsTableName + "------------");
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
    
    public Boolean rejectCase(String requestId, String rejectReason)
    {
    
        DBConnection DBcon = new DBConnection();
        Connection con= DBcon.getDbcon();
        String query = prepareQuery(String.valueOf(Constants.CommonOperations.REJECT), "", "");
        if(query.isBlank() || query.isEmpty())
        {
            return null;
        }
        try{
            PreparedStatement s = con.prepareStatement(query);
            s.setString(1, rejectReason);
            s.setString(2,requestId);
            //System.out.println("-------------Updating Request Status in " + Constants.medicalTableName + "------------");
            Integer r = s.executeUpdate();
            //System.out.println("-------------Query Executed------------");
            if(r==null)
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
    
    public Boolean assignToInvestigationDepartment(String requestId, String testReport, String email)
    {
        if(requestId==null)
            return null;
        
        DBConnection DBcon = new DBConnection();
        Connection con= DBcon.getDbcon();
        String query = prepareQuery(String.valueOf(Constants.HospitalOperations.ASSIGN_TO_INVESTIGATION), "", "");
        String staffUpdateQuery = prepareQuery(String.valueOf(Constants.HospitalOperations.RELIEVE_STAFF), "", "");
        if(query.equals(null) || query.isBlank() || query.isEmpty())
            return null;
        try{
            PreparedStatement s = con.prepareStatement(query);
            PreparedStatement s1 = con.prepareStatement(staffUpdateQuery);
            s.setString(1, String.valueOf(Constants.Status.REPORT_SHARED));
            s.setString(2, testReport);
            s.setString(3,requestId);
            s1.setString(1, email);
            System.out.println("-------------Updating Request Status in " + Constants.medicalTestsTableName + "------------");
            Integer r = s.executeUpdate();
            Integer r1 = s1.executeUpdate();
            System.out.println("-------------Query Executed------------");
           
            if(r == 0|| r1 == 0)
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
    
    public Boolean closeCounsellingRequest(String requestId, String report,String email)
    {
        if(requestId == null)
            return null;
        
        DBConnection DBcon = new DBConnection();
        
        Connection con= DBcon.getDbcon();
        
        String statusUpdateQuery = prepareQuery(String.valueOf(Constants.HospitalOperations.CLOSE_COUNSELLING_REQUEST), "", "");
        String staffUpdateQuery = prepareQuery(String.valueOf(Constants.HospitalOperations.RELIEVE_STAFF), "", "");
        try{
            //update request status in medicalTable
            System.out.println(statusUpdateQuery);
            PreparedStatement s = con.prepareStatement(statusUpdateQuery);
            s.setString(1, String.valueOf(Constants.Status.COMPLETE));
            s.setString(2, report);
            s.setString(3,requestId);
           
            Integer r = s.executeUpdate();
            //System.out.println("medical updated");
            if(r==0)
                {
                JOptionPane.showMessageDialog( null, "Some error occured. Status update unsucccessfull. Please try after sometime.");
            }
            con.close();
            //return true;
        }
         catch (SQLException e1)
        {
            JOptionPane.showMessageDialog( null, "Some error occured. Status update unsucccessfull. Please try after sometime.");
        }
        
     
        Connection con1= DBcon.getDbcon();
        try{
            
            PreparedStatement s1 = con1.prepareStatement(staffUpdateQuery);
            //s1.setString(1, "Not Working");
            
                s1.setString(1, email);
           // Integer r1 = s1.executeUpdate();
           ResultSet rset=s1.executeQuery();
            //System.out.println("-------------Query Executed------------");
            if( !rset.next())
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
    private String prepareQuery(String operation, String role, String email)
    {
        if(operation.equals(String.valueOf(Constants.CommonOperations.GET_UNALLOCATED_REQUESTS)))
        {
            return "SELECT * FROM " + Constants.medicalTableName + " WHERE Status=?";
        }
        if(operation.equals(String.valueOf(Constants.CommonOperations.GET_UNALLOCATED_TEST_REQUESTS)))
        {
            return "SELECT * FROM " + Constants.investigationTableName + " WHERE Status=?";
        }
        if(operation.equals(String.valueOf(Constants.HospitalOperations.GET_COUNSELLING_REQUESTS)))
        {
            return "SELECT * FROM " + Constants.medicalTableName + " WHERE Status=? OR Assigned_To=?";
        }
        if(operation.equals(String.valueOf(Constants.HospitalOperations.GET_TEST_REQUESTS)))
        {
            return "SELECT * FROM " + Constants.investigationTableName + " WHERE Status=? OR Status=? OR Assigned_To=?";
        }
        if(operation.equals(String.valueOf(Constants.HospitalOperations.ASSIGN_TO_COUNSELLING)))
        {
            return "UPDATE " + Constants.medicalTableName + " SET Status=?, Assigned_To=? WHERE Request_Id=?";
        }
        if(operation.equals(String.valueOf(Constants.HospitalOperations.SELECT_COUNSELLING_STAFF)))
        {
            return "SELECT * FROM  " + Constants.staffTableName + 
                    " WHERE Working_Status is null AND role=? FETCH FIRST 1 ROW ONLY";
        }
        if(operation.equals(String.valueOf(Constants.HospitalOperations.ASSIGN_STAFF)))
        {
            return "UPDATE " + Constants.staffTableName + " SET Working_Status=? WHERE email=?" ;
        }
        if(operation.equals(String.valueOf(Constants.HospitalOperations.ASSIGN_TO_TEST)))
        {
            return "UPDATE " + Constants.investigationTableName + " SET Status= ?,Test_Assigne=? WHERE Request_Id=?";
        }
        if(operation.equals(String.valueOf(Constants.HospitalOperations.CLOSE_COUNSELLING_REQUEST)))
        {
            return "UPDATE " + Constants.medicalTableName + " SET Status=?, Notes=? WHERE Request_Id=?";
        }
        if(operation.equals(String.valueOf(Constants.HospitalOperations.RELIEVE_STAFF)))
        {
            return "UPDATE " + Constants.staffTableName + " SET Working_Status=NULL WHERE email=?";
        }
        if(operation.equals(String.valueOf(Constants.CommonOperations.REJECT)))
        {
            return "UPDATE " + Constants.medicalTableName + " SET Status=REJECTED, Notes=? WHERE Request_Id=?";
        }
        if(operation.equals(String.valueOf(Constants.HospitalOperations.ASSIGN_TO_INVESTIGATION)))
        {
            return "UPDATE " + Constants.investigationTableName + " SET Status=?, Notes=? WHERE Request_Id=?";
        }
        return null;
    }
}
