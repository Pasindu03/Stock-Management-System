package org.example.sms.factory;

import org.example.sms.bo.SuperBO;
import org.example.sms.bo.custom.Impl.*;
import org.example.sms.types.BOTypes;

public class BOFactory {
    public static BOFactory boFactory;

    public BOFactory(){}

    public static BOFactory getBoFactory(){
        return (boFactory == null) ? boFactory = new BOFactory() : boFactory;
    }

    public SuperBO getBO(BOTypes boTypes){
        switch (boTypes){
            case CUSTOMER:
                return new CustomerBOImpl();
            case EMPLOYEE:
                return new EmployeeBOImpl();
            case SUPPLIER:
                return new SupplierBOImpl();
            case ITEM:
                return new ItemBOImpl();
            case SUPPLIER_ORDER:
                return new SupplierOrderBOImpl();
            case ORDER:
                return new OrderBOImpl();
            case DELIVERY:
                return new DeliveryBOImpl();
            case PLACE_ORDER:
                return new PlaceOrderBOImpl();
            default:
                return null;
        }
    }
}
