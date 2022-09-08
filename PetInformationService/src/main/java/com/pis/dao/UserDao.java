package com.pis.dao;

import com.pis.domain.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    int findTotalCount(Map<String, String[]> condition);
    List<User> findByPage(int start, int rows, Map<String, String[]> condition);

    User findUserById(int id);

    void deleteUser(int id);

    void updateUser(User user);

    void addUser(User user);
}
