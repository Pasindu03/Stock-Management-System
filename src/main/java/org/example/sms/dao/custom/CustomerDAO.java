package org.example.sms.dao.custom;

import org.example.sms.dao.CrudDAO;
import org.example.sms.entity.Customer;

import java.sql.SQLException;

public interface CustomerDAO extends CrudDAO<Customer> {
    Customer searchCustomerNIC(String nic) throws SQLException;
}
