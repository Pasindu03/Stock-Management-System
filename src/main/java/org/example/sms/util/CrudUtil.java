package org.example.sms.util;

import org.example.sms.db.DbConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CrudUtil {
    public static <T>T execute(String sql,Object... args) throws SQLException {
        PreparedStatement preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(sql);

        for (int i = 0; i < args.length; i++) {
            preparedStatement.setObject((i+1), args[i]);
        }
        if (sql.startsWith("SELECT") || sql.startsWith("select")){
            return (T) preparedStatement.executeQuery(); // resultSet
        }
        return (T) (Boolean) (preparedStatement.executeUpdate() > 0);// boolean
    }
}
