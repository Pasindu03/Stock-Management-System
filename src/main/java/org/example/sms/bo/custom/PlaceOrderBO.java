package org.example.sms.bo.custom;

import org.example.sms.bo.SuperBO;
import org.example.sms.dto.DeliveryDTO;
import org.example.sms.dto.PlaceOrderDTO;

import java.sql.SQLException;

public interface PlaceOrderBO extends SuperBO {
    boolean placeOrder(PlaceOrderDTO placeOrderDTO, DeliveryDTO deliveryDTO) throws SQLException;
}
