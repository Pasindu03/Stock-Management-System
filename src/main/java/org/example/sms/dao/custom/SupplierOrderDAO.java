package org.example.sms.dao.custom;

import org.example.sms.dao.CrudDAO;
import org.example.sms.entity.Details;
import org.example.sms.entity.Invoice;
import org.example.sms.entity.SupplierOrder;

import java.sql.SQLException;

public interface SupplierOrderDAO extends CrudDAO<SupplierOrder> {
    boolean placeSupplierOrder(SupplierOrder s1, Invoice invoice, Details details) throws SQLException;

}
