package com.revature.dao;

import com.revature.model.Reimbursement;

import java.util.List;

public interface ReimbursementDao {

    boolean insertReimbursement(Reimbursement newReimbursement);

    boolean acceptReimbursement(int reimbursementId, int deciderId, String decisionComment);

    boolean denyReimbursement(int reimbursementId, int deciderId, String decisionComment);

    List<Reimbursement> getAllReimbursements();

    List<Reimbursement> getAllReimbursements(int employeeId);

    List<Reimbursement> getAllPending();

    List<Reimbursement> getAllPending(int employeeId);

    List<Reimbursement> getAllResolved();

    List<Reimbursement> getAllResolved(int employeeId);





}
