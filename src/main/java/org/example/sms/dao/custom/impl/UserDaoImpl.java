package org.example.sms.dao.custom.impl;

import org.example.sms.dao.custom.UserDao;
import org.example.sms.entity.User;

import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public String generateNextId() throws Exception {
        return "";
    }

    @Override
    public List<User> getAll() throws Exception {
        return List.of();
    }

    @Override
    public boolean save(User book) throws Exception {
        return false;
    }

    @Override
    public boolean delete(User book) throws Exception {
        return false;
    }

    @Override
    public boolean update(User book) throws Exception {
        return false;
    }

    @Override
    public User search(String id) throws Exception {
        return null;
    }
}
