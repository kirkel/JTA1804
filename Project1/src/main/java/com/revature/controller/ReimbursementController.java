package com.revature.controller;

import com.revature.model.Reimbursement;
import com.revature.service.ReimbursementService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReimbursementController {

    private ReimbursementController() {
    }

    public static String myReimbursement(HttpServletRequest request, HttpServletResponse response) {
        return "/MyReimbursement.jsp";
    }

    public static String manageReimbursement(HttpServletRequest request, HttpServletResponse response) {
        return "/ManageReimbursement.jsp";
    }

    public static String submitReimbursement(HttpServletRequest request, HttpServletResponse response) {
        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setRequesterId(Integer.parseInt(request.getParameter("requester_id")));
        reimbursement.setCategory(request.getParameter("requestCategory"));
        reimbursement.setReimbursementAmount(Double.parseDouble(request.getParameter("reimbursementAmount")));
        reimbursement.setSubmitComment(request.getParameter("comment"));
        ReimbursementService.insertReimbursement(reimbursement);
        return "/MyReimbursement.jsp";
    }

    public static String resolveReimbursement(HttpServletRequest request, HttpServletResponse response) {
        if (request.getParameter("decisionSelect").equals("accept")) {
            ReimbursementService.acceptReimbursement(Integer.parseInt(request.getParameter("rId")), Integer.parseInt(request.getParameter("requester_id")), request.getParameter("deciderComment"));
        } else {
            ReimbursementService.denyReimbursement(Integer.parseInt(request.getParameter("rId")), Integer.parseInt(request.getParameter("requester_id")), request.getParameter("deciderComment"));
        }
        return "/ManageReimbursement.jsp";
    }


}
