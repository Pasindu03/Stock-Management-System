package org.example.sms.dao.custom;

import org.example.sms.dao.CrudDAO;
import org.example.sms.dto.CartDTO;
import org.example.sms.entity.Details;
import org.example.sms.entity.Item;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface ItemDAO extends CrudDAO<Item> {
    List<Item> getitemBySupplierID(String text) throws SQLException;

    Optional<Item> searchByPk(String id) throws SQLException;

    boolean updateQty(Details details) throws SQLException;

    boolean updateqty(List<CartDTO> cartDTOList) throws SQLException;

    boolean saveoditem(String oId, List<CartDTO> cartDTOList) throws SQLException;
}
