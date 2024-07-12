package org.example.sms.bo.custom;

import org.example.sms.bo.SuperBO;
import org.example.sms.dto.DetailDTO;
import org.example.sms.dto.InvoiceDTO;
import org.example.sms.dto.SupplierOrderDTO;

import java.sql.SQLException;

public interface SupplierOrderBO extends SuperBO {
    String generateNextLoadId() throws SQLException;

    boolean placeSupplierOrder(SupplierOrderDTO supplierOrder, InvoiceDTO invoice, DetailDTO detailDTO) throws SQLException;
}
