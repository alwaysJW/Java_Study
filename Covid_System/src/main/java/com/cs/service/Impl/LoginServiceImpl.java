package com.cs.service.Impl;

import com.cs.dao.Impl.LoginDaoImpl;
import com.cs.dao.LoginDao;
import com.cs.domain.Login;
import com.cs.service.LoginService;

public class LoginServiceImpl implements LoginService {
    private final LoginDao dao=new LoginDaoImpl();
    @Override
    public Login login(Login login) {
        return dao.login(login);
    }

    @Override
    public void register(Login login) {
        dao.register(login);
    }

    @Override
    public Login forget(Login login) {
        return dao.forget(login);
    }

    @Override
    public void findPass(Login login) {
        dao.findPass(login);
    }
}
