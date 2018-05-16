package com.revature.dispatcher;

import com.revature.controller.LoginController;
import com.revature.controller.MyInfoController;
import com.revature.controller.ReimbursementController;
import com.revature.model.Reimbursement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MasterDispatcher {

    private MasterDispatcher() {
    }

    public static String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        switch (request.getRequestURI()) {
            case"/login.do":
                    return LoginController.login(request,response);
            case "/logout.do":
                return LoginController.logout(request,response);
            case "/myInfo.do":
                return MyInfoController.myInfo(request,response);
            case "/updateInfo.do":
                return MyInfoController.updateInfo(request,response);
            case "/myReimbursement.do":
                return ReimbursementController.myReimbursement(request,response);
            case "/submitReimbursement.do":
                return ReimbursementController.submitReimbursement(request,response);
            case "/manageReimbursement.do":
                return ReimbursementController.manageReimbursement(request,response);
            case "/resolveReimbursement.do":
                return ReimbursementController.resolveReimbursement(request,response);
            default:{
                System.out.println("404ed");
                return "404.jsp";
            }
        }
    }
}
