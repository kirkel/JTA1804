package com.revature.application;

import com.revature.model.Employee;
import com.revature.model.Reimbursement;
import com.revature.service.EmployeeService;
import com.revature.service.ReimbursementService;

import java.util.ArrayList;
import java.util.List;

public class ERSApp {
    public static void main(String[] args) {
//        Employee employee = new Employee();
//        List<Employee> employees = new ArrayList<>();
//        employee = EmployeeService.getEmployee(231);
//        employee = EmployeeService.getEmployee("kirk");
//        employees = EmployeeService.getAllEmployees();
//        System.out.println(employee.toString());
//        for (Employee e: employees
//             ) {
//            System.out.println(e.toString());
//        }
//        System.out.println(EmployeeService.login("kirk", "kirk13"));

//        List<Reimbursement> reimbursements = new ArrayList<>();
//        reimbursements = ReimbursementService.getAllResolved();
//        for (Reimbursement r: reimbursements) {
//            System.out.println(r.toString());
//        }

//        System.out.println(ReimbursementService.approveReimbursements(47, 1, "Approved by Kirk L."));
//        System.out.println(ReimbursementService.denyReimbursements(64,1,"Denied by Kirk L."));
//        Reimbursement rem = new Reimbursement();
//        rem.setRequestorId(10);
//        rem.setReimbursementAmount(100.77);
//        rem.setCategory("food");
//        rem.setSubmitComment("I bough party food for everyone.");
//        System.out.println(ReimbursementService.insertReimbursement(rem));

        System.out.println(EmployeeService.login("kirk", "kirk123"));




    }
}
