package com.sms.service;

import com.sms.domain.User;

public interface UserService {
    User login(User user);

    void register(User user);
}
