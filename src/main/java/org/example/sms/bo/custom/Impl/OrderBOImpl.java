package org.example.sms.bo.custom.Impl;

import org.example.sms.bo.custom.OrderBO;
import org.example.sms.dao.custom.OrderDAO;
import org.example.sms.factory.DAOFactory;
import org.example.sms.types.DAOTypes;

import java.sql.SQLException;

public class OrderBOImpl implements OrderBO {

    OrderDAO orderDAO = (OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOTypes.ORDER);
    @Override
    public String generateNextOrderId() throws SQLException {
        return orderDAO.generateNextId();
    }
}
