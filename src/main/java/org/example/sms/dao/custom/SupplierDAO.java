package org.example.sms.dao.custom;

import org.example.sms.dao.CrudDAO;
import org.example.sms.entity.Supplier;

import java.sql.SQLException;
import java.util.List;

public interface SupplierDAO extends CrudDAO<Supplier> {
    List<String> getSupplierName() throws SQLException;

    String getSupplierId(String supplier) throws SQLException;
}
