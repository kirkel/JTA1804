package com.revature.service;

import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.model.Reimbursement;

import java.util.List;

public class ReimbursementService {

    private static ReimbursementDao dao = new ReimbursementDaoImpl();

    private ReimbursementService() {
    }

    public static List<Reimbursement> getAllReimbursements() {
        return dao.getAllReimbursements();
    }

    public static List<Reimbursement> getAllReimbursements(int employeeId) {
        return dao.getAllReimbursements(employeeId);
    }

    public static List<Reimbursement> getAllPending() {
        return dao.getAllPending();
    }

    public static List<Reimbursement> getAllPending(int employeeId) {
        return dao.getAllPending(employeeId);
    }

    public static List<Reimbursement> getAllResolved() {
        return dao.getAllResolved();
    }

    public static List<Reimbursement> getAllResolved(int employeeId) {
        return dao.getAllResolved(employeeId);
    }

    public static boolean insertReimbursement(Reimbursement reimbursement) {
        return dao.insertReimbursement(reimbursement);
    }

    public static boolean acceptReimbursement(int reimbursementId, int deciderId, String decisionComment) {
        return dao.acceptReimbursement(reimbursementId, deciderId, decisionComment);
    }

    public static boolean denyReimbursement(int reimbursementId, int deciderId, String decisionComment) {
        return dao.denyReimbursement(reimbursementId, deciderId, decisionComment);
    }

    public static Reimbursement getReimbursement(int rid) {
        return dao.getReimbursement(rid);
    }


}
