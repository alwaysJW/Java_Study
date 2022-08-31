package com.sms.dao;

import com.sms.domain.User;

public interface UserDao {
    User findToLogin(User user);

    void register(User user);
}
