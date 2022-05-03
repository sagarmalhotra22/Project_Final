/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

/**
 *
 * @author sagar
 */
public class MedicalRequest {
    String Victim_email;
    String Problem_Description; 
    String Service;
    String Gender; 
    String Department;
    String Assigned_To;
    String Status;
    String Request_Id;
    String Notes;
    String Request_Date;
    String Update_Date;

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String Notes) {
        this.Notes = Notes;
    }

    public String getRequest_Date() {
        return Request_Date;
    }

    public void setRequest_Date(String Request_Date) {
        this.Request_Date = Request_Date;
    }

    public String getUpdate_Date() {
        return Update_Date;
    }

    public void setUpdate_Date(String Update_Date) {
        this.Update_Date = Update_Date;
    }

   

  

    public String getRequest_Id() {
        return Request_Id;
    }

    public void setRequest_Id(String Request_Id) {
        this.Request_Id = Request_Id;
    }

    public String getVictim_email() {
        return Victim_email;
    }

    public void setVictim_email(String Victim_email) {
        this.Victim_email = Victim_email;
    }

    public String getProblem_Description() {
        return Problem_Description;
    }

    public void setProblem_Description(String Problem_Description) {
        this.Problem_Description = Problem_Description;
    }

    public String getService() {
        return Service;
    }

    public void setService(String Service) {
        this.Service = Service;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
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
    
}
