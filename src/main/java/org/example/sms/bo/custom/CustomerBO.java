package org.example.sms.bo.custom;

import org.example.sms.bo.SuperBO;
import org.example.sms.dto.CustomerDTO;

import java.sql.SQLException;
import java.util.List;

public interface CustomerBO extends SuperBO {
    boolean saveCustomer(CustomerDTO customerDTO) throws SQLException;

    boolean updateCustomer(CustomerDTO customerDTO) throws SQLException;

    List<CustomerDTO> getAllCustomer() throws SQLException;

    CustomerDTO searchCustomerId(String id) throws SQLException;

    boolean deleteCustomer(String id) throws SQLException;

    String generateNextCustomerId() throws SQLException;

    CustomerDTO searchCustomerNIC(String nic) throws SQLException;
}
