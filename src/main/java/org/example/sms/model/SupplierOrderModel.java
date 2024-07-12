package org.example.sms.model;

import org.example.sms.dto.DetailDTO;
import org.example.sms.dto.SupplierOrderDTO;
import org.example.sms.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierOrderModel {
    public static Boolean saveOrder(SupplierOrderDTO s1) throws SQLException {
        String sql = "INSERT INTO supplier_orders VALUES(?,?,?,?,?)";
        return CrudUtil.execute(sql,s1.getSup_order_id(),s1.getDate(),s1.getSupplierid(),s1.getAmount(),s1.getStatus());
    }

    public static boolean saveOrderDetail(ArrayList<DetailDTO> details, SupplierOrderDTO s1) throws SQLException {
        for(DetailDTO dto :  details) {
            if(!save(s1, dto)) {
                return false;
            }
        }
        return true;
    }

    private static boolean save(SupplierOrderDTO s1 , DetailDTO d1) throws SQLException {
        String sql = "INSERT INTO supplier_order_details VALUES (?, ?, ?, ?)";
        return CrudUtil.execute(sql,s1.getSup_order_id(),d1.getCode(),d1.getAmount(),d1.getQty());
    }

    public static String generateNextLoadId() throws SQLException {
        String sql = "SELECT supplier_order_id FROM supplier_orders ORDER BY supplier_order_id DESC LIMIT 1";
        ResultSet resultSet = CrudUtil.execute(sql);
        if (resultSet.next()){
            String id = resultSet.getString(1);
            return splitOrderId(id);
        }
        return splitOrderId(null);
    }

    public static String splitOrderId(String id){
        if (id != null){
            String[] strings = id.split("L");
            int index = Integer.parseInt(strings[1]);
            index++;
            String generated = String.format("L%03d", index);
            return generated ;
        }
        return "L001";
    }
}
