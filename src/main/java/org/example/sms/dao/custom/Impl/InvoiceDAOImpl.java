package org.example.sms.dao.custom.Impl;

import org.example.sms.dao.custom.InvoiceDAO;
import org.example.sms.entity.Invoice;
import org.example.sms.util.CrudUtil;

import java.sql.SQLException;
import java.util.ArrayList;

public class InvoiceDAOImpl implements InvoiceDAO {
    @Override
    public boolean save(Invoice entity) throws SQLException {
        String sql = "INSERT INTO invoice VALUES (?,?,?,?)";
        return CrudUtil.execute(sql, entity.getId(),entity.getDate(), entity.getSupid(),entity.getAmount());
    }

    @Override
    public boolean update(Invoice entity) throws SQLException {
        return false;
    }

    @Override
    public ArrayList<Invoice> getAll() throws SQLException {
        return null;
    }

    @Override
    public Invoice search(String id) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }

    @Override
    public String generateNextId() throws SQLException {
        return null;
    }
}
