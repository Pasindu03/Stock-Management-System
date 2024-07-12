package org.example.sms.dao.custom;

import org.example.sms.dao.CrudDAO;
import org.example.sms.entity.Delivery;

import java.sql.SQLException;

public interface DeliveryDAO extends CrudDAO<Delivery> {
    boolean savedelivery(Delivery delivery) throws SQLException;
}
