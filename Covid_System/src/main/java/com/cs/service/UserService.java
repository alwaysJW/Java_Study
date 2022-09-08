package com.cs.service;

import com.cs.domain.PageBean;
import com.cs.domain.User;

import java.util.Map;

public interface UserService {
    PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> condition);

    void addUser(User user);

    User findUserById(String id);

    void updateUser(User user);

    void deleteUser(String id);

    void delSelectedUser(String[] ids);

    User findUserByNei(String neighbor);
}
