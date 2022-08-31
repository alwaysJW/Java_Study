package com.sms.service.Impl;

import com.sms.dao.Impl.UserDaoImpl;
import com.sms.dao.UserDao;
import com.sms.domain.User;
import com.sms.service.UserService;

public class UserServiceImpl implements UserService {
    private final UserDao dao=new UserDaoImpl();
    @Override
    public User login(User user) {

        return dao.findToLogin(user);
    }

    @Override
    public void register(User user) {
        dao.register(user);
    }
}
