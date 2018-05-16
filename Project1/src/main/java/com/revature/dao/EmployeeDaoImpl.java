package com.revature.dao;

import static com.revature.util.ERSLogger.logger;

import com.revature.model.Employee;
import com.revature.service.EmployeeService;
import com.revature.util.ConnectionUtil;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

//    @Override
//    public boolean insertEmployee(Employee employee) {
//        int index = 0;
//        try (Connection conn = ConnectionUtil.getConnection()) {
//            // Check if user exists. If so return false.
//            if (EmployeeService.getEmployee(employee.getUsername()) != null) {
//                return false;
//            } else {
//                CallableStatement stmt = conn.prepareCall("{CALL insertEmployee(?,?,?,?)}");
//                stmt.setString(++index, employee.getUsername());
//                stmt.setString(++index, employee.getUserpass());
//                stmt.setString(++index, employee.getFirstName());
//                stmt.setString(++index, employee.getLastName());
//                return stmt.executeUpdate() > 0;
//            }
//        } catch (SQLException sqle) {
//            System.err.println(sqle.getMessage());
//            System.err.println("SQL State: " + sqle.getSQLState());
//            System.err.println("Error Code: " + sqle.getErrorCode());
//        }
//        return false;
//    }

    @Override
    public boolean updateEmployee(Employee employee) {
        int index = 0;
        try (Connection conn = ConnectionUtil.getConnection()) {
            // Check if doesn't exists. If so return false.
            if (EmployeeService.getEmployee(employee.getUsername()) == null) {
                return false;
            } else {
                CallableStatement stmt = conn.prepareCall("{CALL updateEmployee(?,?,?,?,?)}");
                stmt.setInt(++index, employee.geteId());
                stmt.setString(++index, employee.getUsername());
                stmt.setString(++index, employee.getFirstName());
                stmt.setString(++index, employee.getLastName());
                stmt.setString(++index, employee.getUserpass());
                int rowsAffected = stmt.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
            System.err.println("SQL State: " + sqle.getSQLState());
            System.err.println("Error Code: " + sqle.getErrorCode());
        }
        return false;
    }

    @Override
    public Employee getEmployee(int eId) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            Employee employee = new Employee();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM EMPLOYEE WHERE EID = " + eId);
            ResultSet rs = stmt.executeQuery();
            if (rs.wasNull()) {
                return null;
            } else if (rs.next()) {
                employee.seteId(rs.getInt("eId"));
                employee.setUsername(rs.getString("username"));
                employee.setUserpass(rs.getString("userpass"));
                employee.setFirstName(rs.getString("firstName"));
                employee.setLastName(rs.getString("lastName"));
                employee.setRole(rs.getString("role"));
            }
            logger.info("Retrieved full data for eId: " + eId);
            return employee;
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
            System.err.println("SQL State: " + sqle.getSQLState());
            System.err.println("Error Code: " + sqle.getErrorCode());
            logger.error(sqle.getMessage() + " - SQL State: " + sqle.getSQLState() + " - Error Code: " + sqle.getErrorCode());
        }
        logger.warn("Data not found for eId: " + eId);
        return null;
    }

    @Override
    public Employee getEmployee(String username) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            Employee employee = new Employee();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Employee WHERE USERNAME = '" + username + "'");
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                employee.seteId(rs.getInt("eId"));
                employee.setUsername(rs.getString("username"));
                employee.setUserpass(rs.getString("userpass"));
                employee.setFirstName(rs.getString("firstName"));
                employee.setLastName(rs.getString("lastName"));
                employee.setRole(rs.getString("role"));
            }
            logger.info("Retrieved full data of username: " + username);
            return employee;
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
            System.err.println("SQL State: " + sqle.getSQLState());
            System.err.println("Error Code: " + sqle.getErrorCode());
        }
        logger.info("Data not found for username: " + username);
        return null;
    }

    @Override
    public List<Employee> getAllEmployee() {
        try (Connection conn = ConnectionUtil.getConnection()) {
            List<Employee> employees = new ArrayList<>();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM EMPLOYEE ORDER BY eId");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                employees.add(new Employee(rs.getInt("eId"),rs.getString("username"), rs.getString("userpass"),rs.getString("firstName"),rs.getString("lastName"),rs.getString("role")));
            }
            logger.info("All employee data retrieved.");
            return employees;

        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
            System.err.println("SQL State: " + sqle.getSQLState());
            System.err.println("Error Code: " + sqle.getErrorCode());
            logger.error(sqle.getMessage() + " - SQL State: " + sqle.getSQLState() + " - Error Code: " + sqle.getErrorCode());
        }
        return null;
    }

    @Override
    public boolean login(String username, String userpass) {
        int index = 0;
        try (Connection conn = ConnectionUtil.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT count(eId) as match FROM EMPLOYEE WHERE username ='" + username + "' AND userpass = GET_USER_HASH('" + username + "','" + userpass + "')");
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                if (rs.getInt("match") == 1) {
                    logger.info("Successful login of username: " + username);
                    return true;
                }
            }

        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
            System.err.println("SQL State: " + sqle.getSQLState());
            System.err.println("Error Code: " + sqle.getErrorCode());
            logger.error(sqle.getMessage() + " - SQL State: " + sqle.getSQLState() + " - Error Code: " + sqle.getErrorCode());
        }
        logger.info("Failed login of username: " + username);
        return false;
    }
}
