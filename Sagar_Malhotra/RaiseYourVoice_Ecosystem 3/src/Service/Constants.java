/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.util.HashMap;

/**
 *
 * @author shreyangiprasad
 */
public class Constants {
    
    //Table Names
    public static String unallocatedTableName = "unallocatedRequests";
    public static String investigationTableName = "Investigation_Request";
    public static String medicalTableName = "Medical_Request";
    public static String lawTableName = "lawRequests"; 
    public static String medicalTestsTableName = "Test";
    public static String staffTableName = "STAFF";
    
    //Operations
    enum CommonOperations { SELECT, REJECT, GET_UNALLOCATED_REQUESTS, 
    GET_ALLOCATED_REQUESTS, GET_UNALLOCATED_TEST_REQUESTS}
    enum AdminOperations { SELECT, REJECT, ASSIGN_TO_HOSPITAL, ASSIGN_TO_INVESTIGATION }
    
    enum InvestigationOperations { GET_INVESTIGATION_REQUESTS, 
    ASSIGN_TO_INVESTIGATION, ASSIGN_TO_MANAGER, ASSIGN_TO_TESTING, 
    SELECT_INVESTIGATION_STAFF, ASSIGN_STAFF, ASSIGN_TO_ADMIN, ASSIGN_TO_HOSPITAL }
    
    enum HospitalOperations { GET_UNALLOCATED_REQUESTS, GET_COUNSELLING_REQUESTS, 
    GET_TEST_REQUESTS, ASSIGN_TO_COUNSELLING, ASSIGN_TO_TEST, ASSIGN_TO_INVESTIGATION, 
    SELECT_COUNSELLING_STAFF, ASSIGN_STAFF,
    CLOSE_COUNSELLING_REQUEST, RELIEVE_STAFF, REJECT }
    
    enum LawOperations { GET_ALLOCATED_REQUESTS, PRESENT_CASE, GET_JUDGE_REQUESTS, 
    PASS_VERDICT
    
    }
    
    enum Status {
        UNALLOCATED, ALLOCATED_TO_HOSPITAL, ALLOCATED_TO_INVESTIGATION_MANAGEMENT, REJECTED, 
        ASSIGNED_TO_COUNSELLOR, COUNSELLING_IN_PROGRESS, COMPLETE, ASSIGNED_TO_INVESTIGATOR,
        INVESTIGATION_IN_PROGRESS, ASSIGNED_TO_TESTER, TESTING_IN_PROGRESS, TESTING_COMPLETE, 
        INVESTIGATION_COMPLETE, ASSIGNED_TO_LAWYER, CASE_PRESENTED, CASE_CLOSED, Submitted, 
        SHARED_WITH_MANAGEMENT, REPORT_SHARED
    }
    
    enum StaffStatus {
        WORKING, NOT_WORKING
    }
    
    enum Department {
        COUNSELLING_DEPARTMENT, INVESTIGATION_DEPARTMENT, MANAGEMENT, ADMINISTRATION,LAWYER_DEPARTMENT,JUDGE_DEPARTMENT,TEST_DEPARTMENT
    }
    
    enum Roles {
        Counselor, Investigator, Collector, Assistant,Admin, Lawyer, Judge
    }
}
