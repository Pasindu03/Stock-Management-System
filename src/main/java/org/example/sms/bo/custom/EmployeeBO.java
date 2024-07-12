package org.example.sms.bo.custom;

import org.example.sms.bo.SuperBO;
import org.example.sms.dto.EmployeeDTO;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeBO extends SuperBO {
    boolean saveEmployee(EmployeeDTO employeeDTO) throws SQLException;

    List<EmployeeDTO> getAllEployee() throws SQLException;

    boolean updateEmployee(EmployeeDTO employeeDTO) throws SQLException;

    boolean deleteEmployee(String id) throws SQLException;

    EmployeeDTO searchEmployee(String id) throws SQLException;

    String generateNextEmployeeId() throws SQLException;
}
