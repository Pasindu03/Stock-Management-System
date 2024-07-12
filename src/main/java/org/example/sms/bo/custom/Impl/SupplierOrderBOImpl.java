package org.example.sms.bo.custom.Impl;

import org.example.sms.bo.custom.SupplierOrderBO;
import org.example.sms.dao.custom.SupplierOrderDAO;
import org.example.sms.dto.DetailDTO;
import org.example.sms.dto.InvoiceDTO;
import org.example.sms.dto.SupplierOrderDTO;
import org.example.sms.entity.Details;
import org.example.sms.entity.Invoice;
import org.example.sms.entity.SupplierOrder;
import org.example.sms.factory.DAOFactory;
import org.example.sms.types.DAOTypes;

import java.sql.SQLException;

public class SupplierOrderBOImpl implements SupplierOrderBO {
    SupplierOrderDAO supplierOrderDAO = (SupplierOrderDAO) DAOFactory.getDaoFactory().getDAO(DAOTypes.SUPPLIER_ORDER);
    @Override
    public String generateNextLoadId() throws SQLException {
        return supplierOrderDAO.generateNextId();
    }

    @Override
    public boolean placeSupplierOrder(SupplierOrderDTO supplierOrder, InvoiceDTO invoice, DetailDTO detailDTO) throws SQLException {
        return supplierOrderDAO.placeSupplierOrder(new SupplierOrder(supplierOrder.getSup_order_id(),supplierOrder.getDate(),supplierOrder.getSupplierid(),supplierOrder.getAmount(),supplierOrder.getStatus()),new Invoice(invoice.getId(),invoice.getDate(),invoice.getSupid(),invoice.getAmount()), new Details(detailDTO.getSo_id(),detailDTO.getCode(),detailDTO.getAmount(),detailDTO.getQty()));
    }
}
