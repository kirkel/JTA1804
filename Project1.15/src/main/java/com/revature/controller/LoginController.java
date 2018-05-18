package com.revature.controller;

import static com.revature.util.ERSLogger.logger;

import com.revature.model.Employee;
import com.revature.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginController {

    private LoginController() {
    }

    public static String login(HttpServletRequest request, HttpServletResponse response) {

        String username = request.getParameter("loginUsername");
        String userpass = request.getParameter("loginUserpass");

        if (EmployeeService.login(username, userpass)) {

            Employee employee = EmployeeService.getEmployee(username);

            if (EmployeeService.getEmployee(username).getRole().equals("Financial Manager")) {

                request.getSession().setAttribute("authorizedEmployee", employee);
                logger.info("Session has been set for Financial Manager username: " + employee.getUsername());
                return "/FinancialManagerHome.jsp";

            } else {

                request.getSession().setAttribute("authorizedEmployee", employee);
                logger.info("Session has been set for Associate username: " + employee.getUsername());
                return "/AssociateHome.jsp";

            }
        }

        logger.warn("Failed login attempt.");
        return "/index.jsp";

    }

    public static String logout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("logging out");
        logger.info("Successful logout!");
        HttpSession session = request.getSession();
        session.invalidate();
        return "/index.jsp";
    }
}
