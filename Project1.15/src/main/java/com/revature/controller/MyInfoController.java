package com.revature.controller;

import static com.revature.util.ERSLogger.logger;

import com.revature.model.Employee;
import com.revature.service.EmployeeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInfoController {

    private MyInfoController() {}

//    public static String home(HttpServletRequest request, HttpServletResponse response) {
//
//        return "/home.jsp";
//    }
//
    public static String myInfo(HttpServletRequest request, HttpServletResponse response) {
        logger.info("Info was accessed!");
        return "/MyInfo.jsp";
    }
//
//    public static String request(HttpServletRequest request, HttpServletResponse response) {
//        return "/Project_1_requests.jsp";
//    }

    public static String updateInfo(HttpServletRequest request, HttpServletResponse response) {
        Employee employee = (Employee) request.getSession().getAttribute("authorizedEmployee");

        employee.setUsername(request.getParameter("update_username"));
        employee.setFirstName(request.getParameter("update_firstname"));
        employee.setLastName(request.getParameter("update_lastname"));
        employee.setUserpass(request.getParameter("update_userpass"));

        EmployeeService.updateEmployee(employee);
        logger.info("Updated info for username: " + employee.getUsername());

        request.getSession().setAttribute("authorizedEmployee", employee);

        return "/myInfo.do";
    }
}
