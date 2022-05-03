/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

/**
 *
 * @author sagar
 */
public class MedicalTestRequest {
    
    public String Request_Id;
    public String Test_Id;
    public String Victim_Email;
    public String Department;
    public String Assigned_To;
    public String Status;
    public String Notes;

    public String getRequest_Id() {
        return Request_Id;
    }

    public void setRequest_Id(String Request_Id) {
        this.Request_Id = Request_Id;
    }

    public String getTest_Id() {
        return Test_Id;
    }

    public void setTest_Id(String Test_Id) {
        this.Test_Id = Test_Id;
    }

    public String getVictim_Email() {
        return Victim_Email;
    }

    public void setVictim_Email(String Victim_Email) {
        this.Victim_Email = Victim_Email;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String Department) {
        this.Department = Department;
    }

    public String getAssigned_To() {
        return Assigned_To;
    }

    public void setAssigned_To(String Assigned_To) {
        this.Assigned_To = Assigned_To;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String Notes) {
        this.Notes = Notes;
    }
    
    
    
}
