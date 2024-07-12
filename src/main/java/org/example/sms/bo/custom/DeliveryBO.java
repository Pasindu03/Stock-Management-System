package org.example.sms.bo.custom;

import org.example.sms.bo.SuperBO;

import java.sql.SQLException;

public interface DeliveryBO extends SuperBO {
    String generateNextDeliveryId() throws SQLException;
}
