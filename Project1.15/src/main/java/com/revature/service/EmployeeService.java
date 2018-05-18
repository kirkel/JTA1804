package com.revature.service;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.model.Employee;

import java.util.List;

public class EmployeeService {

    private static EmployeeDao dao = new EmployeeDaoImpl();

    private EmployeeService() {
    }

    public static Employee getEmployee(int employeeId) {
        return dao.getEmployee(employeeId);
    }

    public static Employee getEmployee(String username){
        return dao.getEmployee(username);
    }

    public static List<Employee> getAllEmployees(){
        return dao.getAllEmployee();
    }

    public static boolean login(String username, String userpass){
        return dao.login(username,userpass);
    }

    public static boolean updateEmployee(Employee employee){
        return dao.updateEmployee(employee);
    }

}
