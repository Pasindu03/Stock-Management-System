package org.example.sms.model;

import org.example.sms.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerModel {
    public static int totalCount() throws SQLException {
        String sql = "SELECT COUNT(customer_id) FROM customer ";
        ResultSet resultSet = CrudUtil.execute(sql);
        while (resultSet.next()){
            return resultSet.getInt(1);
        }
        return 0;
    }
}
