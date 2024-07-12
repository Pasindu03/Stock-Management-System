package org.example.sms.dao.custom.Impl;

import org.example.sms.dao.custom.DeliveryDAO;
import org.example.sms.dao.custom.ItemDAO;
import org.example.sms.dao.custom.OrderDAO;
import org.example.sms.dao.custom.PlaceOrderDAO;
import org.example.sms.db.DbConnection;
import org.example.sms.entity.Delivery;
import org.example.sms.entity.Order;
import org.example.sms.entity.PlaceOrder;
import org.example.sms.factory.DAOFactory;
import org.example.sms.types.DAOTypes;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.example.sms.controller.DeliveryManageFormController.cartDTOList;

public class PlaceOrderDAOImpl implements PlaceOrderDAO {

    OrderDAO orderDAO = (OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOTypes.ORDER);

    ItemDAO itemDAO =(ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOTypes.ITEM);

    DeliveryDAO deliveryDAO = (DeliveryDAO) DAOFactory.getDaoFactory().getDAO(DAOTypes.DELIVERY);
    @Override
    public boolean save(PlaceOrder entity) throws SQLException {
        return false;
    }

    @Override
    public boolean update(PlaceOrder entity) throws SQLException {
        return false;
    }

    @Override
    public ArrayList<PlaceOrder> getAll() throws SQLException {
        return null;
    }

    @Override
    public PlaceOrder search(String id) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }

    @Override
    public String generateNextId() throws SQLException {
        return null;
    }

    @Override
    public boolean placeOrder(PlaceOrder placeOrder, Delivery delivery) throws SQLException {
        try{
            DbConnection.getInstance().getConnection().setAutoCommit(false);
            boolean saveOrder = orderDAO.save(new Order(placeOrder.getId(), placeOrder.getDate(),placeOrder.getTime(), placeOrder.getCustId(), placeOrder.getStatus()));
            if (saveOrder){
                System.out.println("Done 1");
                boolean updateqty = itemDAO.updateqty(cartDTOList);
                if (updateqty){
                    System.out.println("Done 2");
                    boolean saveoditem = itemDAO.saveoditem(placeOrder.getId(), cartDTOList);
                    if (saveoditem){
                        System.out.println("Done 3");
                        String status = placeOrder.getStatus();
                        if (status.equals("Yes")){
                            boolean savedelivery = deliveryDAO.savedelivery(delivery);
                            if (savedelivery){
                                System.out.println("Done 4");
                                DbConnection.getInstance().getConnection().commit();
                                return true;
                            }
                        }else {
                            System.out.println("Done 5");
                            DbConnection.getInstance().getConnection().commit();
                            return true;
                        }
                    }
                }
            }
            DbConnection.getInstance().getConnection().rollback();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DbConnection.getInstance().getConnection().setAutoCommit(true);
        }
        return false;
    }
}
