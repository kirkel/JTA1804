package com.revature.dispatcher;

import com.revature.service.EmployeeService;
import com.revature.service.ReimbursementService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AjaxDispatcher {

    private AjaxDispatcher() {}

    public static Object process(HttpServletRequest request, HttpServletResponse response) {

        switch(request.getRequestURI()) {
            case "/getAllRequests.ajax": return ReimbursementService.getAllReimbursements();
            case "/getAllEmployees.ajax": return EmployeeService.getAllEmployees();
            default: return new String("Not implemented");
        }
    }

}
