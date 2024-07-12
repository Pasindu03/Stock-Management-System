package org.example.sms.factory;

import org.example.sms.dao.SuperDAO;
import org.example.sms.dao.custom.Impl.*;
import org.example.sms.types.DAOTypes;

public class DAOFactory {
    public static DAOFactory factory;

    public DAOFactory(){}

    public static DAOFactory getDaoFactory(){
        return (factory == null) ? factory = new DAOFactory() : factory;
    }
    public SuperDAO getDAO(DAOTypes daoTypes){
        switch (daoTypes){
            case CUSTOMER:
                return new CustomerDAOImpl();
            case EMPLOYEE:
                return new EmployeeDAOImpl();
            case SUPPLIER:
                return new SupplierDAOImpl();
            case ITEM:
                return new ItemDAOImpl();
            case SUPPLIER_ORDER:
                return new SupplierOrderDAOImpl();
            case SUPPLIER_ORDER_DETAILS:
                return new SupplierOrderDetailsDAOImpl();
            case INVOICE:
                return new InvoiceDAOImpl();
            case HAVEPAYINVOICE:
                return new HavePayInvoiceDAOImpl();
            case ORDER:
                return new OrderDAOImpl();
            case DELIVERY:
                return new DeliveryDAOImpl();
            case PLACE_ORDER:
                return new PlaceOrderDAOImpl();
            default:
                return null;
        }
    }
}
