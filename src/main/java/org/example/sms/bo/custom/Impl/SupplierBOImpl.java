package org.example.sms.bo.custom.Impl;

import org.example.sms.bo.custom.SupplierBO;
import org.example.sms.dao.custom.SupplierDAO;
import org.example.sms.dto.SupplierDTO;
import org.example.sms.entity.Supplier;
import org.example.sms.factory.DAOFactory;
import org.example.sms.types.DAOTypes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierBOImpl implements SupplierBO {

    SupplierDAO supplierDAO = (SupplierDAO) DAOFactory.getDaoFactory().getDAO(DAOTypes.SUPPLIER);
    @Override
    public boolean saveSupplier(SupplierDTO supplierDTO) throws SQLException {
        return supplierDAO.save(new Supplier(supplierDTO.getId(),supplierDTO.getSupplierName(),supplierDTO.getSupplierCompany(),supplierDTO.getContact()));
    }

    @Override
    public boolean updateSupplier(SupplierDTO supplierDTO) throws SQLException {
        return supplierDAO.update(new Supplier(supplierDTO.getId(),supplierDTO.getSupplierName(),supplierDTO.getSupplierCompany(),supplierDTO.getContact()));
    }

    @Override
    public boolean deleteSupplier(String id) throws SQLException {
        return supplierDAO.delete(id);
    }

    @Override
    public ArrayList<SupplierDTO> getAllSupplier() throws SQLException {
        ArrayList<SupplierDTO> supplierDTOS = new ArrayList<>();
        ArrayList<Supplier> suppliers = supplierDAO.getAll();
        for (Supplier sup: suppliers) {
            supplierDTOS.add(new SupplierDTO(sup.getId(),sup.getSupplierName(),sup.getSupplierCompany(),sup.getContact()));
        }
        return supplierDTOS;
    }

    @Override
    public SupplierDTO searchSupplier(String id) throws SQLException {
        Supplier supplier = supplierDAO.search(id);
        return new SupplierDTO(supplier.getId(),supplier.getSupplierName(),supplier.getSupplierCompany(),supplier.getContact());
    }

    @Override
    public String generateNextSupplierId() throws SQLException {
        return supplierDAO.generateNextId();
    }

    @Override
    public List<String> getSupplierName() throws SQLException {
        return supplierDAO.getSupplierName();
    }

    @Override
    public String getSupplierId(String supplier) throws SQLException {
        return supplierDAO.getSupplierId(supplier);
    }


}