package org.example.sms.bo.custom.Impl;

import org.example.sms.bo.custom.DeliveryBO;
import org.example.sms.dao.custom.DeliveryDAO;
import org.example.sms.factory.DAOFactory;
import org.example.sms.types.DAOTypes;

import java.sql.SQLException;

public class DeliveryBOImpl implements DeliveryBO {

    DeliveryDAO deliveryDAO = (DeliveryDAO) DAOFactory.getDaoFactory().getDAO(DAOTypes.DELIVERY);
    @Override
    public String generateNextDeliveryId() throws SQLException {
        return deliveryDAO.generateNextId();
    }
}
