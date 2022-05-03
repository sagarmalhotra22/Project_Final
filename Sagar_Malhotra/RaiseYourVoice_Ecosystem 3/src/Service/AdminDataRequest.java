/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

/**
 *
 * @author shreyangiprasad
 */
public class AdminDataRequest {
    
    public String requestId;
    public String victimEmail;
    public String Department;
    public String Assigned_To;
    public String status;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getVictimEmail() {
        return victimEmail;
    }

    public void setVictimEmail(String victimEmail) {
        this.victimEmail = victimEmail;
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
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

 
    
}
