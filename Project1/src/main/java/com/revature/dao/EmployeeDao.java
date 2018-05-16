package com.revature.dao;

import com.revature.model.Employee;

import java.util.List;

public interface EmployeeDao {

    boolean updateEmployee(Employee employee);

    Employee getEmployee(int employeeId);

    Employee getEmployee(String username);

    List<Employee> getAllEmployee();

    boolean login(String username, String userpass);

//    boolean insertEmployee(Employee employee);

//    boolean deleteEmployee(int userId);
}
