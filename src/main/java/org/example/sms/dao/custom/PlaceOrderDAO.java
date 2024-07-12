package org.example.sms.dao.custom;

import org.example.sms.dao.CrudDAO;
import org.example.sms.entity.Delivery;
import org.example.sms.entity.PlaceOrder;

import java.sql.SQLException;

public interface PlaceOrderDAO extends CrudDAO<PlaceOrder> {
    boolean placeOrder(PlaceOrder placeOrder, Delivery delivery) throws SQLException;
}
