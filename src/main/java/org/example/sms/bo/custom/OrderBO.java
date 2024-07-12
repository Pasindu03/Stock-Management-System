package org.example.sms.bo.custom;

import org.example.sms.bo.SuperBO;

import java.sql.SQLException;

public interface OrderBO extends SuperBO {
    String generateNextOrderId() throws SQLException;
}
