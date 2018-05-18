package com.revature.dao;

import static com.revature.util.ERSLogger.logger;

import com.revature.model.Reimbursement;
import com.revature.util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReimbursementDaoImpl implements ReimbursementDao {

    @Override
    public boolean insertReimbursement(Reimbursement newReimbursement) {
        int index = 0;
        try (Connection conn = ConnectionUtil.getConnection()) {
            CallableStatement stmt = conn.prepareCall("{CALL insertReimbursement(?,?,?,?)}");
            stmt.setInt(++index, newReimbursement.getRequesterId());
            stmt.setDouble(++index, newReimbursement.getReimbursementAmount());
            stmt.setString(++index, newReimbursement.getCategory());
            stmt.setString(++index, newReimbursement.getSubmitComment());
            logger.info("EmployeeId: " + newReimbursement.getRequesterId() + " submitted a new reimbursement request.");
            return stmt.executeUpdate() > 0;
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
            System.err.println("SQL State: " + sqle.getSQLState());
            System.err.println("Error Code: " + sqle.getErrorCode());
        }
        return false;
    }

    @Override
    public boolean acceptReimbursement(int rId, int resolverId, String resolveComment) {
        int index = 0;
        try (Connection conn = ConnectionUtil.getConnection()) {
            CallableStatement stmt = conn.prepareCall("{CALL acceptReimbursement(?, ?, ?)}");
            stmt.setInt(++index, rId);
            stmt.setInt(++index, resolverId);
            stmt.setString(++index, resolveComment);
            logger.info("rId: " + rId + " was approved by FinancialManagerId: " + resolverId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
            System.err.println("SQL State: " + sqle.getSQLState());
            System.err.println("Error Code: " + sqle.getErrorCode());
        }
        return false;
    }

    @Override
    public boolean denyReimbursement(int rId, int resolverId, String resolveComment) {
        int index = 0;
        try (Connection conn = ConnectionUtil.getConnection()) {
            CallableStatement stmt = conn.prepareCall("{CALL denyReimbursement(?, ?, ?)}");
            stmt.setInt(++index, rId);
            stmt.setInt(++index, resolverId);
            stmt.setString(++index, resolveComment);
            logger.info("rId: " + rId + " was denied by FinancialManagerId: " + resolverId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
            System.err.println("SQL State: " + sqle.getSQLState());
            System.err.println("Error Code: " + sqle.getErrorCode());
        }
        return false;
    }

    @Override
    public List<Reimbursement> getAllReimbursements() {
        try (Connection conn = ConnectionUtil.getConnection()) {
            List<Reimbursement> reimbursements = new ArrayList<>();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM REIMBURSEMENT ORDER BY RID");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                reimbursements.add(new Reimbursement(rs.getInt("rId"), rs.getInt("requesterId"), rs.getInt("resolverId"), rs.getDouble("reimbursementAmount"), rs.getString("category"), rs.getString("status"), rs.getDate("submitDate"), rs.getString("submitComment"), rs.getDate("resolveDate"), rs.getString("resolveComment")));
            }
            logger.info("All reimbursement data retrieved.");
            return reimbursements;
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
            System.err.println("SQL State: " + sqle.getSQLState());
            System.err.println("Error Code: " + sqle.getErrorCode());
            logger.error(sqle.getMessage() + " - SQL State: " + sqle.getSQLState() + " - Error Code: " + sqle.getErrorCode());
        }
        return null;
    }

    @Override
    public List<Reimbursement> getAllReimbursements(int employeeId) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            List<Reimbursement> reimbursements = new ArrayList<>();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM REIMBURSEMENT WHERE REQUESTERID = " + employeeId + " ORDER BY RID");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                reimbursements.add(new Reimbursement(rs.getInt("rId"), rs.getInt("requesterId"), rs.getInt("resolverId"), rs.getDouble("reimbursementAmount"), rs.getString("category"), rs.getString("status"), rs.getDate("submitDate"), rs.getString("submitComment"), rs.getDate("resolveDate"), rs.getString("resolveComment")));
            }
            logger.info("All reimbursement data retrieved for employeeId: " + employeeId);
            return reimbursements;
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
            System.err.println("SQL State: " + sqle.getSQLState());
            System.err.println("Error Code: " + sqle.getErrorCode());
            logger.error(sqle.getMessage() + " - SQL State: " + sqle.getSQLState() + " - Error Code: " + sqle.getErrorCode());
        }
        return null;
    }

    @Override
    public List<Reimbursement> getAllPending() {
        try (Connection conn = ConnectionUtil.getConnection()) {
            List<Reimbursement> reimbursements = new ArrayList<>();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM REIMBURSEMENT WHERE status = 'pending' ORDER BY RID");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                reimbursements.add(new Reimbursement(rs.getInt("rId"), rs.getInt("requesterId"), rs.getInt("resolverId"), rs.getDouble("reimbursementAmount"), rs.getString("category"), rs.getString("status"), rs.getDate("submitDate"), rs.getString("submitComment"), rs.getDate("resolveDate"), rs.getString("resolveComment")));
            }
            logger.info("All reimbursement data retrieved for pending reimbursements.");
            return reimbursements;
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
            System.err.println("SQL State: " + sqle.getSQLState());
            System.err.println("Error Code: " + sqle.getErrorCode());
            logger.error(sqle.getMessage() + " - SQL State: " + sqle.getSQLState() + " - Error Code: " + sqle.getErrorCode());
        }
        return null;
    }

    @Override
    public List<Reimbursement> getAllPending(int employeeId) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            List<Reimbursement> reimbursements = new ArrayList<>();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM REIMBURSEMENT WHERE status = 'pending' and REQUESTERID = " + employeeId + "  ORDER BY RID");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                reimbursements.add(new Reimbursement(rs.getInt("rId"), rs.getInt("requesterId"), rs.getInt("resolverId"), rs.getDouble("reimbursementAmount"), rs.getString("category"), rs.getString("status"), rs.getDate("submitDate"), rs.getString("submitComment"), rs.getDate("resolveDate"), rs.getString("resolveComment")));
            }
            logger.info("All reimbursement data retrieved for pending reimbursements for employeeId: " + employeeId);
            return reimbursements;
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
            System.err.println("SQL State: " + sqle.getSQLState());
            System.err.println("Error Code: " + sqle.getErrorCode());
            logger.error(sqle.getMessage() + " - SQL State: " + sqle.getSQLState() + " - Error Code: " + sqle.getErrorCode());
        }
        return null;
    }

    @Override
    public List<Reimbursement> getAllResolved() {
        try (Connection conn = ConnectionUtil.getConnection()) {
            List<Reimbursement> reimbursements = new ArrayList<>();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM REIMBURSEMENT WHERE status != 'pending' ORDER BY RID");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                reimbursements.add(new Reimbursement(rs.getInt("rId"), rs.getInt("requesterId"), rs.getInt("resolverId"), rs.getDouble("reimbursementAmount"), rs.getString("category"), rs.getString("status"), rs.getDate("submitDate"), rs.getString("submitComment"), rs.getDate("resolveDate"), rs.getString("resolveComment")));
            }
            logger.info("All reimbursement data retrieved for resolved reimbursements.");
            return reimbursements;
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
            System.err.println("SQL State: " + sqle.getSQLState());
            System.err.println("Error Code: " + sqle.getErrorCode());
            logger.error(sqle.getMessage() + " - SQL State: " + sqle.getSQLState() + " - Error Code: " + sqle.getErrorCode());
        }
        return null;
    }

    @Override
    public List<Reimbursement> getAllResolved(int employeeId) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            List<Reimbursement> reimbursements = new ArrayList<>();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM REIMBURSEMENT WHERE status != 'pending' and REQUESTERID = " + employeeId + "  ORDER BY RID");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                reimbursements.add(new Reimbursement(rs.getInt("rId"), rs.getInt("requesterId"), rs.getInt("resolverId"), rs.getDouble("reimbursementAmount"), rs.getString("category"), rs.getString("status"), rs.getDate("submitDate"), rs.getString("submitComment"), rs.getDate("resolveDate"), rs.getString("resolveComment")));
            }
            logger.info("All reimbursement data retrieved for resolve reimbursements for employeeId: " + employeeId);
            return reimbursements;
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
            System.err.println("SQL State: " + sqle.getSQLState());
            System.err.println("Error Code: " + sqle.getErrorCode());
            logger.error(sqle.getMessage() + " - SQL State: " + sqle.getSQLState() + " - Error Code: " + sqle.getErrorCode());
        }
        return null;
    }

    @Override
    public Reimbursement getReimbursement(int rId) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            Reimbursement reimbursement = new Reimbursement();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM REIMBURSEMENT WHERE RID = " + rId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                reimbursement.setrId(rs.getInt("rId"));
                reimbursement.setRequesterId(rs.getInt("requesterId"));
                reimbursement.setResolverId(rs.getInt("resolverId"));
                reimbursement.setReimbursementAmount(rs.getDouble("reimbursementAmount"));
                reimbursement.setCategory(rs.getString("category"));
                reimbursement.setStatus(rs.getString("status"));
                reimbursement.setSubmitDate(rs.getDate("submitDate"));
                reimbursement.setSubmitComment(rs.getString("submitComment"));
                reimbursement.setResolveDate(rs.getDate("resolveDate"));
                reimbursement.setResolveComment(rs.getString("resolveComment"));
            }
            logger.info("Reimbursement data retrieved for rId: " + rId);
            return reimbursement;
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
            System.err.println("SQL State: " + sqle.getSQLState());
            System.err.println("Error Code: " + sqle.getErrorCode());
            logger.error(sqle.getMessage() + " - SQL State: " + sqle.getSQLState() + " - Error Code: " + sqle.getErrorCode());
        }
        return null;
    }
}
