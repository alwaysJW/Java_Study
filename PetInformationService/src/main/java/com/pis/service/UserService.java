package com.pis.service;

import com.pis.domain.PageBean;
import com.pis.domain.User;

import java.util.Map;

public interface UserService {
    PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> condition);

    User findUserById(String id);

    void deleteUser(String id);

    void updateUser(User user);

    void addUser(User user);
}
