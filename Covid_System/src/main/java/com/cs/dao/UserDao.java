package com.cs.dao;

import com.cs.domain.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    int findTotalCount(Map<String, String[]> condition);

    List<User> findByPage(int start, int rows, Map<String, String[]> condition);

    void addUser(User user);

    User findById(int id);

    void update(User user);

    void deleteUser(int id);

    User findByNei(String neighbor);
}
