package com.revature.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Reimbursement implements Serializable {

    private static final long serialVersionUID = 5773892470168472546L;
    private int rId;
    private int requesterId;
    private int resolverId;
    private double reimbursementAmount;
    private String category;
    private String status;
    private Date submitDate;
    private String submitComment;
    private Date resolveDate;
    private String resolveComment;

    public Reimbursement() {
    }

    public Reimbursement(int rId, int requesterId, int resolverId, double reimbursementAmount, String category, String status, Date submitDate, String submitComment, Date resolveDate, String resolveComment) {
        this.rId = rId;
        this.requesterId = requesterId;
        this.resolverId = resolverId;
        this.reimbursementAmount = reimbursementAmount;
        this.category = category;
        this.status = status;
        this.submitDate = submitDate;
        this.submitComment = submitComment;
        this.resolveDate = resolveDate;
        this.resolveComment = resolveComment;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getrId() {
        return rId;
    }

    public void setrId(int rId) {
        this.rId = rId;
    }

    public int getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(int requesterId) {
        this.requesterId = requesterId;
    }

    public int getResolverId() {
        return resolverId;
    }

    public void setResolverId(int resolverId) {
        this.resolverId = resolverId;
    }

    public double getReimbursementAmount() {
        return reimbursementAmount;
    }

    public void setReimbursementAmount(double reimbursementAmount) {
        this.reimbursementAmount = reimbursementAmount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public String getSubmitComment() {
        return submitComment;
    }

    public void setSubmitComment(String submitComment) {
        this.submitComment = submitComment;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }

    public String getResolveComment() {
        return resolveComment;
    }

    public void setResolveComment(String resolveComment) {
        this.resolveComment = resolveComment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reimbursement that = (Reimbursement) o;
        return rId == that.rId &&
                requesterId == that.requesterId &&
                resolverId == that.resolverId &&
                Double.compare(that.reimbursementAmount, reimbursementAmount) == 0 &&
                Objects.equals(category, that.category) &&
                Objects.equals(status, that.status) &&
                Objects.equals(submitDate, that.submitDate) &&
                Objects.equals(submitComment, that.submitComment) &&
                Objects.equals(resolveDate, that.resolveDate) &&
                Objects.equals(resolveComment, that.resolveComment);
    }

    @Override
    public int hashCode() {

        return Objects.hash(rId, requesterId, resolverId, reimbursementAmount, category, status, submitDate, submitComment, resolveDate, resolveComment);
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "rId=" + rId +
                ", requesterId=" + requesterId +
                ", resolverId=" + resolverId +
                ", reimbursementAmount=" + reimbursementAmount +
                ", category='" + category + '\'' +
                ", status='" + status + '\'' +
                ", submitDate=" + submitDate +
                ", submitComment='" + submitComment + '\'' +
                ", resolveDate=" + resolveDate +
                ", resolveComment='" + resolveComment + '\'' +
                '}';
    }
}
