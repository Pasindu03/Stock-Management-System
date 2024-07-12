package org.example.sms.bo.custom.Impl;

import org.example.sms.bo.custom.PlaceOrderBO;
import org.example.sms.dao.custom.PlaceOrderDAO;
import org.example.sms.dto.DeliveryDTO;
import org.example.sms.dto.PlaceOrderDTO;
import org.example.sms.entity.Delivery;
import org.example.sms.entity.PlaceOrder;
import org.example.sms.factory.DAOFactory;
import org.example.sms.types.DAOTypes;

import java.sql.SQLException;

public class PlaceOrderBOImpl implements PlaceOrderBO {
    PlaceOrderDAO placeOrderDAO = (PlaceOrderDAO) DAOFactory.getDaoFactory().getDAO(DAOTypes.PLACE_ORDER);
    @Override
    public boolean placeOrder(PlaceOrderDTO placeOrderDTO, DeliveryDTO deliveryDTO) throws SQLException {
        return placeOrderDAO.placeOrder(new PlaceOrder(placeOrderDTO.getId(), placeOrderDTO.getDate(),placeOrderDTO.getTime(),placeOrderDTO.getCustId(), placeOrderDTO.getStatus()),
                new Delivery(deliveryDTO.getId(),deliveryDTO.getDistance(),deliveryDTO.getAmount()));
    }
}
