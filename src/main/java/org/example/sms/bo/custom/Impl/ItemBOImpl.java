package org.example.sms.bo.custom.Impl;

import org.example.sms.bo.custom.ItemBO;
import org.example.sms.dao.custom.ItemDAO;
import org.example.sms.dto.ItemDTO;
import org.example.sms.entity.Item;
import org.example.sms.factory.DAOFactory;
import org.example.sms.types.DAOTypes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemBOImpl implements ItemBO {

    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOTypes.ITEM);
    @Override
    public ArrayList<ItemDTO> getAllItem() throws SQLException {
        ArrayList<Item> items = itemDAO.getAll();
        ArrayList<ItemDTO> itemDTOS = new ArrayList<>();
        for (Item item :items) {
            itemDTOS.add(new ItemDTO(item.getItemCode(), item.getItemName(), item.getSellPrice(), item.getGetPrice(), item.getItemType(), item.getSupplier(), item.getQuantity()));
        }
        return itemDTOS;
    }

    @Override
    public boolean deleteItem(String itemCode) throws SQLException {
        return itemDAO.delete(itemCode);
    }

    @Override
    public ItemDTO searchItem(String code) throws SQLException {
        Item item = itemDAO.search(code);
        return new ItemDTO(item.getItemCode(), item.getItemName(), item.getSellPrice(), item.getGetPrice(), item.getItemType(), item.getSupplier(), item.getQuantity());
    }

    @Override
    public String generateNextItemId() throws SQLException {
        return itemDAO.generateNextId();
    }

    @Override
    public boolean saveItem(ItemDTO itemDTO) throws SQLException {
        return itemDAO.save(new Item(itemDTO.getItemCode(), itemDTO.getItemName(), itemDTO.getSellPrice(), itemDTO.getGetPrice(), itemDTO.getItemType(), itemDTO.getSupplier(), itemDTO.getQuantity()));
    }

    @Override
    public boolean updateItem(ItemDTO itemDTO) throws SQLException {
        return itemDAO.update(new Item(itemDTO.getItemCode(), itemDTO.getItemName(), itemDTO.getSellPrice(), itemDTO.getGetPrice(), itemDTO.getItemType(), itemDTO.getSupplier(), itemDTO.getQuantity()));
    }

    @Override
    public List<ItemDTO> getitemBySupplierID(String text) throws SQLException {
        List<Item> items = itemDAO.getitemBySupplierID(text);
        List<ItemDTO> itemDTOS = new ArrayList<>();
        for (Item item: items) {
            itemDTOS.add(new ItemDTO(item.getItemCode(),item.getItemName(),item.getSellPrice(), item.getGetPrice(), item.getItemType(),item.getSupplier(),item.getQuantity()));
        }
        return itemDTOS;
    }

    @Override
    public Optional<ItemDTO> searchByPk(String id) throws SQLException {
        Optional<Item> item = itemDAO.searchByPk(id);
        if (!item.equals(Optional.empty())) {
            return Optional.of(new ItemDTO(item.get().getItemCode(), item.get().getItemName(), item.get().getSellPrice(), item.get().getGetPrice(), item.get().getItemType(), item.get().getSupplier(), item.get().getQuantity()));
        }
        return Optional.empty();
    }

    @Override
    public List<String> getCodes() throws SQLException {
        ArrayList<Item> items = itemDAO.getAll();
        List<String> itemCodes = new ArrayList<>();
        for (Item item: items) {
            itemCodes.add(item.getItemCode());
        }
        return itemCodes;
    }
}
